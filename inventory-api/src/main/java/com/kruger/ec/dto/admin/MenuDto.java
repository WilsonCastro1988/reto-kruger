package com.kruger.ec.dto.admin;

import com.kruger.ec.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 *
 * @author UISEK
 */

@Setter
@Getter
public class MenuDto extends AbstractDto<Long> {
    private Integer idMenu;
    private Integer idMenuPadreFK;
    private Integer idAplicacionesFK;
    private String nombreMenu;
    private String descripcionMenu;
    private String urlMenu;
    private String tipoMenu;
    private Integer ordenMenu;
    private Boolean activoMenu;
    private String iconoMenu;
    private String iconoposMenu;
    private String labelMenu;
    private Date fechaAperturaMenu;
    private Date fechaCierreMenu;
    private Boolean aperturadoMenu;
    private List<AutorizacionDto> autorizacionListDTO;
    private AplicacionDto idAplicacionDTO;
    private List<MenuDto> menuListDTO;
    private MenuDto menIdMenuDTO;



}
