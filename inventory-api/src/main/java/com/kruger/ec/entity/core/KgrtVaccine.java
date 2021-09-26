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
import java.util.List;

/**
 *
 * @author UISEK
 */
@Getter
@Setter
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
    @OneToMany(mappedBy = "vaccinelId")
    private List<KgrtVaccination> kgrtVaccinationCollection;


}
