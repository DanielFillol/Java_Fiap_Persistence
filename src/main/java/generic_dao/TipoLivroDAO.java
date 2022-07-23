package generic_dao;

import jpa_exemple.TipoLiro;
import jpql.GenericDAOjpql;

import javax.persistence.EntityManager;

public class TipoLivroDAO extends GenericDAOjpql<TipoLiro, Integer> {
    public TipoLivroDAO(EntityManager em){
        super(em);
    }
}
