package com.kruger.ec.service.admin.impl;

import java.util.List;
import java.util.Optional;

import com.kruger.ec.repository.admin.AutorizacionRepo;
import com.kruger.ec.dto.admin.AutorizacionDto;
import com.kruger.ec.entity.admin.Autorizacion;
import com.kruger.ec.mapper.admin.AutorizacionMapper;
import com.kruger.ec.service.admin.service.AutorizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AutorizacionServeImpl implements AutorizacionService {

	@Autowired
	private AutorizacionRepo repo;
	@Autowired
	private AutorizacionMapper mapper;

	@Override
	public AutorizacionDto create(AutorizacionDto obj) {
		Autorizacion entity = mapper.toEntity(obj);
		return mapper.toDto(repo.save(entity));
	}

	@Override
	public List<AutorizacionDto> findAll() {
		List<Autorizacion> listEntitie = (List<Autorizacion>) repo.findAll();
		List<AutorizacionDto> listDto = mapper.toDto(listEntitie);
		return listDto;
	}

	@Override
	public AutorizacionDto findById(Integer id) {
		Optional<Autorizacion> obj = repo.findById(id);
		return obj.isPresent() ? mapper.toDto(obj.get()) : new AutorizacionDto();
	}

	@Override
	public AutorizacionDto update(AutorizacionDto obj) {
		Autorizacion entitie = mapper.toEntity(obj);
		return mapper.toDto(repo.save(entitie));
	}

	@Override
	public boolean delete(Integer id) {
		repo.deleteById(id);
		if (repo.findById(id) != null)
			return false;
		else
			return true;
	}


}
