import jpa_exemple.LivrosTr;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class create {
    public static void main(String[] args) {
        EntityManager entityManager = null;

        try {
            //Connect with database
            entityManager = Persistence.createEntityManagerFactory("default").createEntityManager();
            entityManager.getTransaction().begin();

            //Create new OBJ
            LivrosTr livro = new LivrosTr();
            livro.setBookName("Isso é um novo livro");

            //Save OBJ in the database
            entityManager.persist(livro);
            entityManager.getTransaction().commit();

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
