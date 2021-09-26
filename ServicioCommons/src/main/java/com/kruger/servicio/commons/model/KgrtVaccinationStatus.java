/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kruger.servicio.commons.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UISEK
 */
@Entity
@Table(name = "kgrt_vaccination_status", catalog = "vaccination_inventory", schema = "vaccination")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KgrtVaccinationStatus.findAll", query = "SELECT k FROM KgrtVaccinationStatus k")
    , @NamedQuery(name = "KgrtVaccinationStatus.findByVaccinationStatuslId", query = "SELECT k FROM KgrtVaccinationStatus k WHERE k.vaccinationStatuslId = :vaccinationStatuslId")
    , @NamedQuery(name = "KgrtVaccinationStatus.findByVaccinationStatusvName", query = "SELECT k FROM KgrtVaccinationStatus k WHERE k.vaccinationStatusvName = :vaccinationStatusvName")
    , @NamedQuery(name = "KgrtVaccinationStatus.findByVaccinationStatusvObservation", query = "SELECT k FROM KgrtVaccinationStatus k WHERE k.vaccinationStatusvObservation = :vaccinationStatusvObservation")
    , @NamedQuery(name = "KgrtVaccinationStatus.findByVaccinationStatusbActive", query = "SELECT k FROM KgrtVaccinationStatus k WHERE k.vaccinationStatusbActive = :vaccinationStatusbActive")
    , @NamedQuery(name = "KgrtVaccinationStatus.findByAudidCreationDate", query = "SELECT k FROM KgrtVaccinationStatus k WHERE k.audidCreationDate = :audidCreationDate")
    , @NamedQuery(name = "KgrtVaccinationStatus.findByAudivUserCreation", query = "SELECT k FROM KgrtVaccinationStatus k WHERE k.audivUserCreation = :audivUserCreation")
    , @NamedQuery(name = "KgrtVaccinationStatus.findByAudidModificationDate", query = "SELECT k FROM KgrtVaccinationStatus k WHERE k.audidModificationDate = :audidModificationDate")
    , @NamedQuery(name = "KgrtVaccinationStatus.findByAudivUserModification", query = "SELECT k FROM KgrtVaccinationStatus k WHERE k.audivUserModification = :audivUserModification")
    , @NamedQuery(name = "KgrtVaccinationStatus.findByAudidDeleteDate", query = "SELECT k FROM KgrtVaccinationStatus k WHERE k.audidDeleteDate = :audidDeleteDate")
    , @NamedQuery(name = "KgrtVaccinationStatus.findByAudivUserDelete", query = "SELECT k FROM KgrtVaccinationStatus k WHERE k.audivUserDelete = :audivUserDelete")})
public class KgrtVaccinationStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vaccination_statusl_id")
    private Long vaccinationStatuslId;
    @Column(name = "vaccination_statusv_name")
    private String vaccinationStatusvName;
    @Column(name = "vaccination_statusv_observation")
    private String vaccinationStatusvObservation;
    @Column(name = "vaccination_statusb_active")
    private Boolean vaccinationStatusbActive;
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
    @JoinColumn(name = "vaccinationl_id", referencedColumnName = "vaccinationl_id")
    @ManyToOne
    private KgrtVaccination vaccinationlId;

    public KgrtVaccinationStatus() {
    }

    public KgrtVaccinationStatus(Long vaccinationStatuslId) {
        this.vaccinationStatuslId = vaccinationStatuslId;
    }

    public Long getVaccinationStatuslId() {
        return vaccinationStatuslId;
    }

    public void setVaccinationStatuslId(Long vaccinationStatuslId) {
        this.vaccinationStatuslId = vaccinationStatuslId;
    }

    public String getVaccinationStatusvName() {
        return vaccinationStatusvName;
    }

    public void setVaccinationStatusvName(String vaccinationStatusvName) {
        this.vaccinationStatusvName = vaccinationStatusvName;
    }

    public String getVaccinationStatusvObservation() {
        return vaccinationStatusvObservation;
    }

    public void setVaccinationStatusvObservation(String vaccinationStatusvObservation) {
        this.vaccinationStatusvObservation = vaccinationStatusvObservation;
    }

    public Boolean getVaccinationStatusbActive() {
        return vaccinationStatusbActive;
    }

    public void setVaccinationStatusbActive(Boolean vaccinationStatusbActive) {
        this.vaccinationStatusbActive = vaccinationStatusbActive;
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

    public KgrtVaccination getVaccinationlId() {
        return vaccinationlId;
    }

    public void setVaccinationlId(KgrtVaccination vaccinationlId) {
        this.vaccinationlId = vaccinationlId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vaccinationStatuslId != null ? vaccinationStatuslId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KgrtVaccinationStatus)) {
            return false;
        }
        KgrtVaccinationStatus other = (KgrtVaccinationStatus) object;
        if ((this.vaccinationStatuslId == null && other.vaccinationStatuslId != null) || (this.vaccinationStatuslId != null && !this.vaccinationStatuslId.equals(other.vaccinationStatuslId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kruger.servicio.commons.model.entity.KgrtVaccinationStatus[ vaccinationStatuslId=" + vaccinationStatuslId + " ]";
    }
    
}
