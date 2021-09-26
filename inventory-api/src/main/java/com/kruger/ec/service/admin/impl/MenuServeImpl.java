package com.kruger.ec.service.admin.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.kruger.ec.dto.admin.ItemDTO;
import com.kruger.ec.dto.admin.ItemMenuDTO;
import com.kruger.ec.dto.admin.MenuDto;
import com.kruger.ec.mapper.admin.MenuMapper;
import com.kruger.ec.repository.admin.MenuRepo;
import com.kruger.ec.service.admin.service.MenuService;
import com.kruger.ec.entity.admin.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MenuServeImpl implements MenuService {

    @Autowired
    private MenuRepo repo;
    @Autowired
    private MenuMapper mapper;

    @Override
    public MenuDto create(MenuDto obj) {
        Menu entity = mapper.toEntity(obj);
        return mapper.toDto(repo.save(entity));
    }

    @Override
    public List<MenuDto> findAll() {
        List<Menu> listEntitie = (List<Menu>) repo.findAll();
        List<MenuDto> listDto = mapper.toDto(listEntitie);
        return listDto;
    }


    @Override
    public MenuDto findById(Integer id) {
        Optional<Menu> obj = repo.findById(id);
        return obj.isPresent() ? mapper.toDto(obj.get()) : new MenuDto();
    }

    @Override
    public MenuDto update(MenuDto obj) {
        try {

            Menu data = mapper.toEntity(obj);
            MenuDto dto = mapper.toDto(repo.save(data));
            /*
            AplicacionDto data = findById(obj.getIdAplicacion());
            Aplicacion entity = mapper.toEntity(obj);
            BeanUtils.copyProperties(data, entity);
            return create(mapper.toDto(entity));
             */
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
            return new MenuDto();
        }
    }

    @Override
    public boolean delete(Integer id) {
        repo.deleteById(id);
        if (repo.findById(id) != null)
            return false;
        else
            return true;
    }


    @Override
    public List<MenuDto> findByUsername(String username) {
        List<Menu> listEntitie = (List<Menu>) repo.findByUsername(username);
        List<MenuDto> listDto = mapper.toDto(listEntitie);
        return listDto;
    }

    @Override
    public List<MenuDto> findPadreByUsername(String username) {
        List<Menu> listEntitie = (List<Menu>) repo.findPadreByUsername(username);
        List<MenuDto> listDto = mapper.toDto(listEntitie);
        return listDto;
    }

    @Override
    public List<MenuDto> findHijoByMenuPadreAndUsername(Integer menuPadre, String username) {
        List<Menu> listEntitie = (List<Menu>) repo.findHijoByMenuPadreAndUsername(menuPadre, username);
        List<MenuDto> listDto = mapper.toDto(listEntitie);
        return listDto;
    }

    @Override
    public List<ItemMenuDTO> findMenuItems(String username) {
        List<MenuDto> lstPadre = this.findPadreByUsername(username);

        List<ItemMenuDTO> lst = new ArrayList<>();
        for (MenuDto obj : lstPadre) {
            ItemMenuDTO menu = new ItemMenuDTO();
            ItemDTO item = new ItemDTO();
            item.setLabel(obj.getNombreMenu());
            item.setIcon(obj.getIconoMenu());
            item.setRouterLink(obj.getUrlMenu());

            List<MenuDto> lstHijo = this.findHijoByMenuPadreAndUsername(obj.getIdMenu(), username);
            List<ItemDTO> listItemHijo = new ArrayList<>();
            for (MenuDto objHijo : lstHijo) {
                ItemDTO itemHijo = new ItemDTO();
                itemHijo.setLabel(objHijo.getNombreMenu());
                itemHijo.setIcon(objHijo.getIconoMenu());
                itemHijo.setRouterLink(objHijo.getUrlMenu());
                listItemHijo.add(itemHijo);
            }

            menu.setItemDTO(item);
            if (lstHijo.size() > 0)
                menu.setItemsDTO(listItemHijo);

            lst.add(menu);


        }


        return lst;
    }
}
