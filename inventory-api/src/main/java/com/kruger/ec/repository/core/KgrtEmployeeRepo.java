package com.kruger.ec.repository.core;


import com.kruger.ec.entity.admin.Usuario;
import com.kruger.ec.entity.core.KgrtEmployee;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KgrtEmployeeRepo extends PagingAndSortingRepository<KgrtEmployee, String> {


    Optional<KgrtEmployee> findByFlagemployeevUser(@Param(value = "flagemployeevUser") String flagemployeevUser);


}
