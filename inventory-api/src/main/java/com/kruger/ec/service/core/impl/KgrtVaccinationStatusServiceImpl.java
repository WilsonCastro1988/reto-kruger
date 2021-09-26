package com.kruger.ec.service.core.impl;

import com.kruger.ec.dto.core.KgrtVaccinationStatusDto;
import com.kruger.ec.entity.core.KgrtVaccinationStatus;
import com.kruger.ec.mapper.core.KgrtVaccinationStatusMapper;
import com.kruger.ec.repository.core.KgrtVaccinationStatusRepo;
import com.kruger.ec.service.core.service.KgrtVaccinationStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class KgrtVaccinationStatusServiceImpl implements KgrtVaccinationStatusService {

    @Autowired
    private KgrtVaccinationStatusRepo repo;
    @Autowired
    private KgrtVaccinationStatusMapper mapper;

    @Override
    public KgrtVaccinationStatusDto create(KgrtVaccinationStatusDto obj) {
        KgrtVaccinationStatus entity = mapper.toEntity(obj);
        return mapper.toDto(repo.save(entity));
    }

    @Override
    public List<KgrtVaccinationStatusDto> findAll() {
        List<KgrtVaccinationStatus> listEntitie = (List<KgrtVaccinationStatus>) repo.findAll();
        List<KgrtVaccinationStatusDto> listDto = mapper.toDto(listEntitie);
        return listDto;
    }

    @Override
    public KgrtVaccinationStatusDto findById(Long id) {
        Optional<KgrtVaccinationStatus> obj = repo.findById(id);
        return obj.isPresent() ? mapper.toDto(obj.get()) : new KgrtVaccinationStatusDto();
    }

    @Override
    public KgrtVaccinationStatusDto update(KgrtVaccinationStatusDto obj) {
        try {

            KgrtVaccinationStatus data = mapper.toEntity(obj);
            KgrtVaccinationStatusDto dto = mapper.toDto(repo.save(data));
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
            return new KgrtVaccinationStatusDto();
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
