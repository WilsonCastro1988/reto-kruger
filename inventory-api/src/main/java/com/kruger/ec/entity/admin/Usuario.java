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
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByNombreUsuario", query = "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario")
    , @NamedQuery(name = "Usuario.findByDniUsuario", query = "SELECT u FROM Usuario u WHERE u.dniUsuario = :dniUsuario")
    , @NamedQuery(name = "Usuario.findByTipoDniUsuario", query = "SELECT u FROM Usuario u WHERE u.tipoDniUsuario = :tipoDniUsuario")
    , @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password")
    , @NamedQuery(name = "Usuario.findByEmailPersonalUsuario", query = "SELECT u FROM Usuario u WHERE u.emailPersonalUsuario = :emailPersonalUsuario")
    , @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")
    , @NamedQuery(name = "Usuario.findByFechaCreacionUsuario", query = "SELECT u FROM Usuario u WHERE u.fechaCreacionUsuario = :fechaCreacionUsuario")
    , @NamedQuery(name = "Usuario.findByFechaActualizacionUsuario", query = "SELECT u FROM Usuario u WHERE u.fechaActualizacionUsuario = :fechaActualizacionUsuario")
    , @NamedQuery(name = "Usuario.findByActivoUsuario", query = "SELECT u FROM Usuario u WHERE u.activoUsuario = :activoUsuario")
    , @NamedQuery(name = "Usuario.findByFotoUsuario", query = "SELECT u FROM Usuario u WHERE u.fotoUsuario = :fotoUsuario")
    , @NamedQuery(name = "Usuario.findByNombresUsuario", query = "SELECT u FROM Usuario u WHERE u.nombresUsuario = :nombresUsuario")
    , @NamedQuery(name = "Usuario.findByApellidosUsuario", query = "SELECT u FROM Usuario u WHERE u.apellidosUsuario = :apellidosUsuario")
    , @NamedQuery(name = "Usuario.findByFaUsuario", query = "SELECT u FROM Usuario u WHERE u.faUsuario = :faUsuario")
    , @NamedQuery(name = "Usuario.findByTipo2faUsuario", query = "SELECT u FROM Usuario u WHERE u.tipo2faUsuario = :tipo2faUsuario")
    , @NamedQuery(name = "Usuario.findByIntentosUsuario", query = "SELECT u FROM Usuario u WHERE u.intentosUsuario = :intentosUsuario")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;
    @Column(name = "DNI_USUARIO")
    private String dniUsuario;
    @Column(name = "TIPO_DNI_USUARIO")
    private String tipoDniUsuario;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL_PERSONAL_USUARIO")
    private String emailPersonalUsuario;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "FECHA_CREACION_USUARIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacionUsuario;
    @Column(name = "FECHA_ACTUALIZACION_USUARIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacionUsuario;
    @Column(name = "ACTIVO_USUARIO")
    private Boolean activoUsuario;
    @Column(name = "FOTO_USUARIO")
    private String fotoUsuario;
    @Column(name = "NOMBRES_USUARIO")
    private String nombresUsuario;
    @Column(name = "APELLIDOS_USUARIO")
    private String apellidosUsuario;
    @Column(name = "FA_USUARIO")
    private Boolean faUsuario;
    @Column(name = "TIPO2FA_USUARIO")
    private String tipo2faUsuario;
    @Column(name = "INTENTOS_USUARIO")
    private Integer intentosUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<UsuarioPerfil> usuarioPerfilList;


    
}
