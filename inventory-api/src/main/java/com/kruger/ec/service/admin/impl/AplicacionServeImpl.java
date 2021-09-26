package com.kruger.ec.service.admin.impl;

import java.util.List;
import java.util.Optional;

import com.kruger.ec.dto.admin.AplicacionDto;
import com.kruger.ec.entity.admin.Aplicacion;
import com.kruger.ec.mapper.admin.AplicacionMapper;
import com.kruger.ec.repository.admin.AplicacionRepo;
import com.kruger.ec.service.admin.service.AplicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AplicacionServeImpl implements AplicacionService {

    @Autowired
    private AplicacionRepo repo;
    @Autowired
    private AplicacionMapper mapper;

    @Override
    public AplicacionDto create(AplicacionDto obj) {
        Aplicacion entity = mapper.toEntity(obj);
        return mapper.toDto(repo.save(entity));
    }

    @Override
    public List<AplicacionDto> findAll() {
        List<Aplicacion> listEntitie = (List<Aplicacion>) repo.findAll();
        List<AplicacionDto> listDto = mapper.toDto(listEntitie);
        return listDto;
    }

    @Override
    public AplicacionDto findById(Integer id) {
        Optional<Aplicacion> obj = repo.findById(id);
        return obj.isPresent() ? mapper.toDto(obj.get()) : new AplicacionDto();
    }

    @Override
    public AplicacionDto update(AplicacionDto obj) {
        try {

            Aplicacion data = mapper.toEntity(obj);
            AplicacionDto dto = mapper.toDto(repo.save(data));
            /*
            AplicacionDto data = findById(obj.getIdAplicacion());
            Aplicacion entity = mapper.toEntity(obj);
            BeanUtils.copyProperties(data, entity);
            return create(mapper.toDto(entity));
             */
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
            return new AplicacionDto();
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


}
