package com.kruger.ec.controller.core;

import com.kruger.ec.dto.core.KgrtVaccinationDto;
import com.kruger.ec.service.core.service.KgrtVaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE,
        RequestMethod.OPTIONS})
@RequestMapping(value = "KgrtVaccination")
public class KgrtVaccinationController {

    @Autowired
    private KgrtVaccinationService serviceI;

    @GetMapping("/listar")
    public List<KgrtVaccinationDto> listar() {
        return serviceI.findAll();
    }

    @GetMapping("/ver/{id}")
    public KgrtVaccinationDto detalle(@PathVariable Long id) {
        KgrtVaccinationDto obj = serviceI.findById(id);
        return obj;
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public KgrtVaccinationDto crear(@RequestBody KgrtVaccinationDto obj) {
        return serviceI.create(obj);
    }

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public KgrtVaccinationDto editar(@RequestBody KgrtVaccinationDto obj, @PathVariable Integer id) throws InvocationTargetException, IllegalAccessException {
        return serviceI.update(obj);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        serviceI.delete(id);
    }

}
