package com.example.pruebaspring.controladores;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import com.example.pruebaspring.controladores.respuestas.UsuariosRespuesta;
import com.example.pruebaspring.entidades.Usuario;
import com.example.pruebaspring.servicios.UsuariosService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    private final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping
    public UsuariosRespuesta getAll() {
        return new UsuariosRespuesta(usuariosService.getAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario insert(@RequestBody @Valid Usuario usuario) throws NoSuchAlgorithmException {
        return usuariosService.insert(usuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        usuariosService.delete(id);
    }
}
