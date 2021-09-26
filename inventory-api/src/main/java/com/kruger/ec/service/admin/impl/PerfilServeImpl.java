package com.kruger.ec.service.admin.impl;

import java.util.List;
import java.util.Optional;

import com.kruger.ec.repository.admin.PerfilRepo;
import com.kruger.ec.dto.admin.PerfilDto;
import com.kruger.ec.entity.admin.Perfil;
import com.kruger.ec.mapper.admin.PerfilMapper;
import com.kruger.ec.service.admin.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PerfilServeImpl implements PerfilService {

	@Autowired
	private PerfilRepo repo;
	@Autowired
	private PerfilMapper mapper;

	@Override
	public PerfilDto create(PerfilDto obj) {
		Perfil entity = mapper.toEntity(obj);
		return mapper.toDto(repo.save(entity));
	}

	@Override
	public List<PerfilDto> findAll() {
		List<Perfil> listEntitie = (List<Perfil>) repo.findAll();
		List<PerfilDto> listDto = mapper.toDto(listEntitie);
		return listDto;
	}

	@Override
	public PerfilDto findById(Integer id) {
		Optional<Perfil> obj = repo.findById(id);
		return obj.isPresent() ? mapper.toDto(obj.get()) : new PerfilDto();
	}

	@Override
	public PerfilDto update(PerfilDto obj) {
		try {

			Perfil data = mapper.toEntity(obj);
			PerfilDto dto = mapper.toDto(repo.save(data));
            /*
            AplicacionDto data = findById(obj.getIdAplicacion());
            Aplicacion entity = mapper.toEntity(obj);
            BeanUtils.copyProperties(data, entity);
            return create(mapper.toDto(entity));
             */
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
			return new PerfilDto();
		}
	}

	@Override
	public boolean delete(Integer id) {
		repo.deleteById(id);
		if (repo.findById(id) != null)
			return false;
		else
			return true;
	}

	@Override
	public PerfilDto findByNombrePerfil(String nombrePerfil) {
		Optional<Perfil> obj = repo.findByNombrePerfil(nombrePerfil);
		return obj.isPresent() ? mapper.toDto(obj.get()) : new PerfilDto();

	}

	@Override
	public boolean existsByNombrePerfil(String nombrePerfil) {
		return repo.existsByNombrePerfil(nombrePerfil);

	}

}
