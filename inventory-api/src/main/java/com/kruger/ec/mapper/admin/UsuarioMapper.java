package com.kruger.ec.mapper.admin;

import com.kruger.ec.dto.admin.UsuarioDto;
import com.kruger.ec.entity.admin.Usuario;
import com.kruger.ec.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UsuarioMapper extends EntityMapper<UsuarioDto, Usuario> {

    @Mappings({
            @Mapping(source = "usuarioPerfilListDTO", target = "usuarioPerfilList")
    })
    @Override
    Usuario toEntity(UsuarioDto dto);

    @Mappings({
            @Mapping(source = "usuarioPerfilList", target = "usuarioPerfilListDTO")
    })
    @Override
    UsuarioDto toDto(Usuario entity);

    @Mappings({
            @Mapping(source = "usuarioPerfilListDTO", target = "usuarioPerfilList")
    })
    @Override
    List<Usuario> toEntity(List<UsuarioDto> dtoList);

    @Mappings({
            @Mapping(source = "usuarioPerfilList", target = "usuarioPerfilListDTO")
    })
    @Override
    List<UsuarioDto> toDto(List<Usuario> entityList);

    @Mappings({
            @Mapping(source = "usuarioPerfilList", target = "usuarioPerfilListDTO")
    })
    @Override
    Set<UsuarioDto> toDto(Set<Usuario> entityList);
}
