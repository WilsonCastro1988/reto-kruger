package com.kruger.ec.repository.admin;



import com.kruger.ec.entity.admin.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

//@RepositoryRestResource(path = "usuarios")
@Repository
public interface UsuarioRepo extends PagingAndSortingRepository<Usuario, String> {

	// ruta para usar los metodos
	// http://localhost:8090/api/usuarios/usuarios/search/findByUsername?username=wilson
	//@RestResource(path = "buscar-username") // para personalizar la ruta de consumo del api rest
	//@Query("select u from Usuario u where u.nombreUsuario=:username")
	public Usuario findByNombreUsuario(String username);

	//@RestResource(path = "obtener-username")
	//@Query("select u from Usuario u where u.nombreUsuario=?1")
	//public Usuario obtenerPorUsername(@Param("username") String username);

	public Optional<Usuario> findByEmail(String email);
	
	 public boolean existsByEmail(String email);



}
