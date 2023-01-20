package com.example.pruebaspring.repositorios;

import java.util.List;

import com.example.pruebaspring.entidades.Bicicleta;
import com.example.pruebaspring.entidades.Categoria;
import com.example.pruebaspring.entidades.proyecciones.BicicletaNoCategoria;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BicicletaRepository extends CrudRepository<Bicicleta, Integer> {
    void deleteByCategoria(Categoria categoria); // Borrar por categoría
    // Buscar productos por categoría ordenados por precio ascencente. Forma 1:
    // List<BicicletaNoCategoria> findByCategoriaOrderByPriceAsc(Categoria cat);
    // Buscar productos por categoría ordenados por precio ascencente. Forma 2:
    @Query("SELECT p FROM Bicicleta p WHERE p.categoria.id = :idCat ORDER BY price ASC")
    List<BicicletaNoCategoria> porCategoriaOrderPrecio(@Param("idCat") int idCat);
    BicicletaNoCategoria findBicicletasById(int id);
    List<BicicletaNoCategoria> findBy();
}
