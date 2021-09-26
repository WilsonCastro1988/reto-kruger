package com.kruger.ec.service.core.service;

import com.kruger.ec.dto.admin.UsuarioDto;
import com.kruger.ec.dto.core.KgrtEmployeeDto;
import com.kruger.ec.entity.core.KgrtEmployee;
import com.kruger.ec.service.GenericService;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface KgrtEmployeeService extends GenericService<KgrtEmployeeDto, String> {

    Optional<KgrtEmployeeDto> findByFlagemployeevUser(UsuarioDto flagemployeevUser);
}
