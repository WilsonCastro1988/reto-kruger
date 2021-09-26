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
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author UISEK
 */
@Getter
@Setter
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
    @JoinColumn(name = "vaccinationl_id", referencedColumnName = "vaccinationl_id")
    @ManyToOne
    private KgrtVaccination vaccinationlId;


}
