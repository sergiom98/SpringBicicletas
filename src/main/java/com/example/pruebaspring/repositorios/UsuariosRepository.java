package com.example.pruebaspring.repositorios;

import java.util.List;

import com.example.pruebaspring.entidades.Usuario;
import com.example.pruebaspring.entidades.proyecciones.UsuarioSinPassword;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends CrudRepository<Usuario, Integer> {
    List<UsuarioSinPassword> findBy();
    Usuario findFirstByCorreoAndPassword(String correo, String password);
}
