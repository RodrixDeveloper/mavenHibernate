package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.entidades.manyToOne.Persona;
import com.springsimplespasos.hibernate.entidades.manyToOne.Telefono;
import com.springsimplespasos.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Arrays;

public class MainManyToOne {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSeccionSessionFactory().openSession();

        Persona juan = new Persona(1,"Juan");
        Persona mariano = new Persona(2,"mariano");

        Telefono celularJuan = new Telefono(null,"111111111");
        Telefono lineaJuan = new Telefono(null,"22222222");

        celularJuan.setPersona(juan);
        lineaJuan.setPersona(juan);

        juan.setTelefonos(Arrays.asList(celularJuan,lineaJuan));

        session.beginTransaction();

/*        session.saveOrUpdate(juan);
        session.saveOrUpdate(mariano);*/

        Persona persona = session.get(Persona.class,1);
        persona.getTelefonos().forEach(t-> System.out.println(t.getNombre()));

        session.getTransaction().commit();

        session.close();
    }
}
