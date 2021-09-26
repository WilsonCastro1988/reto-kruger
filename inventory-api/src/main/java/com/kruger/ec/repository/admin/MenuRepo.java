package com.kruger.ec.repository.admin;

import com.kruger.ec.entity.admin.Menu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MenuRepo extends PagingAndSortingRepository<Menu, Integer> {

    /*
    select * from MENU where ID_MENU in (select ID_MENU from AUTORIZACION where id_perfil in (select id_perfil from USUARIO_PERFIL where nombre_usuario = 'wilson.castro@uisek.edu.ec'))
        and ID_APLICACIONES  = 1
     */
    @Query("select m from Menu m where m.idMenu in " +
            "(select a.idMenu from Autorizacion a where a.idPerfil " +
            "in (select up.perfil.idPerfil from UsuarioPerfil  up where up.usuario.nombreUsuario = :username)) order by m.ordenMenu")
    List<Menu> findByUsername(@Param("username") String username);

    @Query("select m from Menu m where m.tipoMenu = 'menu' and m.idMenu in " +
            "(select a.idMenu from Autorizacion a where a.idPerfil " +
            "in (select up.perfil.idPerfil from UsuarioPerfil  up where up.usuario.nombreUsuario = :username)) order by m.ordenMenu")
    List<Menu> findPadreByUsername(@Param("username") String username);

    @Query("select m from Menu m where m.tipoMenu = 'opcion' and m.idMenuPadre =:menuPadre and m.idMenu in " +
            "(select a.idMenu from Autorizacion a where a.idPerfil " +
            "in (select up.perfil.idPerfil from UsuarioPerfil  up where up.usuario.nombreUsuario = :username)) order by m.ordenMenu")
    List<Menu> findHijoByMenuPadreAndUsername(@Param("menuPadre") Integer menuPadre, @Param("username") String username);



}
