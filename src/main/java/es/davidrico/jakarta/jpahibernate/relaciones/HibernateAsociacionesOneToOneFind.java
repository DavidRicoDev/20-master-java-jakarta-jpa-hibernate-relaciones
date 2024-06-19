package es.davidrico.jakarta.jpahibernate.relaciones;

import jakarta.persistence.EntityManager;
import es.davidrico.jakarta.jpahibernate.relaciones.entity.Cliente;
import es.davidrico.jakarta.jpahibernate.relaciones.entity.ClienteDetalle;
import es.davidrico.jakarta.jpahibernate.relaciones.util.JpaUtil;

public class HibernateAsociacionesOneToOneFind {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Cliente cliente = em.find(Cliente.class, 2L);

            ClienteDetalle detalle = new ClienteDetalle(true, 5000L);
            em.persist(detalle);

            cliente.setDetalle(detalle);
            em.getTransaction().commit();
            System.out.println(cliente);

        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
