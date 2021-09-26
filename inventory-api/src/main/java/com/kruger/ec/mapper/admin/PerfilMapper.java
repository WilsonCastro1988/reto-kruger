package com.kruger.ec.mapper.admin;

import com.kruger.ec.dto.admin.PerfilDto;
import com.kruger.ec.entity.admin.Perfil;
import com.kruger.ec.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface PerfilMapper extends EntityMapper<PerfilDto, Perfil> {



    @Mappings({
            @Mapping(source = "autorizacionListDTO", target = "autorizacionList"),
            @Mapping(source = "usuarioPerfilListDTO", target = "usuarioPerfilList")
    })
    @Override
    Perfil toEntity(PerfilDto dto);

    @Mappings({
            @Mapping(source = "autorizacionList", target = "autorizacionListDTO"),
            @Mapping(source = "usuarioPerfilList", target = "usuarioPerfilListDTO")
    })
    @Override
    PerfilDto toDto(Perfil entity);

    @Mappings({
            @Mapping(source = "autorizacionListDTO", target = "autorizacionList"),
            @Mapping(source = "usuarioPerfilListDTO", target = "usuarioPerfilList")
    })
    @Override
    List<Perfil> toEntity(List<PerfilDto> dtoList);

    @Mappings({
            @Mapping(source = "autorizacionList", target = "autorizacionListDTO"),
            @Mapping(source = "usuarioPerfilList", target = "usuarioPerfilListDTO")
    })
    @Override
    List<PerfilDto> toDto(List<Perfil> entityList);

    @Mappings({
            @Mapping(source = "autorizacionList", target = "autorizacionListDTO"),
            @Mapping(source = "usuarioPerfilList", target = "usuarioPerfilListDTO")
    })
    @Override
    Set<PerfilDto> toDto(Set<Perfil> entityList);
}
