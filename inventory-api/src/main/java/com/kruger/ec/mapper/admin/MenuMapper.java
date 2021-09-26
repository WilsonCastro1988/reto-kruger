package com.kruger.ec.mapper.admin;

import com.kruger.ec.dto.admin.MenuDto;
import com.kruger.ec.mapper.EntityMapper;
import com.kruger.ec.entity.admin.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface MenuMapper extends EntityMapper<MenuDto, Menu> {

    @Mappings({
            @Mapping(source = "autorizacionListDTO", target = "autorizacionList"),
            @Mapping(source = "idAplicacionDTO", target = "idAplicacion"),
            @Mapping(source = "menuListDTO", target = "menuList"),
            @Mapping(source = "menIdMenuDTO", target = "menIdMenu"),
            @Mapping(source = "idMenuPadreFK", target = "idMenuPadre"),
            @Mapping(source = "idAplicacionesFK", target = "idAplicaciones")
    })
    @Override
    Menu toEntity(MenuDto dto);

    @Mappings({
            @Mapping(source = "autorizacionList", target = "autorizacionListDTO"),
            @Mapping(source = "idAplicacion", target = "idAplicacionDTO"),
            @Mapping(source = "menuList", target = "menuListDTO"),
            @Mapping(source = "menIdMenu", target = "menIdMenuDTO"),
            @Mapping(source = "idMenuPadre", target = "idMenuPadreFK"),
            @Mapping(source = "idAplicaciones", target = "idAplicacionesFK")
    })
    @Override
    MenuDto toDto(Menu entity);

    @Mappings({
            @Mapping(source = "autorizacionListDTO", target = "autorizacionList"),
            @Mapping(source = "idAplicacionDTO", target = "idAplicacion"),
            @Mapping(source = "menuListDTO", target = "menuList"),
            @Mapping(source = "menIdMenuDTO", target = "menIdMenu"),
            @Mapping(source = "idMenuPadreFK", target = "idMenuPadre"),
            @Mapping(source = "idAplicacionesFK", target = "idAplicaciones")
    })
    @Override
    List<Menu> toEntity(List<MenuDto> dtoList);

    @Mappings({
            @Mapping(source = "autorizacionList", target = "autorizacionListDTO"),
            @Mapping(source = "idAplicacion", target = "idAplicacionDTO"),
            @Mapping(source = "menuList", target = "menuListDTO"),
            @Mapping(source = "menIdMenu", target = "menIdMenuDTO"),
            @Mapping(source = "idMenuPadre", target = "idMenuPadreFK"),
            @Mapping(source = "idAplicaciones", target = "idAplicacionesFK")
    })
    @Override
    List<MenuDto> toDto(List<Menu> entityList);

    @Mappings({
            @Mapping(source = "autorizacionList", target = "autorizacionListDTO"),
            @Mapping(source = "idAplicacion", target = "idAplicacionDTO"),
            @Mapping(source = "menuList", target = "menuListDTO"),
            @Mapping(source = "menIdMenu", target = "menIdMenuDTO"),
            @Mapping(source = "idMenuPadre", target = "idMenuPadreFK"),
            @Mapping(source = "idAplicaciones", target = "idAplicacionesFK")
    })
    @Override
    Set<MenuDto> toDto(Set<Menu> entityList);
}
