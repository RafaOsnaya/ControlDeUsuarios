package com.rafa.controlusuarios.controllers;

import com.rafa.controlusuarios.dao.UsuarioDao;
import com.rafa.controlusuarios.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired //Inyectamos
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuarios/{id}")
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

    //Metodo para obtener usuarios
    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }


    //Metodo para registrar usuario
    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){//Convierte JSON a tipo Usuario

        //Procedimiento para cifrado de password
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1, usuario.getPassword());
        usuario.setPassword(hash);

        usuarioDao.registrar(usuario);
    }


    //Metdo para eliminar usuario
    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminarUsuario(@PathVariable Long id){
        usuarioDao.eliminar(id);
    }


}
