package com.kruger.ec.service.admin.service;

import com.kruger.ec.dto.admin.UsuarioDto;
import com.kruger.ec.service.GenericService;

import java.util.Optional;


public interface UsuarioService extends GenericService<UsuarioDto, String> {

	public UsuarioDto findByNombreUsuario(String username);

	public Optional<UsuarioDto> getByEmail(String email);
	
	 public boolean existsEmail(String email);


}
