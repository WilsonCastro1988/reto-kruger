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
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author UISEK
 */
@Getter
@Setter
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


    
}
