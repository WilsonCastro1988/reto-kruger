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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "kgrt_vaccination", catalog = "vaccination_inventory", schema = "vaccination")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KgrtVaccination.findAll", query = "SELECT k FROM KgrtVaccination k")
    , @NamedQuery(name = "KgrtVaccination.findByVaccinationlId", query = "SELECT k FROM KgrtVaccination k WHERE k.vaccinationlId = :vaccinationlId")
    , @NamedQuery(name = "KgrtVaccination.findByVaccinationiDose", query = "SELECT k FROM KgrtVaccination k WHERE k.vaccinationiDose = :vaccinationiDose")
    , @NamedQuery(name = "KgrtVaccination.findByVaccinationvObservation", query = "SELECT k FROM KgrtVaccination k WHERE k.vaccinationvObservation = :vaccinationvObservation")
    , @NamedQuery(name = "KgrtVaccination.findByVaccinationdDate", query = "SELECT k FROM KgrtVaccination k WHERE k.vaccinationdDate = :vaccinationdDate")
    , @NamedQuery(name = "KgrtVaccination.findByVaccinationvPathLicense", query = "SELECT k FROM KgrtVaccination k WHERE k.vaccinationvPathLicense = :vaccinationvPathLicense")
    , @NamedQuery(name = "KgrtVaccination.findByVaccinationbActive", query = "SELECT k FROM KgrtVaccination k WHERE k.vaccinationbActive = :vaccinationbActive")
    , @NamedQuery(name = "KgrtVaccination.findByAudidCreationDate", query = "SELECT k FROM KgrtVaccination k WHERE k.audidCreationDate = :audidCreationDate")
    , @NamedQuery(name = "KgrtVaccination.findByAudivUserCreation", query = "SELECT k FROM KgrtVaccination k WHERE k.audivUserCreation = :audivUserCreation")
    , @NamedQuery(name = "KgrtVaccination.findByAudidModificationDate", query = "SELECT k FROM KgrtVaccination k WHERE k.audidModificationDate = :audidModificationDate")
    , @NamedQuery(name = "KgrtVaccination.findByAudivUserModification", query = "SELECT k FROM KgrtVaccination k WHERE k.audivUserModification = :audivUserModification")
    , @NamedQuery(name = "KgrtVaccination.findByAudidDeleteDate", query = "SELECT k FROM KgrtVaccination k WHERE k.audidDeleteDate = :audidDeleteDate")
    , @NamedQuery(name = "KgrtVaccination.findByAudivUserDelete", query = "SELECT k FROM KgrtVaccination k WHERE k.audivUserDelete = :audivUserDelete")})
public class KgrtVaccination implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vaccinationl_id")
    private Long vaccinationlId;
    @Column(name = "vaccinationi_dose")
    private Integer vaccinationiDose;
    @Column(name = "vaccinationv_observation")
    private String vaccinationvObservation;
    @Column(name = "vaccinationd_date")
    @Temporal(TemporalType.DATE)
    private Date vaccinationdDate;
    @Column(name = "vaccinationv_path_license")
    private String vaccinationvPathLicense;
    @Column(name = "vaccinationb_active")
    private Boolean vaccinationbActive;
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
    @JoinColumn(name = "employeev_dni", referencedColumnName = "employeev_dni")
    @ManyToOne
    private KgrtEmployee employeevDni;
    @JoinColumn(name = "vaccinel_id", referencedColumnName = "vaccinel_id")
    @ManyToOne
    private KgrtVaccine vaccinelId;
    @OneToMany(mappedBy = "vaccinationlId")
    private Collection<KgrtVaccinationStatus> kgrtVaccinationStatusCollection;

    public KgrtVaccination() {
    }

    public KgrtVaccination(Long vaccinationlId) {
        this.vaccinationlId = vaccinationlId;
    }

    public Long getVaccinationlId() {
        return vaccinationlId;
    }

    public void setVaccinationlId(Long vaccinationlId) {
        this.vaccinationlId = vaccinationlId;
    }

    public Integer getVaccinationiDose() {
        return vaccinationiDose;
    }

    public void setVaccinationiDose(Integer vaccinationiDose) {
        this.vaccinationiDose = vaccinationiDose;
    }

    public String getVaccinationvObservation() {
        return vaccinationvObservation;
    }

    public void setVaccinationvObservation(String vaccinationvObservation) {
        this.vaccinationvObservation = vaccinationvObservation;
    }

    public Date getVaccinationdDate() {
        return vaccinationdDate;
    }

    public void setVaccinationdDate(Date vaccinationdDate) {
        this.vaccinationdDate = vaccinationdDate;
    }

    public String getVaccinationvPathLicense() {
        return vaccinationvPathLicense;
    }

    public void setVaccinationvPathLicense(String vaccinationvPathLicense) {
        this.vaccinationvPathLicense = vaccinationvPathLicense;
    }

    public Boolean getVaccinationbActive() {
        return vaccinationbActive;
    }

    public void setVaccinationbActive(Boolean vaccinationbActive) {
        this.vaccinationbActive = vaccinationbActive;
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

    public KgrtEmployee getEmployeevDni() {
        return employeevDni;
    }

    public void setEmployeevDni(KgrtEmployee employeevDni) {
        this.employeevDni = employeevDni;
    }

    public KgrtVaccine getVaccinelId() {
        return vaccinelId;
    }

    public void setVaccinelId(KgrtVaccine vaccinelId) {
        this.vaccinelId = vaccinelId;
    }

    @XmlTransient
    public Collection<KgrtVaccinationStatus> getKgrtVaccinationStatusCollection() {
        return kgrtVaccinationStatusCollection;
    }

    public void setKgrtVaccinationStatusCollection(Collection<KgrtVaccinationStatus> kgrtVaccinationStatusCollection) {
        this.kgrtVaccinationStatusCollection = kgrtVaccinationStatusCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vaccinationlId != null ? vaccinationlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KgrtVaccination)) {
            return false;
        }
        KgrtVaccination other = (KgrtVaccination) object;
        if ((this.vaccinationlId == null && other.vaccinationlId != null) || (this.vaccinationlId != null && !this.vaccinationlId.equals(other.vaccinationlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kruger.servicio.commons.model.entity.KgrtVaccination[ vaccinationlId=" + vaccinationlId + " ]";
    }
    
}
