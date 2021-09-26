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


    
}
