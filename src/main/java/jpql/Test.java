package jpql;

import generic_dao.TipoLivroDAO;
import jpa_exemple.TipoLiro;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Test {
    public static void main(String[] args) {
        EntityManager em = null;

        try {
            em  = Persistence.createEntityManagerFactory("default").createEntityManager();

            //Connect to database and create objc DAO
            TipoLivroDAOjpqpl dao = new TipoLivroDAOjpqpl(em);
            em.getTransaction().begin();

            //Create new book type
            TipoLiro newType = new TipoLiro();
            newType.setTipoLivro("1");


            //Using DAO  to save the new type
            dao.alterAll(newType);

            //Persisting on database
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
