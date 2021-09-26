package com.kruger.ec.controller.admin;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.kruger.ec.dto.admin.UsuarioDto;
import com.kruger.ec.service.admin.service.UsuarioService;
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
@RequestMapping(value = "usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService serviceI;

	@GetMapping("/listar")
	public List<UsuarioDto> listar() {
		return serviceI.findAll();
	}

	@GetMapping("/ver/{id}")
	public UsuarioDto detalle(@PathVariable String id) {
		UsuarioDto entitie = serviceI.findById(id);
		return entitie;
	}

	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioDto crear(@RequestBody UsuarioDto obj) {
		return serviceI.create(obj);
	}

	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioDto editar(@RequestBody UsuarioDto obj, @PathVariable String id) throws InvocationTargetException, IllegalAccessException {
		return serviceI.update(obj);
	}

	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable String id) {
		serviceI.delete(id);
	}


	@GetMapping("/findByEmail/{email}")
	@ResponseStatus(HttpStatus.FOUND)
	public UsuarioDto findByEmail(@PathVariable String email)
	{
		return serviceI.getByEmail(email).get();
	}

}
