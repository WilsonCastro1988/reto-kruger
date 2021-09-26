package com.kruger.ec.repository.core;


import com.kruger.ec.entity.core.KgrtVaccination;
import com.kruger.ec.entity.core.KgrtVaccinationStatus;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KgrtVaccinationStatusRepo extends PagingAndSortingRepository<KgrtVaccinationStatus, Long> {




}
