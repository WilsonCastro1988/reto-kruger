package com.kruger.ec.dto.security;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioDTO implements Serializable {

    private String email, password;
    private List<RolDTO> roles;

}
