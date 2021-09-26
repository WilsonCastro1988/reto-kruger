package com.kruger.ec.dto.admin;

import com.kruger.ec.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 *
 * @author UISEK
 */

@Setter
@Getter
public class AplicacionDto extends AbstractDto<Long> {
    private Integer idAplicacion;
    private String nombreAplicacion;
    private String descripcionAplicacion;
    private String urlAplicacion;
    private String iconoAplicacion;
    private String bannerAplicacion;
    private Boolean activoAplicacion;
    private List<MenuDto> menuListDTO;



}
