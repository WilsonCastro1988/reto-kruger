package com.kruger.ec.mapper.admin;

import com.kruger.ec.dto.admin.UsuarioPerfilDto;
import com.kruger.ec.entity.admin.UsuarioPerfil;
import com.kruger.ec.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UsuarioPerfilMapper extends EntityMapper<UsuarioPerfilDto, UsuarioPerfil> {

    @Mappings({
            @Mapping(source = "perfilDTO", target = "perfil"),
            @Mapping(source = "usuarioDTO", target = "usuario")
    })
    @Override
    UsuarioPerfil toEntity(UsuarioPerfilDto dto);

    @Mappings({
            @Mapping(source = "perfil", target = "perfilDTO"),
            @Mapping(source = "usuario", target = "usuarioDTO")
    })
    @Override
    UsuarioPerfilDto toDto(UsuarioPerfil entity);

    @Mappings({
            @Mapping(source = "perfilDTO", target = "perfil"),
            @Mapping(source = "usuarioDTO", target = "usuario")
    })
    @Override
    List<UsuarioPerfil> toEntity(List<UsuarioPerfilDto> dtoList);

    @Mappings({
            @Mapping(source = "perfil", target = "perfilDTO"),
            @Mapping(source = "usuario", target = "usuarioDTO")
    })
    @Override
    List<UsuarioPerfilDto> toDto(List<UsuarioPerfil> entityList);

    @Mappings({
            @Mapping(source = "perfil", target = "perfilDTO"),
            @Mapping(source = "usuario", target = "usuarioDTO")
    })
    @Override
    Set<UsuarioPerfilDto> toDto(Set<UsuarioPerfil> entityList);
}
