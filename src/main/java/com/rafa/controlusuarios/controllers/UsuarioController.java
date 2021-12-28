package com.rafa.controlusuarios.controllers;

import com.rafa.controlusuarios.dao.UsuarioDao;
import com.rafa.controlusuarios.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired //Inyectamos
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){

        Usuario usuario = new Usuario();

        usuario.setId(id);
        usuario.setNombre("Rafael");
        usuario.setApPaterno("Osnaya");
        usuario.setApMaterno("de Lucio");
        usuario.setEmail("osnayadeluciorafael@hotmail.com");
        usuario.setTelefono("55 6018-1856");

        return usuario;
    }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }

}
