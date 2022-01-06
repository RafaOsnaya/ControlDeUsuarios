package com.rafa.controlusuarios.dao;

import com.rafa.controlusuarios.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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

    @Override
    public void eliminar(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public boolean verificarCredenciales(Usuario usuario){
        //Consulta con hibernate
        String query = "FROM Usuario WHERE email = :email ";  //Comparación con db
        List<Usuario> lista = entityManager.createQuery(query)
                  .setParameter("email", usuario.getEmail())
                  .getResultList(); //Realiza la consulta y obtiene el resultado

        if (lista.isEmpty()){
            return false;
        }

        //Otenemos el elemento y la contraseña del objeto registrado
        String passwordHashed = lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        //Comparamos la contraseña de la cifrada en la base
        // de datos con la proporcionada por el usuario en el login
        return argon2.verify(passwordHashed, usuario.getPassword());//Devuelve booleano

    }


}
