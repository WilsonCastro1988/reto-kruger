package com.kruger.ec.service.admin.impl;

import java.util.List;
import java.util.Optional;

import com.kruger.ec.repository.admin.UsuarioPerfilRepo;
import com.kruger.ec.dto.admin.PerfilDto;
import com.kruger.ec.dto.admin.UsuarioPerfilDto;
import com.kruger.ec.entity.admin.Perfil;
import com.kruger.ec.entity.admin.UsuarioPerfil;
import com.kruger.ec.entity.admin.UsuarioPerfilPK;
import com.kruger.ec.mapper.admin.PerfilMapper;
import com.kruger.ec.mapper.admin.UsuarioPerfilMapper;
import com.kruger.ec.service.admin.service.UsuarioPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioPerfilServiceImpl implements UsuarioPerfilService {

	@Autowired
	private UsuarioPerfilRepo repo;
	@Autowired
	private UsuarioPerfilMapper mapper;
	@Autowired
	private PerfilMapper mapperPerfil;

	@Override
	public UsuarioPerfilDto create(UsuarioPerfilDto obj) {
		UsuarioPerfil entity = mapper.toEntity(obj);
		return mapper.toDto(repo.save(entity));
	}

	@Override
	public List<UsuarioPerfilDto> findAll() {
		List<UsuarioPerfil> listEntitie = (List<UsuarioPerfil>) repo.findAll();
		List<UsuarioPerfilDto> listDto = mapper.toDto(listEntitie);
		return listDto;
	}

	@Override
	public UsuarioPerfilDto findById(UsuarioPerfilPK id) {
		Optional<UsuarioPerfil> obj = repo.findById(id);
		return obj.isPresent() ? mapper.toDto(obj.get()) : new UsuarioPerfilDto();
	}

	@Override
	public UsuarioPerfilDto update(UsuarioPerfilDto obj) {
		try {

			UsuarioPerfil data = mapper.toEntity(obj);
			UsuarioPerfilDto dto = mapper.toDto(repo.save(data));
            /*
            AplicacionDto data = findById(obj.getIdAplicacion());
            Aplicacion entity = mapper.toEntity(obj);
            BeanUtils.copyProperties(data, entity);
            return create(mapper.toDto(entity));
             */
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
			return new UsuarioPerfilDto();
		}
	}

	@Override
	public boolean delete(UsuarioPerfilPK id) {
		repo.deleteById(id);
		if (repo.findById(id) != null)
			return false;
		else
			return true;
	}

	@Override
	public List<PerfilDto> obtenerPorUsername(String username) {
		List<Perfil> list = repo.obtenerPorUsername(username);
		return mapperPerfil.toDto(list);
	}
}
