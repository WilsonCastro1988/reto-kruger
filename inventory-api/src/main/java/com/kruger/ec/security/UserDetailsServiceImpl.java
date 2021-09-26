package com.kruger.ec.security;

import com.kruger.ec.service.admin.service.UsuarioPerfilService;
import com.kruger.ec.service.admin.service.UsuarioService;
import com.kruger.ec.dto.admin.PerfilDto;
import com.kruger.ec.dto.admin.UsuarioDto;
import com.kruger.ec.dto.security.RolDTO;
import com.kruger.ec.dto.security.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    UsuarioPerfilService usuarioPerfilService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsuarioDto usuario = usuarioService.getByEmail(email).orElseThrow(() -> new UsernameNotFoundException("email no encontrado"));
        List<PerfilDto> listPerfil = usuarioPerfilService.obtenerPorUsername(usuario.getNombreUsuario());


        UsuarioDTO userDTO = new UsuarioDTO();
        userDTO.setEmail(usuario.getEmail());
        userDTO.setPassword(usuario.getPassword());

        List<RolDTO> listRolesDTO = new ArrayList<>();
        for (PerfilDto p : listPerfil) {
            RolDTO rolDto = new RolDTO();
            rolDto.setId(p.getIdPerfil());
            rolDto.setRolNombre(p.getNombrePerfil());

            listRolesDTO.add(rolDto);
        }

        userDTO.setRoles(listRolesDTO);


        return UsuarioPrincipalFactory.build(userDTO);
    }
}
