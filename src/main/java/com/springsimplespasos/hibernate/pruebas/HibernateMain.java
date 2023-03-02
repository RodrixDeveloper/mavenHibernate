package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.entidades.SimpleEntity;
import com.springsimplespasos.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class HibernateMain {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSeccionSessionFactory().openSession();
        session.beginTransaction();

        //Bloque insert
   /*     SimpleEntity entity = new SimpleEntity();
        entity.setNombre("rodrigo");
        session.save(entity);*/

        //Bloque update
      /*  SimpleEntity entityUpdate = new SimpleEntity();
        entityUpdate.setCodigo(2);
        entityUpdate.setNombre("VIVIANA");
        session.update(entityUpdate);*/

        //Bloque delete
/*        SimpleEntity entityDelete = new SimpleEntity();
        entityDelete.setCodigo(1);
        session.delete(entityDelete);*/

        /*SimpleEntity entityRead = session.get(SimpleEntity.class,2);
        System.out.println(entityRead.getNombre());*/


        SimpleEntity entity = new SimpleEntity();
        entity.setNombre("rodrigo");

        SimpleEntity entityUpdate = new SimpleEntity();
        entityUpdate.setCodigo(2);
        entityUpdate.setNombre("VIVIANA 2");


        session.saveOrUpdate(entity);
        session.saveOrUpdate(entityUpdate);

        session.getTransaction().commit();
        session.close();
    }
}
