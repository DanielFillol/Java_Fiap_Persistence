package generic_dao;

import jpa_exemple.TipoLiro;

import javax.persistence.EntityManager;

public class TipoLivroDAO extends GenericDAO<TipoLiro, Integer>{
    public TipoLivroDAO(EntityManager em){
        super(em);
    }
}
