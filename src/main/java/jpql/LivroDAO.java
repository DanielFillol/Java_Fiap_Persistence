package jpql;

import generic_dao.GenericDAO;
import jpa_exemple.LivrosTr;

import javax.persistence.EntityManager;
import java.util.List;

public class LivroDAO extends GenericDAO<LivrosTr, Integer> {
    public LivroDAO(EntityManager em){
        super(em);
    }

    public List<LivrosTr> listAllPerName(String name){
        return this.em.createQuery("select e from LivrosTr l where l.bookName =: name").setParameter("name", name).getResultList();
    }

    public LivrosTr searchByName(String name){
        return (LivrosTr) this.em.createQuery("select e from LivrosTr l where l.bookName =: name").setParameter("name", name).getSingleResult();
    }
}

