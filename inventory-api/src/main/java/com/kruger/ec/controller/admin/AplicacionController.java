package com.kruger.ec.controller.admin;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.kruger.ec.dto.admin.AplicacionDto;
import com.kruger.ec.service.admin.service.AplicacionService;
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
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,
        RequestMethod.OPTIONS})
@RequestMapping(value = "aplicacion")
public class AplicacionController {

    @Autowired
    private AplicacionService serviceI;

    @GetMapping("/listar")
    public List<AplicacionDto> listar() {
        return serviceI.findAll();
    }

    @GetMapping("/ver/{id}")
    public AplicacionDto detalle(@PathVariable Integer id) {
        AplicacionDto obj = serviceI.findById(id);
        return obj;
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public AplicacionDto crear(@RequestBody AplicacionDto obj) {
        return serviceI.create(obj);
    }

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public AplicacionDto editar(@RequestBody AplicacionDto obj, @PathVariable Integer id) throws InvocationTargetException, IllegalAccessException {
        return serviceI.update(obj);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        serviceI.delete(id);
    }

}
