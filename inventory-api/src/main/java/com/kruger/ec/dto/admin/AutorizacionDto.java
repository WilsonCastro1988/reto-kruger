package com.kruger.ec.dto.admin;

import com.kruger.ec.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author UISEK
 */

@Setter
@Getter
public class AutorizacionDto extends AbstractDto<Long> {
    private Integer idAutorizacion;
    private Integer idMenus;
    private Integer idPerfiles;
    private String permisosAutorizacion;
    private Boolean activoAutorizacion;
    private MenuDto idMenuDTO;
    private PerfilDto idPerfilDTO;


}
