/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kruger.servicio.admin.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UISEK
 */
@Entity
@Table(name = "MENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
    , @NamedQuery(name = "Menu.findByIdMenu", query = "SELECT m FROM Menu m WHERE m.idMenu = :idMenu")
    , @NamedQuery(name = "Menu.findByIdMenuPadre", query = "SELECT m FROM Menu m WHERE m.idMenuPadre = :idMenuPadre")
    , @NamedQuery(name = "Menu.findByIdAplicaciones", query = "SELECT m FROM Menu m WHERE m.idAplicaciones = :idAplicaciones")
    , @NamedQuery(name = "Menu.findByNombreMenu", query = "SELECT m FROM Menu m WHERE m.nombreMenu = :nombreMenu")
    , @NamedQuery(name = "Menu.findByDescripcionMenu", query = "SELECT m FROM Menu m WHERE m.descripcionMenu = :descripcionMenu")
    , @NamedQuery(name = "Menu.findByUrlMenu", query = "SELECT m FROM Menu m WHERE m.urlMenu = :urlMenu")
    , @NamedQuery(name = "Menu.findByTipoMenu", query = "SELECT m FROM Menu m WHERE m.tipoMenu = :tipoMenu")
    , @NamedQuery(name = "Menu.findByOrdenMenu", query = "SELECT m FROM Menu m WHERE m.ordenMenu = :ordenMenu")
    , @NamedQuery(name = "Menu.findByActivoMenu", query = "SELECT m FROM Menu m WHERE m.activoMenu = :activoMenu")
    , @NamedQuery(name = "Menu.findByIconoMenu", query = "SELECT m FROM Menu m WHERE m.iconoMenu = :iconoMenu")
    , @NamedQuery(name = "Menu.findByIconoposMenu", query = "SELECT m FROM Menu m WHERE m.iconoposMenu = :iconoposMenu")
    , @NamedQuery(name = "Menu.findByLabelMenu", query = "SELECT m FROM Menu m WHERE m.labelMenu = :labelMenu")
    , @NamedQuery(name = "Menu.findByFechaAperturaMenu", query = "SELECT m FROM Menu m WHERE m.fechaAperturaMenu = :fechaAperturaMenu")
    , @NamedQuery(name = "Menu.findByFechaCierreMenu", query = "SELECT m FROM Menu m WHERE m.fechaCierreMenu = :fechaCierreMenu")
    , @NamedQuery(name = "Menu.findByAperturadoMenu", query = "SELECT m FROM Menu m WHERE m.aperturadoMenu = :aperturadoMenu")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_MENU")
    private Integer idMenu;
    @Column(name = "ID_MENU_PADRE")
    private Integer idMenuPadre;
    @Column(name = "ID_APLICACIONES")
    private Integer idAplicaciones;
    @Column(name = "NOMBRE_MENU")
    private String nombreMenu;
    @Column(name = "DESCRIPCION_MENU")
    private String descripcionMenu;
    @Column(name = "URL_MENU")
    private String urlMenu;
    @Column(name = "TIPO_MENU")
    private String tipoMenu;
    @Column(name = "ORDEN_MENU")
    private Integer ordenMenu;
    @Column(name = "ACTIVO_MENU")
    private Boolean activoMenu;
    @Column(name = "ICONO_MENU")
    private String iconoMenu;
    @Column(name = "ICONOPOS_MENU")
    private String iconoposMenu;
    @Column(name = "LABEL_MENU")
    private String labelMenu;
    @Column(name = "FECHA_APERTURA_MENU")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAperturaMenu;
    @Column(name = "FECHA_CIERRE_MENU")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCierreMenu;
    @Column(name = "APERTURADO_MENU")
    private Boolean aperturadoMenu;
    @OneToMany(mappedBy = "idMenu")
    private List<Autorizacion> autorizacionList;
    @JoinColumn(name = "ID_APLICACION", referencedColumnName = "ID_APLICACION")
    @ManyToOne
    private Aplicacion idAplicacion;
    @OneToMany(mappedBy = "menIdMenu")
    private List<Menu> menuList;
    @JoinColumn(name = "MEN_ID_MENU", referencedColumnName = "ID_MENU")
    @ManyToOne
    private Menu menIdMenu;

    public Menu() {
    }

    public Menu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Integer getIdMenuPadre() {
        return idMenuPadre;
    }

    public void setIdMenuPadre(Integer idMenuPadre) {
        this.idMenuPadre = idMenuPadre;
    }

    public Integer getIdAplicaciones() {
        return idAplicaciones;
    }

    public void setIdAplicaciones(Integer idAplicaciones) {
        this.idAplicaciones = idAplicaciones;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    public String getDescripcionMenu() {
        return descripcionMenu;
    }

    public void setDescripcionMenu(String descripcionMenu) {
        this.descripcionMenu = descripcionMenu;
    }

    public String getUrlMenu() {
        return urlMenu;
    }

    public void setUrlMenu(String urlMenu) {
        this.urlMenu = urlMenu;
    }

    public String getTipoMenu() {
        return tipoMenu;
    }

    public void setTipoMenu(String tipoMenu) {
        this.tipoMenu = tipoMenu;
    }

    public Integer getOrdenMenu() {
        return ordenMenu;
    }

    public void setOrdenMenu(Integer ordenMenu) {
        this.ordenMenu = ordenMenu;
    }

    public Boolean getActivoMenu() {
        return activoMenu;
    }

    public void setActivoMenu(Boolean activoMenu) {
        this.activoMenu = activoMenu;
    }

    public String getIconoMenu() {
        return iconoMenu;
    }

    public void setIconoMenu(String iconoMenu) {
        this.iconoMenu = iconoMenu;
    }

    public String getIconoposMenu() {
        return iconoposMenu;
    }

    public void setIconoposMenu(String iconoposMenu) {
        this.iconoposMenu = iconoposMenu;
    }

    public String getLabelMenu() {
        return labelMenu;
    }

    public void setLabelMenu(String labelMenu) {
        this.labelMenu = labelMenu;
    }

    public Date getFechaAperturaMenu() {
        return fechaAperturaMenu;
    }

    public void setFechaAperturaMenu(Date fechaAperturaMenu) {
        this.fechaAperturaMenu = fechaAperturaMenu;
    }

    public Date getFechaCierreMenu() {
        return fechaCierreMenu;
    }

    public void setFechaCierreMenu(Date fechaCierreMenu) {
        this.fechaCierreMenu = fechaCierreMenu;
    }

    public Boolean getAperturadoMenu() {
        return aperturadoMenu;
    }

    public void setAperturadoMenu(Boolean aperturadoMenu) {
        this.aperturadoMenu = aperturadoMenu;
    }

    @XmlTransient
    public List<Autorizacion> getAutorizacionList() {
        return autorizacionList;
    }

    public void setAutorizacionList(List<Autorizacion> autorizacionList) {
        this.autorizacionList = autorizacionList;
    }

    public Aplicacion getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(Aplicacion idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    @XmlTransient
    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public Menu getMenIdMenu() {
        return menIdMenu;
    }

    public void setMenIdMenu(Menu menIdMenu) {
        this.menIdMenu = menIdMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kruger.servicio.admin.model.Menu[ idMenu=" + idMenu + " ]";
    }
    
}
