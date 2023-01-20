package com.example.pruebaspring.servicios;

import java.util.List;

import com.example.pruebaspring.entidades.Bicicleta;
import com.example.pruebaspring.entidades.proyecciones.BicicletaNoCategoria;
import com.example.pruebaspring.repositorios.BicicletaRepository;

import org.springframework.stereotype.Service;

@Service
public class BicicletasService {
    private BicicletaRepository biciRepo;

    public BicicletasService(BicicletaRepository biciRepo) {
        this.biciRepo = biciRepo;
    }

    public List<BicicletaNoCategoria> findAll() {
        return biciRepo.findBy();
    }

    public List<BicicletaNoCategoria> findByCategoriaOrderByPrice(int idCat) {
        return biciRepo.porCategoriaOrderPrecio(idCat);
    }

    public Bicicleta insertBicicleta(Bicicleta bicicleta) {
        return biciRepo.save(bicicleta);
    }
    
    public void deleteBicicleta(int id) {
        biciRepo.deleteById(id);
    }

    public BicicletaNoCategoria findById(int id) {
        return biciRepo.findBicicletasById(id);
    }

    public Bicicleta update(int id, Bicicleta bicicleta) {
        bicicleta.setId(id);
        return biciRepo.save(bicicleta);
    }
}
