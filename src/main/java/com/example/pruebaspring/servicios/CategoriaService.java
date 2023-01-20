package com.example.pruebaspring.servicios;

import java.util.List;

import javax.transaction.Transactional;

import com.example.pruebaspring.entidades.Categoria;
import com.example.pruebaspring.entidades.proyecciones.CategoriaNoBicicletas;
import com.example.pruebaspring.entidades.proyecciones.CategoriaWithBicicletas;
import com.example.pruebaspring.repositorios.BicicletaRepository;
import com.example.pruebaspring.repositorios.CategoriaRepository;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoriaService {
    private final CategoriaRepository catRepository;
    private final BicicletaRepository biciRepository;

    public CategoriaService(CategoriaRepository catRepository, BicicletaRepository biciRepository) {
        this.catRepository = catRepository;
        this.biciRepository = biciRepository;
    }

    public List<CategoriaNoBicicletas> findAll() { // Busca todas las categorías
        return catRepository.findBy();
    }

    public CategoriaWithBicicletas findById(int id) {
        return catRepository.findWithBicicletasById(id);
    }

    public List<CategoriaNoBicicletas> findByName(String name) {
        return catRepository.findByNameLikeIgnoreCase("%" + name + "%");
    }

    public Categoria insert(Categoria categoria) {
        return catRepository.save(categoria);
    }

    public Categoria update(int id, Categoria categoria) {
        categoria.setId(id);
        return catRepository.save(categoria);
    }

    public void delete(int id) {
        Categoria cat = catRepository.findById(id).orElse(null);
        if(cat != null) {
            biciRepository.deleteByCategoria(cat);
            catRepository.delete(cat);
        }
    }
}
