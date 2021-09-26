package com.kruger.ec.mapper.core;

import com.kruger.ec.dto.core.KgrtVaccineDto;
import com.kruger.ec.entity.core.KgrtVaccine;
import com.kruger.ec.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface KgrtVaccineMapper extends EntityMapper<KgrtVaccineDto, KgrtVaccine> {

    @Mappings({
            @Mapping(source = "kgrtVaccinationCollectionDTO", target = "kgrtVaccinationCollection")
    })
    @Override
    KgrtVaccine toEntity(KgrtVaccineDto dto);

    @Mappings({
            @Mapping(source = "kgrtVaccinationCollection", target = "kgrtVaccinationCollectionDTO")
    })
    @Override
    KgrtVaccineDto toDto(KgrtVaccine entity);

    @Mappings({
            @Mapping(source = "kgrtVaccinationCollectionDTO", target = "kgrtVaccinationCollection")
    })
    @Override
    List<KgrtVaccine> toEntity(List<KgrtVaccineDto> dtoList);

    @Mappings({
            @Mapping(source = "kgrtVaccinationCollection", target = "kgrtVaccinationCollectionDTO")
    })
    @Override
    List<KgrtVaccineDto> toDto(List<KgrtVaccine> entityList);

    @Mappings({
            @Mapping(source = "kgrtVaccinationCollection", target = "kgrtVaccinationCollectionDTO")
    })
    @Override
    Set<KgrtVaccineDto> toDto(Set<KgrtVaccine> entityList);
}
