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
import java.util.List;

/**
 *
 * @author UISEK
 */
@Getter
@Setter
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


}
