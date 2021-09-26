package com.kruger.ec.mapper.core;

import com.kruger.ec.dto.core.KgrtEmployeeDto;
import com.kruger.ec.dto.core.KgrtVaccinationDto;
import com.kruger.ec.dto.core.KgrtVaccinationStatusDto;
import com.kruger.ec.dto.core.KgrtVaccineDto;
import com.kruger.ec.entity.core.KgrtVaccination;
import com.kruger.ec.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface KgrtVaccinationMapper extends EntityMapper<KgrtVaccinationDto, KgrtVaccination> {


    @Mappings({
            @Mapping(source = "employeevDniDTO", target = "employeevDni"),
            @Mapping(source = "vaccinelIdDTO", target = "vaccinelId"),
            @Mapping(source = "kgrtVaccinationStatusCollectionDTO", target = "kgrtVaccinationStatusCollection")
    })
    @Override
    KgrtVaccination toEntity(KgrtVaccinationDto dto);

    @Mappings({
            @Mapping(source = "employeevDni", target = "employeevDniDTO"),
            @Mapping(source = "vaccinelId", target = "vaccinelIdDTO"),
            @Mapping(source = "kgrtVaccinationStatusCollection", target = "kgrtVaccinationStatusCollectionDTO")
    })
    @Override
    KgrtVaccinationDto toDto(KgrtVaccination entity);

    @Mappings({
            @Mapping(source = "employeevDniDTO", target = "employeevDni"),
            @Mapping(source = "vaccinelIdDTO", target = "vaccinelId"),
            @Mapping(source = "kgrtVaccinationStatusCollectionDTO", target = "kgrtVaccinationStatusCollection")
    })
    @Override
    List<KgrtVaccination> toEntity(List<KgrtVaccinationDto> dtoList);

    @Mappings({
            @Mapping(source = "employeevDni", target = "employeevDniDTO"),
            @Mapping(source = "vaccinelId", target = "vaccinelIdDTO"),
            @Mapping(source = "kgrtVaccinationStatusCollection", target = "kgrtVaccinationStatusCollectionDTO")
    })
    @Override
    List<KgrtVaccinationDto> toDto(List<KgrtVaccination> entityList);

    @Mappings({
            @Mapping(source = "employeevDni", target = "employeevDniDTO"),
            @Mapping(source = "vaccinelId", target = "vaccinelIdDTO"),
            @Mapping(source = "kgrtVaccinationStatusCollection", target = "kgrtVaccinationStatusCollectionDTO")
    })
    @Override
    Set<KgrtVaccinationDto> toDto(Set<KgrtVaccination> entityList);
}
