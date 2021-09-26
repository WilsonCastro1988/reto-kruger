package com.kruger.ec.mapper.core;

import com.kruger.ec.dto.core.KgrtVaccinationStatusDto;
import com.kruger.ec.entity.core.KgrtVaccinationStatus;
import com.kruger.ec.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface KgrtVaccinationStatusMapper extends EntityMapper<KgrtVaccinationStatusDto, KgrtVaccinationStatus> {

    @Mappings({
            @Mapping(source = "vaccinationlIdDTO", target = "vaccinationlId")
    })
    @Override
    KgrtVaccinationStatus toEntity(KgrtVaccinationStatusDto dto);

    @Mappings({
            @Mapping(source = "vaccinationlId", target = "vaccinationlIdDTO")
    })
    @Override
    KgrtVaccinationStatusDto toDto(KgrtVaccinationStatus entity);

    @Mappings({
            @Mapping(source = "vaccinationlIdDTO", target = "vaccinationlId")
    })
    @Override
    List<KgrtVaccinationStatus> toEntity(List<KgrtVaccinationStatusDto> dtoList);

    @Mappings({
            @Mapping(source = "vaccinationlId", target = "vaccinationlIdDTO")
    })
    @Override
    List<KgrtVaccinationStatusDto> toDto(List<KgrtVaccinationStatus> entityList);

    @Mappings({
            @Mapping(source = "vaccinationlId", target = "vaccinationlIdDTO")
    })
    @Override
    Set<KgrtVaccinationStatusDto> toDto(Set<KgrtVaccinationStatus> entityList);
}
