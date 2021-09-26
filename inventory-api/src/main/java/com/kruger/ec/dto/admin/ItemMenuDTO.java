package com.kruger.ec.dto.admin;

import lombok.Data;

import java.util.List;

@Data
public class ItemMenuDTO {

    private ItemDTO itemDTO;
    private List<ItemDTO> itemsDTO;
}
