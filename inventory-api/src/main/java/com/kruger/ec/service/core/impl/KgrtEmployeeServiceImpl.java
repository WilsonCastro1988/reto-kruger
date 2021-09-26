package com.kruger.ec.service.core.impl;

import com.kruger.ec.dto.admin.UsuarioDto;
import com.kruger.ec.dto.core.KgrtEmployeeDto;
import com.kruger.ec.entity.admin.Usuario;
import com.kruger.ec.mapper.core.KgrtEmployeeMapper;
import com.kruger.ec.repository.core.KgrtEmployeeRepo;
import com.kruger.ec.service.core.service.KgrtEmployeeService;
import com.kruger.ec.entity.core.KgrtEmployee;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class KgrtEmployeeServiceImpl implements KgrtEmployeeService {

    @Autowired
    private KgrtEmployeeRepo repo;
    @Autowired
    private KgrtEmployeeMapper mapper;

    @Override
    public KgrtEmployeeDto create(KgrtEmployeeDto obj) {
        KgrtEmployee entity = mapper.toEntity(obj);
        return mapper.toDto(repo.save(entity));
    }

    @Override
    public List<KgrtEmployeeDto> findAll() {
        List<KgrtEmployee> listEntitie = (List<KgrtEmployee>) repo.findAll();
        List<KgrtEmployeeDto> listDto = mapper.toDto(listEntitie);
        return listDto;
    }

    @Override
    public KgrtEmployeeDto findById(String id) {
        Optional<KgrtEmployee> obj = repo.findById(id);
        return obj.isPresent() ? mapper.toDto(obj.get()) : new KgrtEmployeeDto();
    }

    @Override
    public KgrtEmployeeDto update(KgrtEmployeeDto obj) {
        try {

            KgrtEmployee data = mapper.toEntity(obj);
            KgrtEmployeeDto dto = mapper.toDto(repo.save(data));
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
            return new KgrtEmployeeDto();
        }
    }

    @Override
    public boolean delete(String id) {
        repo.deleteById(id);
        if (repo.findById(id) != null)
            return false;
        else
            return true;
    }

    @Override
    public Optional<KgrtEmployeeDto> findByFlagemployeevUser(UsuarioDto flagemployeevUser) {
        Optional<KgrtEmployee> obj = repo.findByFlagemployeevUser(flagemployeevUser.getNombreUsuario());
        return obj.isPresent() ? Optional.of(mapper.toDto(obj.get())) : Optional.of(new KgrtEmployeeDto());    }
}
