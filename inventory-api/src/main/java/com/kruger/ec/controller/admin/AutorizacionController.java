package com.kruger.ec.controller.admin;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.kruger.ec.dto.admin.AutorizacionDto;
import com.kruger.ec.service.admin.service.AutorizacionService;
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
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE,
		RequestMethod.OPTIONS })
@RequestMapping(value = "autorizacion")
public class AutorizacionController {

	@Autowired
	private AutorizacionService serviceI;

	@GetMapping("/listar")
	public List<AutorizacionDto> listar() {
		return serviceI.findAll();
	}

	@GetMapping("/ver/{id}")
	public AutorizacionDto detalle(@PathVariable Integer id) {
		AutorizacionDto entitie = serviceI.findById(id);
		return entitie;
	}

	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public AutorizacionDto crear(@RequestBody AutorizacionDto obj) {
		return serviceI.create(obj);
	}

	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public AutorizacionDto editar(@RequestBody AutorizacionDto obj, @PathVariable Integer id) throws InvocationTargetException, IllegalAccessException {
		return serviceI.update(obj);
	}

	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Integer id) {
		serviceI.delete(id);
	}

}
