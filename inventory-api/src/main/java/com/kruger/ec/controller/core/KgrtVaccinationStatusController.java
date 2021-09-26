package com.kruger.ec.controller.core;

import com.kruger.ec.dto.core.KgrtVaccinationStatusDto;
import com.kruger.ec.service.core.service.KgrtVaccinationStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE,
        RequestMethod.OPTIONS})
@RequestMapping(value = "KgrtVaccinationStatus")
public class KgrtVaccinationStatusController {

    @Autowired
    private KgrtVaccinationStatusService serviceI;

    @GetMapping("/listar")
    public List<KgrtVaccinationStatusDto> listar() {
        return serviceI.findAll();
    }

    @GetMapping("/ver/{id}")
    public KgrtVaccinationStatusDto detalle(@PathVariable Long id) {
        KgrtVaccinationStatusDto obj = serviceI.findById(id);
        return obj;
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public KgrtVaccinationStatusDto crear(@RequestBody KgrtVaccinationStatusDto obj) {
        return serviceI.create(obj);
    }

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public KgrtVaccinationStatusDto editar(@RequestBody KgrtVaccinationStatusDto obj, @PathVariable Integer id) throws InvocationTargetException, IllegalAccessException {
        return serviceI.update(obj);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        serviceI.delete(id);
    }

}
