package com.example.pruebaspring.controladores.respuestas;

import java.util.List;

import com.example.pruebaspring.entidades.proyecciones.UsuarioSinPassword;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class UsuariosRespuesta {
    private List<UsuarioSinPassword> usuarios;
}
