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
public class PerfilDto extends AbstractDto<Long> {
    private Integer idPerfil;
    private String nombrePerfil;
    private String descripcionPerfil;
    private Boolean activoPerfil;
    private List<AutorizacionDto> autorizacionListDTO;
    private List<UsuarioPerfilDto> usuarioPerfilListDTO;


}
