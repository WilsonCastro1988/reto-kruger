import {KgrtVaccinationDto} from "@/dto/KgrtVaccinationDto";

export class KgrtEmployeeDto {
  employeevDni: string;
  employeevName: string;
  employeevLastname: string;
  employeedBirthDate: Date;
  employeevAdrress: string;
  employeevMail: string;
  employeevPhone: string;
  employeebActive: boolean;
  audidCreationDate: Date;
  audivUserCreation: string;
  audidModificationDate: Date;
  audivUserModification: string;
  audidDeleteDate: Date;
  audivUserDelete: string;
  flagemployeevUser: string;
  kgrtVaccinationCollectionDTO:KgrtVaccinationDto[];
}
