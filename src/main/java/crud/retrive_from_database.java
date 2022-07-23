package crud;

import jpa_exemple.LivrosTr;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class retrive_from_database {
    public static void main(String[] args) {
        EntityManager entityManager = null;

        try {
            //Connect with database
            entityManager = Persistence.createEntityManagerFactory("default").createEntityManager();
            entityManager.getTransaction().begin();

            //Find object on database
            LivrosTr recoverd = entityManager.find(LivrosTr.class, 900);

            //Print using toString() function
            System.out.println(recoverd);

        }catch (Exception e){
            // IF error discard changes
            if (entityManager != null && entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
        } finally {
            // Close connection
            if (entityManager != null){
                entityManager.close();
            }
        }

        System.exit(0);
    }
}
