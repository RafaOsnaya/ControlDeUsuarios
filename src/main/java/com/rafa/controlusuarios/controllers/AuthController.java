package com.rafa.controlusuarios.controllers;

import com.rafa.controlusuarios.models.Usuario;
import com.rafa.controlusuarios.dao.UsuarioDao;
import com.rafa.controlusuarios.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;//Inyectamos el toquen

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){

        Usuario usuarioLogueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);

        if (usuarioLogueado != null){

            String tokenJWT = jwtUtil.create(String.valueOf(usuarioLogueado.getId()),
                    usuarioLogueado.getEmail());

            return tokenJWT;
        }
        return "FAIL";
    }


}
