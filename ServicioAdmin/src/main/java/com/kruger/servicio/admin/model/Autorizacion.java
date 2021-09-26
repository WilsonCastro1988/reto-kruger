/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kruger.servicio.admin.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "AUTORIZACION", catalog = "vaccination_inventory", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autorizacion.findAll", query = "SELECT a FROM Autorizacion a")
    , @NamedQuery(name = "Autorizacion.findByIdAutorizacion", query = "SELECT a FROM Autorizacion a WHERE a.idAutorizacion = :idAutorizacion")
    , @NamedQuery(name = "Autorizacion.findByIdMenus", query = "SELECT a FROM Autorizacion a WHERE a.idMenus = :idMenus")
    , @NamedQuery(name = "Autorizacion.findByIdPerfiles", query = "SELECT a FROM Autorizacion a WHERE a.idPerfiles = :idPerfiles")
    , @NamedQuery(name = "Autorizacion.findByPermisosAutorizacion", query = "SELECT a FROM Autorizacion a WHERE a.permisosAutorizacion = :permisosAutorizacion")
    , @NamedQuery(name = "Autorizacion.findByActivoAutorizacion", query = "SELECT a FROM Autorizacion a WHERE a.activoAutorizacion = :activoAutorizacion")})
public class Autorizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_AUTORIZACION")
    private Integer idAutorizacion;
    @Column(name = "ID_MENUS")
    private Integer idMenus;
    @Column(name = "ID_PERFILES")
    private Integer idPerfiles;
    @Column(name = "PERMISOS_AUTORIZACION")
    private String permisosAutorizacion;
    @Column(name = "ACTIVO_AUTORIZACION")
    private Boolean activoAutorizacion;
    @JoinColumn(name = "ID_MENU", referencedColumnName = "ID_MENU")
    @ManyToOne
    private Menu idMenu;
    @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID_PERFIL")
    @ManyToOne
    private Perfil idPerfil;

    public Autorizacion() {
    }

    public Autorizacion(Integer idAutorizacion) {
        this.idAutorizacion = idAutorizacion;
    }

    public Integer getIdAutorizacion() {
        return idAutorizacion;
    }

    public void setIdAutorizacion(Integer idAutorizacion) {
        this.idAutorizacion = idAutorizacion;
    }

    public Integer getIdMenus() {
        return idMenus;
    }

    public void setIdMenus(Integer idMenus) {
        this.idMenus = idMenus;
    }

    public Integer getIdPerfiles() {
        return idPerfiles;
    }

    public void setIdPerfiles(Integer idPerfiles) {
        this.idPerfiles = idPerfiles;
    }

    public String getPermisosAutorizacion() {
        return permisosAutorizacion;
    }

    public void setPermisosAutorizacion(String permisosAutorizacion) {
        this.permisosAutorizacion = permisosAutorizacion;
    }

    public Boolean getActivoAutorizacion() {
        return activoAutorizacion;
    }

    public void setActivoAutorizacion(Boolean activoAutorizacion) {
        this.activoAutorizacion = activoAutorizacion;
    }

    public Menu getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Menu idMenu) {
        this.idMenu = idMenu;
    }

    public Perfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Perfil idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutorizacion != null ? idAutorizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autorizacion)) {
            return false;
        }
        Autorizacion other = (Autorizacion) object;
        if ((this.idAutorizacion == null && other.idAutorizacion != null) || (this.idAutorizacion != null && !this.idAutorizacion.equals(other.idAutorizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kruger.servicio.admin.model.Autorizacion[ idAutorizacion=" + idAutorizacion + " ]";
    }
    
}
