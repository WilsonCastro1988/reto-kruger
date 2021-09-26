package com.kruger.ec.dto.core;
import com.kruger.ec.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class KgrtVaccineDto extends AbstractDto<Long> {

    private Long vaccinelId;
    
    private String vaccinevName;
    
    private String vaccinevLot;
    
    private Boolean vaccinebActive;
    
    private Date audidCreationDate;
    
    private String audivUserCreation;
    
    private Date audidModificationDate;
    
    private String audivUserModification;
    
    private Date audidDeleteDate;
    
    private String audivUserDelete;
    private List<KgrtVaccinationDto> kgrtVaccinationCollectionDTO;


}
