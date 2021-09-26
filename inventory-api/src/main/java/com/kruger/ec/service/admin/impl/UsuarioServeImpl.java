package com.kruger.ec.service.admin.impl;

import java.util.List;
import java.util.Optional;

import com.kruger.ec.repository.admin.UsuarioRepo;
import com.kruger.ec.dto.admin.UsuarioDto;
import com.kruger.ec.entity.admin.Usuario;
import com.kruger.ec.mapper.admin.UsuarioMapper;
import com.kruger.ec.service.admin.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UsuarioServeImpl implements UsuarioService {

    @Autowired
    private UsuarioRepo repo;
    @Autowired
    private UsuarioMapper mapper;

    @Override
    public UsuarioDto create(UsuarioDto obj) {
        Usuario entity = mapper.toEntity(obj);
        return mapper.toDto(repo.save(entity));
    }

    @Override
    public List<UsuarioDto> findAll() {
        List<Usuario> listEntitie = (List<Usuario>) repo.findAll();
        List<UsuarioDto> listDto = mapper.toDto(listEntitie);
        return listDto;
    }

    @Override
    public UsuarioDto findById(String id) {
        Optional<Usuario> obj = repo.findById(id);
        return obj.isPresent() ? mapper.toDto(obj.get()) : new UsuarioDto();
    }

    @Override
    public UsuarioDto update(UsuarioDto obj) {
        try {

            Usuario data = mapper.toEntity(obj);
            UsuarioDto dto = mapper.toDto(repo.save(data));
            /*
            AplicacionDto data = findById(obj.getIdAplicacion());
            Aplicacion entity = mapper.toEntity(obj);
            BeanUtils.copyProperties(data, entity);
            return create(mapper.toDto(entity));
             */
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
            return new UsuarioDto();
        }
    }

    @Override
    public boolean delete(String id) {
        repo.deleteById(id);
        if (repo.findById(id) != null)
            return false;
        else
            return true;
    }

    @Override
    public UsuarioDto findByNombreUsuario(String username) {
        Usuario obj = repo.findByNombreUsuario(username);
        return mapper.toDto(obj);
    }

    @Override
    public Optional<UsuarioDto> getByEmail(String email) {
        Optional<Usuario> obj = repo.findByEmail(email);
        return obj.isPresent() ? Optional.of(mapper.toDto(obj.get())) : Optional.of(new UsuarioDto());

    }

    @Override
    public boolean existsEmail(String email) {
        boolean obj = repo.existsByEmail(email);
        return obj;
    }

}
