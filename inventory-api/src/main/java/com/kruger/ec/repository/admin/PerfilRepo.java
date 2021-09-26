package com.kruger.ec.repository.admin;

import java.util.Optional;

import com.kruger.ec.entity.admin.Perfil;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepo extends PagingAndSortingRepository<Perfil, Integer> {

	Optional<Perfil> findByNombrePerfil(String nombrePerfil);

	boolean existsByNombrePerfil(String nombrePerfil);

}
