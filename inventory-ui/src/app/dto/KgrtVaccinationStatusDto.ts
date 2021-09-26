import {KgrtVaccinationDto} from "@/dto/KgrtVaccinationDto";

export class KgrtVaccinationStatusDto {
  vaccinationStatuslId: number;
  vaccinationStatusvName: string;
  vaccinationStatusvObservation: string;
  vaccinationStatusbActive: boolean;
  audidCreationDate: Date;
  audivUserCreation: string;
  audidModificationDate: Date;
  audivUserModification: string;
  audidDeleteDate: Date;
  audivUserDelete: string;
  vaccinationlIdDTO: KgrtVaccinationDto;
}
