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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

    public Usuario() {
    }

    public Usuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public String getTipoDniUsuario() {
        return tipoDniUsuario;
    }

    public void setTipoDniUsuario(String tipoDniUsuario) {
        this.tipoDniUsuario = tipoDniUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailPersonalUsuario() {
        return emailPersonalUsuario;
    }

    public void setEmailPersonalUsuario(String emailPersonalUsuario) {
        this.emailPersonalUsuario = emailPersonalUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaCreacionUsuario() {
        return fechaCreacionUsuario;
    }

    public void setFechaCreacionUsuario(Date fechaCreacionUsuario) {
        this.fechaCreacionUsuario = fechaCreacionUsuario;
    }

    public Date getFechaActualizacionUsuario() {
        return fechaActualizacionUsuario;
    }

    public void setFechaActualizacionUsuario(Date fechaActualizacionUsuario) {
        this.fechaActualizacionUsuario = fechaActualizacionUsuario;
    }

    public Boolean getActivoUsuario() {
        return activoUsuario;
    }

    public void setActivoUsuario(Boolean activoUsuario) {
        this.activoUsuario = activoUsuario;
    }

    public String getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(String fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }

    public String getNombresUsuario() {
        return nombresUsuario;
    }

    public void setNombresUsuario(String nombresUsuario) {
        this.nombresUsuario = nombresUsuario;
    }

    public String getApellidosUsuario() {
        return apellidosUsuario;
    }

    public void setApellidosUsuario(String apellidosUsuario) {
        this.apellidosUsuario = apellidosUsuario;
    }

    public Boolean getFaUsuario() {
        return faUsuario;
    }

    public void setFaUsuario(Boolean faUsuario) {
        this.faUsuario = faUsuario;
    }

    public String getTipo2faUsuario() {
        return tipo2faUsuario;
    }

    public void setTipo2faUsuario(String tipo2faUsuario) {
        this.tipo2faUsuario = tipo2faUsuario;
    }

    public Integer getIntentosUsuario() {
        return intentosUsuario;
    }

    public void setIntentosUsuario(Integer intentosUsuario) {
        this.intentosUsuario = intentosUsuario;
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
        hash += (nombreUsuario != null ? nombreUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.nombreUsuario == null && other.nombreUsuario != null) || (this.nombreUsuario != null && !this.nombreUsuario.equals(other.nombreUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kruger.servicio.admin.model.Usuario[ nombreUsuario=" + nombreUsuario + " ]";
    }
    
}
