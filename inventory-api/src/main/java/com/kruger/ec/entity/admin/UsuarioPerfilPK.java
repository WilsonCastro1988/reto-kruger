/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kruger.ec.entity.admin;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author UISEK
 */
@Getter
@Setter
@Embeddable
public class UsuarioPerfilPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;
    @Basic(optional = false)
    @Column(name = "ID_PERFIL")
    private int idPerfil;


    
}
