package es.davidrico.jakarta.jpahibernate.relaciones;

import jakarta.persistence.EntityManager;
import es.davidrico.jakarta.jpahibernate.relaciones.entity.Cliente;
import es.davidrico.jakarta.jpahibernate.relaciones.entity.ClienteDetalle;
import es.davidrico.jakarta.jpahibernate.relaciones.util.JpaUtil;

public class HibernateAsociacionesOneToOneBidireccional {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Cliente cliente = new Cliente("Cata", "Edu");
            cliente.setFormaPago("paypal");

            ClienteDetalle detalle = new ClienteDetalle(true, 8000L);

            cliente.addDetalle(detalle);

            em.persist(cliente);
            em.getTransaction().commit();

            System.out.println(cliente);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }
}
