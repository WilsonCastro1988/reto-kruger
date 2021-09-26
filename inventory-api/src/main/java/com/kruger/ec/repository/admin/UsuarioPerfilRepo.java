package com.kruger.ec.repository.admin;

import java.util.List;

import com.kruger.ec.entity.admin.Perfil;
import com.kruger.ec.entity.admin.UsuarioPerfil;
import com.kruger.ec.entity.admin.UsuarioPerfilPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioPerfilRepo extends PagingAndSortingRepository<UsuarioPerfil, UsuarioPerfilPK> {

	@Query("select p from Perfil p where p.idPerfil in (select u.perfil.idPerfil from UsuarioPerfil u where u.usuario.nombreUsuario=?1)")
	public List<Perfil> obtenerPorUsername(@Param("username") String username);

}
