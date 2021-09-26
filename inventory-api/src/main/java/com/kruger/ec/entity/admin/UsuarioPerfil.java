/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kruger.ec.entity.admin;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author UISEK
 */
@Getter
@Setter
@Entity
@Table(name = "USUARIO_PERFIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioPerfil.findAll", query = "SELECT u FROM UsuarioPerfil u")
    , @NamedQuery(name = "UsuarioPerfil.findByNombreUsuario", query = "SELECT u FROM UsuarioPerfil u WHERE u.usuarioPerfilPK.nombreUsuario = :nombreUsuario")
    , @NamedQuery(name = "UsuarioPerfil.findByIdPerfil", query = "SELECT u FROM UsuarioPerfil u WHERE u.usuarioPerfilPK.idPerfil = :idPerfil")
    , @NamedQuery(name = "UsuarioPerfil.findByActivoPerfilUsuario", query = "SELECT u FROM UsuarioPerfil u WHERE u.activoPerfilUsuario = :activoPerfilUsuario")})
public class UsuarioPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioPerfilPK usuarioPerfilPK;
    @Column(name = "ACTIVO_PERFIL_USUARIO")
    private Boolean activoPerfilUsuario;
    @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID_PERFIL", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Perfil perfil;
    @JoinColumn(name = "NOMBRE_USUARIO", referencedColumnName = "NOMBRE_USUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;


    
}
