package com.kruger.ec.repository.admin;

import com.kruger.ec.entity.admin.Autorizacion;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AutorizacionRepo extends PagingAndSortingRepository<Autorizacion, Integer> {

}
