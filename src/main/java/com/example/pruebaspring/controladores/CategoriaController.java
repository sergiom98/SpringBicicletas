package com.example.pruebaspring.controladores;

import java.util.List;

import com.example.pruebaspring.entidades.Categoria;
import com.example.pruebaspring.entidades.proyecciones.CategoriaNoBicicletas;
import com.example.pruebaspring.entidades.proyecciones.CategoriaWithBicicletas;
import com.example.pruebaspring.servicios.CategoriaService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService catService;

    public CategoriaController(CategoriaService catService) {
        this.catService = catService;
    }

    @GetMapping
    public List<CategoriaNoBicicletas> findAll(@RequestParam(required = false) String name) {
        if(name == null) {
            return catService.findAll();
        } else {
            return catService.findByName(name);
        }
    }

    @GetMapping("/{id}")
    public CategoriaWithBicicletas findById(@PathVariable int id) {
        return catService.findById(id);
    }

    @PostMapping
    public Categoria insert(@RequestBody Categoria categoria) {
        return catService.insert(categoria);
    }

    @PutMapping("/{id}")
    public Categoria update(@PathVariable int id, @RequestBody Categoria categoria) {
        return catService.update(id, categoria);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        catService.delete(id);
    }
}


