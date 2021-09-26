package com.kruger.ec.service.admin.service;

import com.kruger.ec.dto.admin.PerfilDto;
import com.kruger.ec.dto.admin.UsuarioPerfilDto;
import com.kruger.ec.entity.admin.UsuarioPerfilPK;
import com.kruger.ec.service.GenericService;

import java.util.List;


public interface UsuarioPerfilService extends GenericService<UsuarioPerfilDto, UsuarioPerfilPK> {

	public List<PerfilDto> obtenerPorUsername(String username);

}
