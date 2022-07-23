package generic_dao;

import jpa_exemple.TipoLiro;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class readAll {
    public static void main(String[] args) {
        EntityManager em = null;

        try {
            em  = Persistence.createEntityManagerFactory("default").createEntityManager();

            //Connect to database and create objc DAO
            TipoLivroDAO dao = new TipoLivroDAO(em);
            em.getTransaction().begin();

            //List All
            System.out.println("\n\nTipos de Livros");
            for (TipoLiro entity:dao.listAll()){
               System.out.println(entity);
            }

            //Persisting on Database
            em.getTransaction().commit();

        }catch (Exception e){
            if (em != null && em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }

        if (em != null){
            em.close();
        }

        System.exit(0);
    }
}
