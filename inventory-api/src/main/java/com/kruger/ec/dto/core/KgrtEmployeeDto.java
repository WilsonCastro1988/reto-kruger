package com.kruger.ec.dto.core;

import com.kruger.ec.dto.AbstractDto;
import com.kruger.ec.entity.core.KgrtVaccination;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class KgrtEmployeeDto extends AbstractDto<Long> {

    private String employeevDni;
    
    private String employeevName;
    
    private String employeevLastname;
    
    private Date employeedBirthDate;
    
    private String employeevAdrress;
    
    private String employeevMail;
    
    private String employeevPhone;
    
    private Boolean employeebActive;
    
    private Date audidCreationDate;
    
    private String audivUserCreation;
    
    private Date audidModificationDate;
    
    private String audivUserModification;
    
    private Date audidDeleteDate;
    
    private String audivUserDelete;
    
    private String flagemployeevUser;
    private List<KgrtVaccination> kgrtVaccinationCollectionDTO;


}
