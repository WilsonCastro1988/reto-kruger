package com.kruger.ec.service.admin.service;

import com.kruger.ec.dto.admin.PerfilDto;
import com.kruger.ec.service.GenericService;


public interface PerfilService extends GenericService<PerfilDto, Integer> {

	PerfilDto findByNombrePerfil(String nombrePerfil);

	boolean existsByNombrePerfil(String nombrePerfil);
}
