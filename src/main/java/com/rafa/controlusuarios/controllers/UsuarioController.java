package com.rafa.controlusuarios.controllers;

import com.rafa.controlusuarios.dao.UsuarioDao;
import com.rafa.controlusuarios.models.Usuario;
import com.rafa.controlusuarios.utils.JWTUtil;
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

    @Autowired
    private JWTUtil jwtUtil;


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

    //Metodo Validación de utenticación simple
    private boolean validarToken (String token){

        String usuarioID = jwtUtil.getKey(token);
        return usuarioID != null;
    }

    //Metodo para obtener usuarios
    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token){
        if (!validarToken(token)){
            return null;
        }
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
    public void eliminarUsuario(@RequestHeader(value = "Authorization") String token,
                                @PathVariable Long id){
        if (!validarToken(token)){
            return;
        }
        usuarioDao.eliminar(id);
    }
}
