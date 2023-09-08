package employeejpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Employee;

/**
 *
 * @author pinpin
 */
public class EmployeeJPA {

    public static void main(String[] args) {
        Employee emp = new Employee(1, "Settha", 67890.89);
        persist(emp);
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
