package com.kruger.ec.dto.core;

import com.kruger.ec.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class KgrtVaccinationStatusDto extends AbstractDto<Long> {

    private Long vaccinationStatuslId;
    
    private String vaccinationStatusvName;
    
    private String vaccinationStatusvObservation;
    
    private Boolean vaccinationStatusbActive;
    
    private Date audidCreationDate;
    
    private String audivUserCreation;
    
    private Date audidModificationDate;
    
    private String audivUserModification;
    
    private Date audidDeleteDate;
    
    private String audivUserDelete;
    private KgrtVaccinationDto vaccinationlIdDTO;

}
