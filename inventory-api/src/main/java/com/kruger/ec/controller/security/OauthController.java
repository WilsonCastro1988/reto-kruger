package com.kruger.ec.controller.security;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.kruger.ec.dto.admin.UsuarioDto;
import com.kruger.ec.dto.security.JwtDto;
import com.kruger.ec.dto.security.ResponseMessage;
import com.kruger.ec.dto.security.TokenDTO;
import com.kruger.ec.security.jwt.JwtProvider;
import com.kruger.ec.service.admin.service.PerfilService;
import com.kruger.ec.service.admin.service.UsuarioPerfilService;
import com.kruger.ec.service.admin.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Collections;

@RestController
@RequestMapping("/oauth")
@CrossOrigin
public class OauthController {

    @Value("${google.clientId}")
    String googleClientId;

    @Value("${secretPsw}")
    String secretPsw;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PerfilService rolService;

    @Autowired
    UsuarioPerfilService usuarioPerfilService;

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody UsuarioDto loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new ResponseMessage("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }


    @PostMapping("/google")
    public ResponseEntity<TokenDTO> google(@RequestBody TokenDTO tokenDto) throws IOException {
        final NetHttpTransport transport = new NetHttpTransport();
        final JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();
        GoogleIdTokenVerifier.Builder verifier =
                new GoogleIdTokenVerifier.Builder(transport, jacksonFactory)
                        .setAudience(Collections.singletonList(googleClientId));
        final GoogleIdToken googleIdToken = GoogleIdToken.parse(verifier.getJsonFactory(), tokenDto.getValue());
        final GoogleIdToken.Payload payload = googleIdToken.getPayload();


        UsuarioDto usuario = new UsuarioDto();
        if (usuarioService.existsEmail(payload.getEmail())) {
            usuario = usuarioService.getByEmail(payload.getEmail()).get();
        } else {
            usuario = saveUsuario(payload.getEmail());
        }

        TokenDTO tokenRes = login(usuario);
        System.out.println("TOKEN OBTENIDO" + tokenRes.getValue());

        return new ResponseEntity(tokenRes, HttpStatus.OK);
    }

    @PostMapping("/facebook")
    public ResponseEntity<TokenDTO> facebook(@RequestBody TokenDTO tokenDto) throws IOException {
        Facebook facebook = new FacebookTemplate(tokenDto.getValue());
        final String[] fields = {"email", "picture"};
        User user = facebook.fetchObject("me", User.class, fields);
        UsuarioDto usuario = new UsuarioDto();
        if (usuarioService.existsEmail(user.getEmail()))
            usuario = usuarioService.getByEmail(user.getEmail()).get();
        else
            usuario = saveUsuario(user.getEmail());
        TokenDTO tokenRes = login(usuario);
        return new ResponseEntity(tokenRes, HttpStatus.OK);
    }

    private TokenDTO login(UsuarioDto usuario) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario.getEmail(), secretPsw)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        TokenDTO tokenDto = new TokenDTO();
        tokenDto.setValue(jwt);
        return tokenDto;
    }

    private UsuarioDto saveUsuario(String email) {
        UsuarioDto usuario = new UsuarioDto();

        usuario.setNombreUsuario(email);
        usuario.setEmail(email);
        usuario.setPassword(passwordEncoder.encode(secretPsw));
        // Perfil perfil = rolService.findByNombrePerfil(NombrePerfil.ROLE_USER.toString()).get();


        System.out.println("DATOS PARA PASAR A BDD: " + usuario);
        //  System.out.println("DATOS PARA PASAR A BDD: "+perfil);


        UsuarioDto usuariodb = usuarioService.create(usuario);

      /*  UsuarioPerfilPK pk = new UsuarioPerfilPK();
        pk.setIdPerfil(perfil.getIdPerfil());
        pk.setNombreUsuario(usuariodb.getNombreUsuario());

        UsuarioPerfil usuarioPerfil = new UsuarioPerfil();
        usuarioPerfil.setActivoPerfilUsuario(true);
        usuarioPerfil.setPerfil(perfil);
        usuarioPerfil.setUsuario(usuariodb);
        usuarioPerfil.setUsuarioPerfilPK(pk);

        usuarioPerfilService.create(usuarioPerfil);*/

        return usuariodb;
    }

}
