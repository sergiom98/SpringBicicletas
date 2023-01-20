package com.example.pruebaspring.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "El correo no tiene un formato válido")
    private String correo;
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 4, message = "La contraseña debe tener al menos 4 caracteres")
    private String password;

    // public void addUsuario(Usuario u) {
    //     asistentes.add(u);
    //     u.eventos.add(this);
    // }

    // public void removeUsuario(Usuario usuario) {
    //     asistentes.remove(usuario);
    //     usuario.eventos.remove(this);
    // }

    // @ManyToMany
    // @JoinTable(name = "usuario_asiste_evento", 
    // joinColumns = @JoinColumn(name = "usuario"),
    // inverseJoinColumns = @JoinColumn(name = "evento"))
    // List<Evento> eventos;
}

