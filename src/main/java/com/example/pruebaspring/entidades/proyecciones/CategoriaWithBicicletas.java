package com.example.pruebaspring.entidades.proyecciones;

import java.util.List;

public interface CategoriaWithBicicletas {
    int getId();
    String getName();
    List<BicicletaNoCategoria> getBicicletas();
}
