package com.kruger.ec.controller.admin;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.kruger.ec.dto.admin.PerfilDto;
import com.kruger.ec.dto.admin.UsuarioPerfilDto;
import com.kruger.ec.entity.admin.UsuarioPerfilPK;
import com.kruger.ec.service.admin.service.UsuarioPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE,
        RequestMethod.OPTIONS})
@RequestMapping(value = "usuario-perfil")
public class UsuarioPerfilController {

    @Autowired
    private UsuarioPerfilService serviceI;

    @GetMapping("/listar")
    public List<UsuarioPerfilDto> listar() {
        return serviceI.findAll();
    }

    @GetMapping("/ver/{id}")
    public UsuarioPerfilDto detalle(@PathVariable UsuarioPerfilPK id) {
        UsuarioPerfilDto entitie = serviceI.findById(id);
        return entitie;
    }

    @GetMapping("/obtenerPorUsername/{username}")
    public List<PerfilDto> detalle(@PathVariable String username) {
        List<PerfilDto> entitie = serviceI.obtenerPorUsername(username);
        return entitie;
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioPerfilDto crear(@RequestBody UsuarioPerfilDto obj) {
        return serviceI.create(obj);
    }

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioPerfilDto editar(@RequestBody UsuarioPerfilDto obj, @PathVariable UsuarioPerfilPK id) throws InvocationTargetException, IllegalAccessException {
        return serviceI.update(obj);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable UsuarioPerfilPK id) {
        serviceI.delete(id);
    }

}
