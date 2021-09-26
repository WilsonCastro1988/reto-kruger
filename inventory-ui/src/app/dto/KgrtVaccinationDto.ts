import {KgrtEmployeeDto} from "@/dto/KgrtEmployeeDto";
import {KrgtVaccineDto} from "@/dto/KgrtVaccineDto";
import {KgrtVaccinationStatusDto} from "@/dto/KgrtVaccinationStatusDto";

export class KgrtVaccinationDto {
  vaccinationlId: number;
  vaccinationiDose: number;
  vaccinationvObservation: string;
  vaccinationdDate: Date;
  vaccinationvPathLicense: string;
  vaccinationbActive: boolean;
  audidCreationDate: Date;
  audivUserCreation: string;
  audidModificationDate: Date;
  audivUserModification: string;
  audidDeleteDate: Date;
  audivUserDelete: string;
  employeevDniDTO: KgrtEmployeeDto;
  vaccinelIdDTO: KrgtVaccineDto;
  kgrtVaccinationStatusCollectionDTO: KgrtVaccinationStatusDto[];
}
