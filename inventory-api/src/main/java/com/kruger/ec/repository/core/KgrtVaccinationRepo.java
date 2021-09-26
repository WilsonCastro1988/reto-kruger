package com.kruger.ec.repository.core;


import com.kruger.ec.entity.core.KgrtEmployee;
import com.kruger.ec.entity.core.KgrtVaccination;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KgrtVaccinationRepo extends PagingAndSortingRepository<KgrtVaccination, Long> {




}
