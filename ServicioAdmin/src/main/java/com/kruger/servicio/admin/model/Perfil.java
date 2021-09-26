/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kruger.servicio.admin.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UISEK
 */
@Entity
@Table(name = "PERFIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")
    , @NamedQuery(name = "Perfil.findByIdPerfil", query = "SELECT p FROM Perfil p WHERE p.idPerfil = :idPerfil")
    , @NamedQuery(name = "Perfil.findByNombrePerfil", query = "SELECT p FROM Perfil p WHERE p.nombrePerfil = :nombrePerfil")
    , @NamedQuery(name = "Perfil.findByDescripcionPerfil", query = "SELECT p FROM Perfil p WHERE p.descripcionPerfil = :descripcionPerfil")
    , @NamedQuery(name = "Perfil.findByActivoPerfil", query = "SELECT p FROM Perfil p WHERE p.activoPerfil = :activoPerfil")})
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PERFIL")
    private Integer idPerfil;
    @Column(name = "NOMBRE_PERFIL")
    private String nombrePerfil;
    @Column(name = "DESCRIPCION_PERFIL")
    private String descripcionPerfil;
    @Column(name = "ACTIVO_PERFIL")
    private Boolean activoPerfil;
    @OneToMany(mappedBy = "idPerfil")
    private List<Autorizacion> autorizacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private List<UsuarioPerfil> usuarioPerfilList;

    public Perfil() {
    }

    public Perfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public String getDescripcionPerfil() {
        return descripcionPerfil;
    }

    public void setDescripcionPerfil(String descripcionPerfil) {
        this.descripcionPerfil = descripcionPerfil;
    }

    public Boolean getActivoPerfil() {
        return activoPerfil;
    }

    public void setActivoPerfil(Boolean activoPerfil) {
        this.activoPerfil = activoPerfil;
    }

    @XmlTransient
    public List<Autorizacion> getAutorizacionList() {
        return autorizacionList;
    }

    public void setAutorizacionList(List<Autorizacion> autorizacionList) {
        this.autorizacionList = autorizacionList;
    }

    @XmlTransient
    public List<UsuarioPerfil> getUsuarioPerfilList() {
        return usuarioPerfilList;
    }

    public void setUsuarioPerfilList(List<UsuarioPerfil> usuarioPerfilList) {
        this.usuarioPerfilList = usuarioPerfilList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfil != null ? idPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.idPerfil == null && other.idPerfil != null) || (this.idPerfil != null && !this.idPerfil.equals(other.idPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kruger.servicio.admin.model.Perfil[ idPerfil=" + idPerfil + " ]";
    }
    
}
