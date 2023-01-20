package com.example.pruebaspring.controladores;

import java.util.List;

import com.example.pruebaspring.entidades.Bicicleta;
import com.example.pruebaspring.entidades.proyecciones.BicicletaNoCategoria;
import com.example.pruebaspring.servicios.BicicletasService;

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
@RequestMapping("/bicicletas")
public class BicicletaController {
    private final BicicletasService biciService;

    public BicicletaController(BicicletasService biciService) {
        this.biciService = biciService;
    }

    @GetMapping
    public List<BicicletaNoCategoria> findBicicletas(@RequestParam(defaultValue = "0") int categoria) {
        if(categoria > 0) {
            return biciService.findByCategoriaOrderByPrice(categoria);
        } else {
            return biciService.findAll();
        }
    }

    @GetMapping("/{id}")
    public BicicletaNoCategoria findById(@PathVariable int id) {
        return biciService.findById(id);
    }

    @PostMapping
    public Bicicleta insertBicicleta(@RequestBody Bicicleta bicicleta) {
        return biciService.insertBicicleta(bicicleta);
        
    }

    @PutMapping("/{id}")
    public Bicicleta update(@PathVariable int id, @RequestBody Bicicleta bicicleta) {
        var biciInsertada =  biciService.update(id, bicicleta);
        biciInsertada.setCategoria(null);
        return biciInsertada;
    }

    @DeleteMapping("/{id}")
    public void deleteBicicleta(@PathVariable int id) {
        biciService.deleteBicicleta(id);
    }
}
