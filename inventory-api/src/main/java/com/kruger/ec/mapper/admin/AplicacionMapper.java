package com.kruger.ec.mapper.admin;

import com.kruger.ec.dto.admin.AplicacionDto;
import com.kruger.ec.entity.admin.Aplicacion;
import com.kruger.ec.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface AplicacionMapper extends EntityMapper<AplicacionDto, Aplicacion> {


    @Mapping(source = "menuListDTO", target = "menuList")
    @Override
    Aplicacion toEntity(AplicacionDto dto);

    @Mapping(source = "menuList", target = "menuListDTO")
    @Override
    AplicacionDto toDto(Aplicacion entity);

    @Mapping(source = "menuListDTO", target = "menuList")
    @Override
    List<Aplicacion> toEntity(List<AplicacionDto> dtoList);

    @Mapping(source = "menuList", target = "menuListDTO")
    @Override
    List<AplicacionDto> toDto(List<Aplicacion> entityList);

    @Mapping(source = "menuList", target = "menuListDTO")
    @Override
    Set<AplicacionDto> toDto(Set<Aplicacion> entityList);


}
