package com.kruger.ec.dto.core;


import com.kruger.ec.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class KgrtVaccinationDto extends AbstractDto<Long> {

    private Long vaccinationlId;
    
    private Integer vaccinationiDose;
    
    private String vaccinationvObservation;
    
    private Date vaccinationdDate;
    
    private String vaccinationvPathLicense;
    
    private Boolean vaccinationbActive;
    
    private Date audidCreationDate;
    
    private String audivUserCreation;
    
    private Date audidModificationDate;
    
    private String audivUserModification;
    
    private Date audidDeleteDate;
    
    private String audivUserDelete;
    private KgrtEmployeeDto employeevDniDTO;
    private KgrtVaccineDto vaccinelIdDTO;
    private List<KgrtVaccinationStatusDto> kgrtVaccinationStatusCollectionDTO;

}
