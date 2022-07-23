package jpql;

import jpa_exemple.TipoLiro;

import javax.persistence.EntityManager;
import java.util.List;

public class TipoLivroDAOjpqpl extends GenericDAOjpql<TipoLiro, Integer> {
    public TipoLivroDAOjpqpl(EntityManager em){
        super(em);
    }

    //TipoLiro is not the name of the table but rather the name of the class that maps the database table
    @Override
    public List<TipoLiro> listAll(){
        return this.em.createQuery("from TipoLiro").getResultList();
    }

    //Again you do not need to know the colum name, just the attribute
    public List<TipoLiro> listAllOrderByNameNames(){
        return this.em.createQuery("from TipoLiro order by tipoLivro").getResultList();
    }

    public List<TipoLiro> listLast3(){
        return  this.em.createQuery("from TipoLiro order by id desc").setMaxResults(3).getResultList();
    }

    public List<TipoLiro> pageList(int itensPerPage, int page){
        int first = (page - 1) * itensPerPage;
        return this.em.createQuery("from TipoLiro order by tipoLivro").setMaxResults(itensPerPage).setFirstResult(first).getResultList();
    }

    public int alterAll(TipoLiro livro){
       return this.em.createQuery("update LivrosTr l set l.livroTipo = :livro").setParameter("livro", livro).executeUpdate();
    }

}
