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
public class UsuarioDto extends AbstractDto<Long> {
    private String nombreUsuario;
    private String dniUsuario;
    private String tipoDniUsuario;
    private String password;
    private String emailPersonalUsuario;
    private String email;
    private Date fechaCreacionUsuario;
    private Date fechaActualizacionUsuario;
    private Boolean activoUsuario;
    private String fotoUsuario;
    private String nombresUsuario;
    private String apellidosUsuario;
    private Boolean faUsuario;
    private String tipo2faUsuario;
    private Integer intentosUsuario;
    private List<UsuarioPerfilDto> usuarioPerfilListDTO;




}
