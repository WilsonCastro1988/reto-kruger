package com.kruger.ec.service.core.impl;

import com.kruger.ec.dto.core.KgrtVaccinationDto;
import com.kruger.ec.entity.core.KgrtVaccination;
import com.kruger.ec.mapper.core.KgrtVaccinationMapper;
import com.kruger.ec.repository.core.KgrtVaccinationRepo;
import com.kruger.ec.service.core.service.KgrtVaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class KgrtVaccinationServiceImpl implements KgrtVaccinationService {

    @Autowired
    private KgrtVaccinationRepo repo;
    @Autowired
    private KgrtVaccinationMapper mapper;

    @Override
    public KgrtVaccinationDto create(KgrtVaccinationDto obj) {
        KgrtVaccination entity = mapper.toEntity(obj);
        return mapper.toDto(repo.save(entity));
    }

    @Override
    public List<KgrtVaccinationDto> findAll() {
        List<KgrtVaccination> listEntitie = (List<KgrtVaccination>) repo.findAll();
        List<KgrtVaccinationDto> listDto = mapper.toDto(listEntitie);
        return listDto;
    }

    @Override
    public KgrtVaccinationDto findById(Long id) {
        Optional<KgrtVaccination> obj = repo.findById(id);
        return obj.isPresent() ? mapper.toDto(obj.get()) : new KgrtVaccinationDto();
    }

    @Override
    public KgrtVaccinationDto update(KgrtVaccinationDto obj) {
        try {

            KgrtVaccination data = mapper.toEntity(obj);
            KgrtVaccinationDto dto = mapper.toDto(repo.save(data));
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
            return new KgrtVaccinationDto();
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
