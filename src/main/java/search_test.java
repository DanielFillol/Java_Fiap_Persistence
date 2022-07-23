import jpa_exemple.LivrosTr;
import jpa_exemple.TipoLiro;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class search_test {
    public static void main(String[] args) {
        EntityManager em = null;

        try {
            em = Persistence.createEntityManagerFactory("default").createEntityManager();
            em.getTransaction().begin();

            //Search one
            LivrosTr livro = em.find(LivrosTr.class, 1);
            System.out.println(livro);

            //Search many
            TipoLiro tipoLivro = em.find(TipoLiro.class, 1);
            System.out.println(tipoLivro.getLivros());

        }catch (Exception e){
            // IF error discard changes
            if (em != null && em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        } finally {
            // Close connection
            if (em != null){
                em.close();
            }
        }
    }
}
