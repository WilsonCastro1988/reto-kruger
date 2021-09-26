/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kruger.servicio.admin.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author UISEK
 */
@Embeddable
public class UsuarioPerfilPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;
    @Basic(optional = false)
    @Column(name = "ID_PERFIL")
    private int idPerfil;

    public UsuarioPerfilPK() {
    }

    public UsuarioPerfilPK(String nombreUsuario, int idPerfil) {
        this.nombreUsuario = nombreUsuario;
        this.idPerfil = idPerfil;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreUsuario != null ? nombreUsuario.hashCode() : 0);
        hash += (int) idPerfil;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioPerfilPK)) {
            return false;
        }
        UsuarioPerfilPK other = (UsuarioPerfilPK) object;
        if ((this.nombreUsuario == null && other.nombreUsuario != null) || (this.nombreUsuario != null && !this.nombreUsuario.equals(other.nombreUsuario))) {
            return false;
        }
        if (this.idPerfil != other.idPerfil) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kruger.servicio.admin.model.UsuarioPerfilPK[ nombreUsuario=" + nombreUsuario + ", idPerfil=" + idPerfil + " ]";
    }
    
}
