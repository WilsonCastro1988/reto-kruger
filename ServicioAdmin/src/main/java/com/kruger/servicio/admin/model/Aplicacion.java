/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kruger.servicio.admin.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "APLICACION", catalog = "vaccination_inventory", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aplicacion.findAll", query = "SELECT a FROM Aplicacion a")
    , @NamedQuery(name = "Aplicacion.findByIdAplicacion", query = "SELECT a FROM Aplicacion a WHERE a.idAplicacion = :idAplicacion")
    , @NamedQuery(name = "Aplicacion.findByNombreAplicacion", query = "SELECT a FROM Aplicacion a WHERE a.nombreAplicacion = :nombreAplicacion")
    , @NamedQuery(name = "Aplicacion.findByDescripcionAplicacion", query = "SELECT a FROM Aplicacion a WHERE a.descripcionAplicacion = :descripcionAplicacion")
    , @NamedQuery(name = "Aplicacion.findByUrlAplicacion", query = "SELECT a FROM Aplicacion a WHERE a.urlAplicacion = :urlAplicacion")
    , @NamedQuery(name = "Aplicacion.findByIconoAplicacion", query = "SELECT a FROM Aplicacion a WHERE a.iconoAplicacion = :iconoAplicacion")
    , @NamedQuery(name = "Aplicacion.findByBannerAplicacion", query = "SELECT a FROM Aplicacion a WHERE a.bannerAplicacion = :bannerAplicacion")
    , @NamedQuery(name = "Aplicacion.findByActivoAplicacion", query = "SELECT a FROM Aplicacion a WHERE a.activoAplicacion = :activoAplicacion")})
public class Aplicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_APLICACION")
    private Integer idAplicacion;
    @Column(name = "NOMBRE_APLICACION")
    private String nombreAplicacion;
    @Column(name = "DESCRIPCION_APLICACION")
    private String descripcionAplicacion;
    @Column(name = "URL_APLICACION")
    private String urlAplicacion;
    @Column(name = "ICONO_APLICACION")
    private String iconoAplicacion;
    @Column(name = "BANNER_APLICACION")
    private String bannerAplicacion;
    @Column(name = "ACTIVO_APLICACION")
    private Boolean activoAplicacion;
    @OneToMany(mappedBy = "idAplicacion")
    private List<Menu> menuList;

    public Aplicacion() {
    }

    public Aplicacion(Integer idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public Integer getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(Integer idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public String getNombreAplicacion() {
        return nombreAplicacion;
    }

    public void setNombreAplicacion(String nombreAplicacion) {
        this.nombreAplicacion = nombreAplicacion;
    }

    public String getDescripcionAplicacion() {
        return descripcionAplicacion;
    }

    public void setDescripcionAplicacion(String descripcionAplicacion) {
        this.descripcionAplicacion = descripcionAplicacion;
    }

    public String getUrlAplicacion() {
        return urlAplicacion;
    }

    public void setUrlAplicacion(String urlAplicacion) {
        this.urlAplicacion = urlAplicacion;
    }

    public String getIconoAplicacion() {
        return iconoAplicacion;
    }

    public void setIconoAplicacion(String iconoAplicacion) {
        this.iconoAplicacion = iconoAplicacion;
    }

    public String getBannerAplicacion() {
        return bannerAplicacion;
    }

    public void setBannerAplicacion(String bannerAplicacion) {
        this.bannerAplicacion = bannerAplicacion;
    }

    public Boolean getActivoAplicacion() {
        return activoAplicacion;
    }

    public void setActivoAplicacion(Boolean activoAplicacion) {
        this.activoAplicacion = activoAplicacion;
    }

    @XmlTransient
    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAplicacion != null ? idAplicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aplicacion)) {
            return false;
        }
        Aplicacion other = (Aplicacion) object;
        if ((this.idAplicacion == null && other.idAplicacion != null) || (this.idAplicacion != null && !this.idAplicacion.equals(other.idAplicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kruger.servicio.admin.model.Aplicacion[ idAplicacion=" + idAplicacion + " ]";
    }
    
}
