package generic_dao;

import jpa_exemple.TipoLiro;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class read {
    public static void main(String[] args) {
        EntityManager em = null;

        try {
            em  = Persistence.createEntityManagerFactory("default").createEntityManager();

            //Connect to database and create objc DAO
            TipoLivroDAO dao = new TipoLivroDAO(em);
            em.getTransaction().begin();

            //Retrieve method
            TipoLiro retrieve = dao.retrieve(3);

            //Print
            System.out.println(retrieve);

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
