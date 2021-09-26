package com.kruger.ec.dto.admin;

import com.kruger.ec.entity.admin.UsuarioPerfilPK;
import com.kruger.ec.dto.AbstractDto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author UISEK
 */

@Setter
@Getter
public class UsuarioPerfilDto extends AbstractDto<Long> {
    private UsuarioPerfilPK usuarioPerfilPK;
    private Boolean activoPerfilUsuario;
    private PerfilDto perfilDTO;
    private UsuarioDto usuarioDTO;


}
