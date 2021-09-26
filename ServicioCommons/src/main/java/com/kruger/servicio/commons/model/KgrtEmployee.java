/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kruger.servicio.commons.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
    private Integer audivUserCreation;
    @Column(name = "audid_modification_date")
    @Temporal(TemporalType.DATE)
    private Date audidModificationDate;
    @Column(name = "audiv_user_modification")
    private Integer audivUserModification;
    @Column(name = "audid_delete_date")
    @Temporal(TemporalType.DATE)
    private Date audidDeleteDate;
    @Column(name = "audiv_user_delete")
    private Integer audivUserDelete;
    @Column(name = "flagemployeev_user")
    private String flagemployeevUser;
    @OneToMany(mappedBy = "employeevDni")
    private Collection<KgrtVaccination> kgrtVaccinationCollection;

    public KgrtEmployee() {
    }

    public KgrtEmployee(String employeevDni) {
        this.employeevDni = employeevDni;
    }

    public String getEmployeevDni() {
        return employeevDni;
    }

    public void setEmployeevDni(String employeevDni) {
        this.employeevDni = employeevDni;
    }

    public String getEmployeevName() {
        return employeevName;
    }

    public void setEmployeevName(String employeevName) {
        this.employeevName = employeevName;
    }

    public String getEmployeevLastname() {
        return employeevLastname;
    }

    public void setEmployeevLastname(String employeevLastname) {
        this.employeevLastname = employeevLastname;
    }

    public Date getEmployeedBirthDate() {
        return employeedBirthDate;
    }

    public void setEmployeedBirthDate(Date employeedBirthDate) {
        this.employeedBirthDate = employeedBirthDate;
    }

    public String getEmployeevAdrress() {
        return employeevAdrress;
    }

    public void setEmployeevAdrress(String employeevAdrress) {
        this.employeevAdrress = employeevAdrress;
    }

    public String getEmployeevMail() {
        return employeevMail;
    }

    public void setEmployeevMail(String employeevMail) {
        this.employeevMail = employeevMail;
    }

    public String getEmployeevPhone() {
        return employeevPhone;
    }

    public void setEmployeevPhone(String employeevPhone) {
        this.employeevPhone = employeevPhone;
    }

    public Boolean getEmployeebActive() {
        return employeebActive;
    }

    public void setEmployeebActive(Boolean employeebActive) {
        this.employeebActive = employeebActive;
    }

    public Date getAudidCreationDate() {
        return audidCreationDate;
    }

    public void setAudidCreationDate(Date audidCreationDate) {
        this.audidCreationDate = audidCreationDate;
    }

    public Integer getAudivUserCreation() {
        return audivUserCreation;
    }

    public void setAudivUserCreation(Integer audivUserCreation) {
        this.audivUserCreation = audivUserCreation;
    }

    public Date getAudidModificationDate() {
        return audidModificationDate;
    }

    public void setAudidModificationDate(Date audidModificationDate) {
        this.audidModificationDate = audidModificationDate;
    }

    public Integer getAudivUserModification() {
        return audivUserModification;
    }

    public void setAudivUserModification(Integer audivUserModification) {
        this.audivUserModification = audivUserModification;
    }

    public Date getAudidDeleteDate() {
        return audidDeleteDate;
    }

    public void setAudidDeleteDate(Date audidDeleteDate) {
        this.audidDeleteDate = audidDeleteDate;
    }

    public Integer getAudivUserDelete() {
        return audivUserDelete;
    }

    public void setAudivUserDelete(Integer audivUserDelete) {
        this.audivUserDelete = audivUserDelete;
    }

    public String getFlagemployeevUser() {
        return flagemployeevUser;
    }

    public void setFlagemployeevUser(String flagemployeevUser) {
        this.flagemployeevUser = flagemployeevUser;
    }

    @XmlTransient
    public Collection<KgrtVaccination> getKgrtVaccinationCollection() {
        return kgrtVaccinationCollection;
    }

    public void setKgrtVaccinationCollection(Collection<KgrtVaccination> kgrtVaccinationCollection) {
        this.kgrtVaccinationCollection = kgrtVaccinationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeevDni != null ? employeevDni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KgrtEmployee)) {
            return false;
        }
        KgrtEmployee other = (KgrtEmployee) object;
        if ((this.employeevDni == null && other.employeevDni != null) || (this.employeevDni != null && !this.employeevDni.equals(other.employeevDni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kruger.servicio.commons.model.entity.KgrtEmployee[ employeevDni=" + employeevDni + " ]";
    }
    
}
