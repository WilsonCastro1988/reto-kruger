package com.kruger.ec.service.core.impl;

import com.kruger.ec.dto.core.KgrtVaccineDto;
import com.kruger.ec.entity.core.KgrtVaccine;
import com.kruger.ec.mapper.core.KgrtVaccineMapper;
import com.kruger.ec.repository.core.KgrtVaccineRepo;
import com.kruger.ec.service.core.service.KgrtVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class KgrtVaccineServiceImpl implements KgrtVaccineService {

    @Autowired
    private KgrtVaccineRepo repo;
    @Autowired
    private KgrtVaccineMapper mapper;

    @Override
    public KgrtVaccineDto create(KgrtVaccineDto obj) {
        KgrtVaccine entity = mapper.toEntity(obj);
        return mapper.toDto(repo.save(entity));
    }

    @Override
    public List<KgrtVaccineDto> findAll() {
        List<KgrtVaccine> listEntitie = (List<KgrtVaccine>) repo.findAll();
        List<KgrtVaccineDto> listDto = mapper.toDto(listEntitie);
        return listDto;
    }

    @Override
    public KgrtVaccineDto findById(Long id) {
        Optional<KgrtVaccine> obj = repo.findById(id);
        return obj.isPresent() ? mapper.toDto(obj.get()) : new KgrtVaccineDto();
    }

    @Override
    public KgrtVaccineDto update(KgrtVaccineDto obj) {
        try {

            KgrtVaccine data = mapper.toEntity(obj);
            KgrtVaccineDto dto = mapper.toDto(repo.save(data));
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
            return new KgrtVaccineDto();
        }
    }

    @Override
    public boolean delete(Long id) {
        repo.deleteById(id);
        if (repo.findById(id) != null)
            return false;
        else
            return true;
    }


}
