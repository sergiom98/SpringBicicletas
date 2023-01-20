package com.example.pruebaspring.repositorios;

import java.util.List;

import com.example.pruebaspring.entidades.Categoria;
import com.example.pruebaspring.entidades.proyecciones.CategoriaNoBicicletas;
import com.example.pruebaspring.entidades.proyecciones.CategoriaWithBicicletas;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
    List<CategoriaNoBicicletas> findBy();
    CategoriaWithBicicletas findWithBicicletasById(int id);
    List<CategoriaNoBicicletas> findByNameLikeIgnoreCase(String name);
}
