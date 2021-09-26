package com.kruger.ec.repository.admin;

import com.kruger.ec.entity.admin.Aplicacion;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AplicacionRepo extends PagingAndSortingRepository<Aplicacion, Integer> {



}
