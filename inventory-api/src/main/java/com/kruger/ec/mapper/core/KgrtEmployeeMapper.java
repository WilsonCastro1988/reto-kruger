package com.kruger.ec.mapper.core;


import com.kruger.ec.dto.core.KgrtEmployeeDto;
import com.kruger.ec.entity.core.KgrtEmployee;
import com.kruger.ec.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface KgrtEmployeeMapper extends EntityMapper<KgrtEmployeeDto, KgrtEmployee> {

    @Mappings({
            @Mapping(source = "kgrtVaccinationCollectionDTO", target = "kgrtVaccinationCollection")
    })
    @Override
    KgrtEmployee toEntity(KgrtEmployeeDto dto);

    @Mappings({
            @Mapping(source = "kgrtVaccinationCollection", target = "kgrtVaccinationCollectionDTO")
    })
    @Override
    KgrtEmployeeDto toDto(KgrtEmployee entity);

    @Mappings({
            @Mapping(source = "kgrtVaccinationCollectionDTO", target = "kgrtVaccinationCollection")
    })
    @Override
    List<KgrtEmployee> toEntity(List<KgrtEmployeeDto> dtoList);

    @Mappings({
            @Mapping(source = "kgrtVaccinationCollection", target = "kgrtVaccinationCollectionDTO")
    })
    @Override
    List<KgrtEmployeeDto> toDto(List<KgrtEmployee> entityList);

    @Mappings({
            @Mapping(source = "kgrtVaccinationCollection", target = "kgrtVaccinationCollectionDTO")
    })
    @Override
    Set<KgrtEmployeeDto> toDto(Set<KgrtEmployee> entityList);
}
