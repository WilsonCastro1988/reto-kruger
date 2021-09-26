package com.kruger.ec.mapper.admin;

import com.kruger.ec.dto.admin.AutorizacionDto;
import com.kruger.ec.entity.admin.Autorizacion;
import com.kruger.ec.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface AutorizacionMapper extends EntityMapper<AutorizacionDto, Autorizacion> {



    @Mappings({
            @Mapping(source = "idMenuDTO", target = "idMenu"),
            @Mapping(source = "idPerfilDTO", target = "idPerfil")
    })
    @Override
    Autorizacion toEntity(AutorizacionDto dto);

    @Mappings({
            @Mapping(source = "idMenu", target = "idMenuDTO"),
            @Mapping(source = "idPerfil", target = "idPerfilDTO")
    })
    @Override
    AutorizacionDto toDto(Autorizacion entity);

    @Mappings({
            @Mapping(source = "idMenuDTO", target = "idMenu"),
            @Mapping(source = "idPerfilDTO", target = "idPerfil")
    })
    @Override
    List<Autorizacion> toEntity(List<AutorizacionDto> dtoList);

    @Mappings({
            @Mapping(source = "idMenu", target = "idMenuDTO"),
            @Mapping(source = "idPerfil", target = "idPerfilDTO")
    })
    @Override
    List<AutorizacionDto> toDto(List<Autorizacion> entityList);

    @Mappings({
            @Mapping(source = "idMenu", target = "idMenuDTO"),
            @Mapping(source = "idPerfil", target = "idPerfilDTO")
    })
    @Override
    Set<AutorizacionDto> toDto(Set<Autorizacion> entityList);
}
