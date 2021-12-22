package com.rafa.controlusuarios.controllers;

import com.rafa.controlusuarios.models.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(){

        Usuario usuario = new Usuario();

        usuario.setNombre("Rafael");
        usuario.setApPaterno("Osnaya");
        usuario.setApMaterno("de Lucio");
        usuario.setEmail("osnayadeluciorafael@hotmail.com");
        usuario.setTelefono("55 6018-1856");

        return usuario;
    }

}
