package generic_dao;

import jpa_exemple.TipoLiro;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class create {
    public static void main(String[] args) {
        EntityManager em = null;

        try {
            em  = Persistence.createEntityManagerFactory("default").createEntityManager();

            //Connect to database and create objc DAO
            TipoLivroDAO dao = new TipoLivroDAO(em);
            em.getTransaction().begin();

            //Create new book type
            TipoLiro newType = new TipoLiro();
            newType.setTipoLivro("TCC");

            //Using DAO  to save the new type
            dao.save(newType);

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
