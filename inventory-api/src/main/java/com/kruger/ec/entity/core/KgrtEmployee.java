/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kruger.ec.entity.core;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author UISEK
 */
@Getter
@Setter
@Entity
@Table(name = "kgrt_employee", catalog = "vaccination_inventory", schema = "vaccination")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KgrtEmployee.findAll", query = "SELECT k FROM KgrtEmployee k")
    , @NamedQuery(name = "KgrtEmployee.findByEmployeevDni", query = "SELECT k FROM KgrtEmployee k WHERE k.employeevDni = :employeevDni")
    , @NamedQuery(name = "KgrtEmployee.findByEmployeevName", query = "SELECT k FROM KgrtEmployee k WHERE k.employeevName = :employeevName")
    , @NamedQuery(name = "KgrtEmployee.findByEmployeevLastname", query = "SELECT k FROM KgrtEmployee k WHERE k.employeevLastname = :employeevLastname")
    , @NamedQuery(name = "KgrtEmployee.findByEmployeedBirthDate", query = "SELECT k FROM KgrtEmployee k WHERE k.employeedBirthDate = :employeedBirthDate")
    , @NamedQuery(name = "KgrtEmployee.findByEmployeevAdrress", query = "SELECT k FROM KgrtEmployee k WHERE k.employeevAdrress = :employeevAdrress")
    , @NamedQuery(name = "KgrtEmployee.findByEmployeevMail", query = "SELECT k FROM KgrtEmployee k WHERE k.employeevMail = :employeevMail")
    , @NamedQuery(name = "KgrtEmployee.findByEmployeevPhone", query = "SELECT k FROM KgrtEmployee k WHERE k.employeevPhone = :employeevPhone")
    , @NamedQuery(name = "KgrtEmployee.findByEmployeebActive", query = "SELECT k FROM KgrtEmployee k WHERE k.employeebActive = :employeebActive")
    , @NamedQuery(name = "KgrtEmployee.findByAudidCreationDate", query = "SELECT k FROM KgrtEmployee k WHERE k.audidCreationDate = :audidCreationDate")
    , @NamedQuery(name = "KgrtEmployee.findByAudivUserCreation", query = "SELECT k FROM KgrtEmployee k WHERE k.audivUserCreation = :audivUserCreation")
    , @NamedQuery(name = "KgrtEmployee.findByAudidModificationDate", query = "SELECT k FROM KgrtEmployee k WHERE k.audidModificationDate = :audidModificationDate")
    , @NamedQuery(name = "KgrtEmployee.findByAudivUserModification", query = "SELECT k FROM KgrtEmployee k WHERE k.audivUserModification = :audivUserModification")
    , @NamedQuery(name = "KgrtEmployee.findByAudidDeleteDate", query = "SELECT k FROM KgrtEmployee k WHERE k.audidDeleteDate = :audidDeleteDate")
    , @NamedQuery(name = "KgrtEmployee.findByAudivUserDelete", query = "SELECT k FROM KgrtEmployee k WHERE k.audivUserDelete = :audivUserDelete")
    , @NamedQuery(name = "KgrtEmployee.findByFlagemployeevUser", query = "SELECT k FROM KgrtEmployee k WHERE k.flagemployeevUser = :flagemployeevUser")})
public class KgrtEmployee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "employeev_dni")
    private String employeevDni;
    @Column(name = "employeev_name")
    private String employeevName;
    @Column(name = "employeev_lastname")
    private String employeevLastname;
    @Column(name = "employeed_birth_date")
    @Temporal(TemporalType.DATE)
    private Date employeedBirthDate;
    @Column(name = "employeev_adrress")
    private String employeevAdrress;
    @Column(name = "employeev_mail")
    private String employeevMail;
    @Column(name = "employeev_phone")
    private String employeevPhone;
    @Column(name = "employeeb_active")
    private Boolean employeebActive;
    @Column(name = "audid_creation_date")
    @Temporal(TemporalType.DATE)
    private Date audidCreationDate;
    @Column(name = "audiv_user_creation")
    private String audivUserCreation;
    @Column(name = "audid_modification_date")
    @Temporal(TemporalType.DATE)
    private Date audidModificationDate;
    @Column(name = "audiv_user_modification")
    private String audivUserModification;
    @Column(name = "audid_delete_date")
    @Temporal(TemporalType.DATE)
    private Date audidDeleteDate;
    @Column(name = "audiv_user_delete")
    private String audivUserDelete;
    @Column(name = "flagemployeev_user")
    private String flagemployeevUser;
    @OneToMany(mappedBy = "employeevDni")
    private List<KgrtVaccination> kgrtVaccinationCollection;


}
