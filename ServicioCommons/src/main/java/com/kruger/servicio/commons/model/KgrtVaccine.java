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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "kgrt_vaccine", catalog = "vaccination_inventory", schema = "vaccination")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KgrtVaccine.findAll", query = "SELECT k FROM KgrtVaccine k")
    , @NamedQuery(name = "KgrtVaccine.findByVaccinelId", query = "SELECT k FROM KgrtVaccine k WHERE k.vaccinelId = :vaccinelId")
    , @NamedQuery(name = "KgrtVaccine.findByVaccinevName", query = "SELECT k FROM KgrtVaccine k WHERE k.vaccinevName = :vaccinevName")
    , @NamedQuery(name = "KgrtVaccine.findByVaccinevLot", query = "SELECT k FROM KgrtVaccine k WHERE k.vaccinevLot = :vaccinevLot")
    , @NamedQuery(name = "KgrtVaccine.findByVaccinebActive", query = "SELECT k FROM KgrtVaccine k WHERE k.vaccinebActive = :vaccinebActive")
    , @NamedQuery(name = "KgrtVaccine.findByAudidCreationDate", query = "SELECT k FROM KgrtVaccine k WHERE k.audidCreationDate = :audidCreationDate")
    , @NamedQuery(name = "KgrtVaccine.findByAudivUserCreation", query = "SELECT k FROM KgrtVaccine k WHERE k.audivUserCreation = :audivUserCreation")
    , @NamedQuery(name = "KgrtVaccine.findByAudidModificationDate", query = "SELECT k FROM KgrtVaccine k WHERE k.audidModificationDate = :audidModificationDate")
    , @NamedQuery(name = "KgrtVaccine.findByAudivUserModification", query = "SELECT k FROM KgrtVaccine k WHERE k.audivUserModification = :audivUserModification")
    , @NamedQuery(name = "KgrtVaccine.findByAudidDeleteDate", query = "SELECT k FROM KgrtVaccine k WHERE k.audidDeleteDate = :audidDeleteDate")
    , @NamedQuery(name = "KgrtVaccine.findByAudivUserDelete", query = "SELECT k FROM KgrtVaccine k WHERE k.audivUserDelete = :audivUserDelete")})
public class KgrtVaccine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vaccinel_id")
    private Long vaccinelId;
    @Column(name = "vaccinev_name")
    private String vaccinevName;
    @Column(name = "vaccinev_lot")
    private String vaccinevLot;
    @Column(name = "vaccineb_active")
    private Boolean vaccinebActive;
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
    @OneToMany(mappedBy = "vaccinelId")
    private Collection<KgrtVaccination> kgrtVaccinationCollection;

    public KgrtVaccine() {
    }

    public KgrtVaccine(Long vaccinelId) {
        this.vaccinelId = vaccinelId;
    }

    public Long getVaccinelId() {
        return vaccinelId;
    }

    public void setVaccinelId(Long vaccinelId) {
        this.vaccinelId = vaccinelId;
    }

    public String getVaccinevName() {
        return vaccinevName;
    }

    public void setVaccinevName(String vaccinevName) {
        this.vaccinevName = vaccinevName;
    }

    public String getVaccinevLot() {
        return vaccinevLot;
    }

    public void setVaccinevLot(String vaccinevLot) {
        this.vaccinevLot = vaccinevLot;
    }

    public Boolean getVaccinebActive() {
        return vaccinebActive;
    }

    public void setVaccinebActive(Boolean vaccinebActive) {
        this.vaccinebActive = vaccinebActive;
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
        hash += (vaccinelId != null ? vaccinelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KgrtVaccine)) {
            return false;
        }
        KgrtVaccine other = (KgrtVaccine) object;
        if ((this.vaccinelId == null && other.vaccinelId != null) || (this.vaccinelId != null && !this.vaccinelId.equals(other.vaccinelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kruger.servicio.commons.model.entity.KgrtVaccine[ vaccinelId=" + vaccinelId + " ]";
    }
    
}
