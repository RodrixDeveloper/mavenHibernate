package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.entidades.onetoone.Carnet;
import com.springsimplespasos.hibernate.entidades.onetoone.Socio;
import com.springsimplespasos.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class MainOneToOne {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSeccionSessionFactory().openSession();
        Socio socio = new Socio();
        socio.setNombre("Roberto");
        socio.setDocumento("6666");

        Carnet carnet = new Carnet();
        carnet.setNumero("135");

        socio.setCarnet(carnet);

        session.beginTransaction();
        session.save(socio);
        session.getTransaction().commit();

        session.close();
    }
}
