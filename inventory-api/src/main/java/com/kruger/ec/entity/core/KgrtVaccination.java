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
import java.util.List;
import java.util.Date;

/**
 *
 * @author UISEK
 */
@Getter
@Setter
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
    @JoinColumn(name = "employeev_dni", referencedColumnName = "employeev_dni")
    @ManyToOne
    private KgrtEmployee employeevDni;
    @JoinColumn(name = "vaccinel_id", referencedColumnName = "vaccinel_id")
    @ManyToOne
    private KgrtVaccine vaccinelId;
    @OneToMany(mappedBy = "vaccinationlId")
    private List<KgrtVaccinationStatus> kgrtVaccinationStatusCollection;


    
}
