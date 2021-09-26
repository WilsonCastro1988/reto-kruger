package com.kruger.ec.controller.core;

import com.kruger.ec.dto.admin.UsuarioDto;
import com.kruger.ec.dto.admin.UsuarioPerfilDto;
import com.kruger.ec.dto.core.KgrtEmployeeDto;
import com.kruger.ec.entity.admin.UsuarioPerfilPK;
import com.kruger.ec.service.admin.service.UsuarioPerfilService;
import com.kruger.ec.service.admin.service.UsuarioService;
import com.kruger.ec.service.core.service.KgrtEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,
        RequestMethod.OPTIONS})
@RequestMapping(value = "KgrtEmployee")
public class KgrtEmployeeController {

    @Autowired
    private KgrtEmployeeService serviceI;
    @Autowired
    private UsuarioService userI;
    @Autowired
    private UsuarioPerfilService userPerfilI;
    @Autowired
    PasswordEncoder passwordEncoder;


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listar")
    public List<KgrtEmployeeDto> listar() {
        return serviceI.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/ver/{id}")
    public KgrtEmployeeDto detalle(@PathVariable String id) {
        KgrtEmployeeDto obj = serviceI.findById(id);
        return obj;
    }

   // @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public KgrtEmployeeDto crear(@RequestBody KgrtEmployeeDto obj) {
        obj.setAudidCreationDate(new Date());
        obj.setAudivUserCreation("ADMIN");
        return serviceI.create(obj);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/empuser")
    @ResponseStatus(HttpStatus.CREATED)
    public KgrtEmployeeDto crearEmployeeAndUser(@RequestBody KgrtEmployeeDto obj) {
        obj.setAudidCreationDate(new Date());
        obj.setAudivUserCreation("ADMIN");

        UsuarioDto userDTO = new UsuarioDto();
        UsuarioPerfilDto userPerfilDTO = new UsuarioPerfilDto();
        UsuarioPerfilPK pk = new UsuarioPerfilPK();

        userDTO.setNombreUsuario(obj.getEmployeevMail());
        userDTO.setActivoUsuario(true);
        userDTO.setApellidosUsuario(obj.getEmployeevLastname());
        userDTO.setDniUsuario(obj.getEmployeevDni());
        userDTO.setEmail(obj.getEmployeevMail());
        userDTO.setEmailPersonalUsuario(obj.getEmployeevMail());
        userDTO.setFaUsuario(false);
        userDTO.setFechaActualizacionUsuario(null);
        userDTO.setFechaCreacionUsuario(new Date());
        userDTO.setFotoUsuario("assets/img/perfil.png");
        userDTO.setIntentosUsuario(0);
        userDTO.setNombresUsuario(obj.getEmployeevName());
        userDTO.setPassword(null);
        userDTO.setTipo2faUsuario(null);
        userDTO.setTipoDniUsuario("cedula");
        userDTO.setPassword(passwordEncoder.encode("kruger2021**"));

        userI.create(userDTO);

        pk.setIdPerfil(2);
        pk.setNombreUsuario(userDTO.getNombreUsuario());
        userPerfilDTO.setUsuarioPerfilPK(pk);

        userPerfilDTO.setActivoPerfilUsuario(true);
        userPerfilI.create(userPerfilDTO);

        obj.setFlagemployeevUser(userDTO.getNombreUsuario());




        return serviceI.create(obj);
    }


    @PostMapping("/verEmp")
    public KgrtEmployeeDto verEmp(@RequestBody UsuarioDto obj) {
        return serviceI.findByFlagemployeevUser(obj).get();
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public KgrtEmployeeDto editar(@RequestBody KgrtEmployeeDto obj, @PathVariable Integer id) throws InvocationTargetException, IllegalAccessException {
        obj.setAudidModificationDate(new Date());
        obj.setAudivUserModification("ADMIN");
        return serviceI.update(obj);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable String id) {

        /*KgrtEmployeeDto employeeDto = serviceI.findById(id);
        if (!employeeDto.getFlagemployeevUser().equals("") || employeeDto.getFlagemployeevUser() != null) {
            userI.delete(id);
        }*/
        serviceI.delete(id);
    }

}
