package com.example.pruebaspring.entidades;

// import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Bicicleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "El nombre es obligatorio")
    private String name;
    private String image;
    private String image2;
    private String image3;
    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 8, max = 2000, message = "La descripción tiene que tener al menos 8 caracteres")
    private String description;
    @Positive(message = "El precio debe ser mayor que 0")
    private double price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria")
    // private List<Categoria> categoria;
    private Categoria categoria;
}
