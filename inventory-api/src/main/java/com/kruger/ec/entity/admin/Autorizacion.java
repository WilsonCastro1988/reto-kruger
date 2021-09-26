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


    
}
