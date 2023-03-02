package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.entidades.manytomany.Publicacion;
import com.springsimplespasos.hibernate.entidades.manytomany.Usuario;
import com.springsimplespasos.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Arrays;

public class MainManyToMany {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSeccionSessionFactory().openSession();

        Usuario admin = new Usuario(1,"admin");
        Usuario user = new Usuario(2,"usuario");

        Publicacion publicacionUno = new Publicacion(1, "Texto de la publicaciones uno");
        Publicacion publicacionDos = new Publicacion(2, "Texto de la publicaciones dos");
        Publicacion publicacionTres = new Publicacion(3, "Texto de la publicaciones tres");
        Publicacion publicacionCuatro = new Publicacion(4, "Texto de la publicaciones cuatrp");

        admin.setPublicaciones(Arrays.asList(publicacionUno, publicacionDos));
        user.setPublicaciones(Arrays.asList(publicacionTres, publicacionCuatro,publicacionDos));

        session.beginTransaction();

    /*    session.saveOrUpdate(admin);
        session.saveOrUpdate(user);
        session.saveOrUpdate(publicacionUno);
        session.saveOrUpdate(publicacionDos);
        session.saveOrUpdate(publicacionTres);
        session.saveOrUpdate(publicacionCuatro);*/

        Usuario usuario = session.get(Usuario.class,1);
        usuario.getPublicaciones().forEach(publicacion -> System.out.println(publicacion.getTexto()));
        session.getTransaction().commit();

        session.close();

    }
}
