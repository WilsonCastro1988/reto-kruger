package com.kruger.ec.service.admin.service;


import com.kruger.ec.dto.admin.ItemMenuDTO;
import com.kruger.ec.dto.admin.MenuDto;
import com.kruger.ec.service.GenericService;

import java.util.List;

public interface MenuService extends GenericService<MenuDto, Integer> {

    List<MenuDto> findByUsername(String username);

    List<MenuDto> findPadreByUsername(String username);

    List<MenuDto> findHijoByMenuPadreAndUsername(Integer menuPadre, String username);

    List<ItemMenuDTO> findMenuItems(String username);

}
