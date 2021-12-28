package com.rafa.controlusuarios.dao;

import com.rafa.controlusuarios.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    EntityManager entityManager;//Sirve para hacer la conexion a la base de datos

    @Override
    public List<Usuario> getUsuarios() {
        //Consulta con hibernate
        String query = "FROM Usuario";  //Se pone el nombre de la clase no el de la tabla
        return entityManager.createQuery(query).getResultList(); //Realiza la consulta y obtiene el resultado
    }
}
