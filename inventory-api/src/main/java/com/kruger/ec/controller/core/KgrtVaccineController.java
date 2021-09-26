package com.kruger.ec.controller.core;

import com.kruger.ec.dto.core.KgrtVaccineDto;
import com.kruger.ec.service.core.service.KgrtVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE,
        RequestMethod.OPTIONS})
@RequestMapping(value = "KgrtVaccine")
public class KgrtVaccineController {

    @Autowired
    private KgrtVaccineService serviceI;

    @GetMapping("/listar")
    public List<KgrtVaccineDto> listar() {
        return serviceI.findAll();
    }

    @GetMapping("/ver/{id}")
    public KgrtVaccineDto detalle(@PathVariable Long id) {
        KgrtVaccineDto obj = serviceI.findById(id);
        return obj;
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public KgrtVaccineDto crear(@RequestBody KgrtVaccineDto obj) {
        return serviceI.create(obj);
    }

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public KgrtVaccineDto editar(@RequestBody KgrtVaccineDto obj, @PathVariable Integer id) throws InvocationTargetException, IllegalAccessException {
        return serviceI.update(obj);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        serviceI.delete(id);
    }

}
