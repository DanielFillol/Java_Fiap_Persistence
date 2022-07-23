package generic_dao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericDAO<E,C> {
    protected Class<E> classEntity;
    protected EntityManager em;

    public GenericDAO(EntityManager em){
        this.em = em;
        this.classEntity = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void save(E entity) {
        this.em.persist(entity);
    }

    public E retrieve(C key){
        return em.find(classEntity, key);
    }

    public void delete(C key){
        E entityDelete = this.retrieve(key);

        if (entityDelete == null){
            throw new IllegalArgumentException("No record of: " + this.classEntity.getSimpleName() + " found with key: " + key);
        }

        this.em.remove(entityDelete);
    }

    public List<E> listAll(){
        CriteriaQuery<E> query = this.em.getCriteriaBuilder().createQuery(this.classEntity);
        return  this.em.createQuery(query.select(query.from(this.classEntity))).getResultList();
    }



}
