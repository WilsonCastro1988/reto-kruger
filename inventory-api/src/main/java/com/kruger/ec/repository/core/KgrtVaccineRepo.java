package com.kruger.ec.repository.core;


import com.kruger.ec.entity.core.KgrtVaccinationStatus;
import com.kruger.ec.entity.core.KgrtVaccine;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KgrtVaccineRepo extends PagingAndSortingRepository<KgrtVaccine, Long> {




}
