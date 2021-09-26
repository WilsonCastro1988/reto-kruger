/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kruger.servicio.admin.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UISEK
 */
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

    public UsuarioPerfil() {
    }

    public UsuarioPerfil(UsuarioPerfilPK usuarioPerfilPK) {
        this.usuarioPerfilPK = usuarioPerfilPK;
    }

    public UsuarioPerfil(String nombreUsuario, int idPerfil) {
        this.usuarioPerfilPK = new UsuarioPerfilPK(nombreUsuario, idPerfil);
    }

    public UsuarioPerfilPK getUsuarioPerfilPK() {
        return usuarioPerfilPK;
    }

    public void setUsuarioPerfilPK(UsuarioPerfilPK usuarioPerfilPK) {
        this.usuarioPerfilPK = usuarioPerfilPK;
    }

    public Boolean getActivoPerfilUsuario() {
        return activoPerfilUsuario;
    }

    public void setActivoPerfilUsuario(Boolean activoPerfilUsuario) {
        this.activoPerfilUsuario = activoPerfilUsuario;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioPerfilPK != null ? usuarioPerfilPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioPerfil)) {
            return false;
        }
        UsuarioPerfil other = (UsuarioPerfil) object;
        if ((this.usuarioPerfilPK == null && other.usuarioPerfilPK != null) || (this.usuarioPerfilPK != null && !this.usuarioPerfilPK.equals(other.usuarioPerfilPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kruger.servicio.admin.model.UsuarioPerfil[ usuarioPerfilPK=" + usuarioPerfilPK + " ]";
    }
    
}
