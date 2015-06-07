
package edu.bbu.bibliospring.backend.repo.beans;

import edu.bbu.bibliospring.backend.model.AbstractModel;
import edu.bbu.bibliospring.backend.repo.BaseRepository;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author zsvitalyos
 */
@Stateless
public class BaseRepositoryBean<T,I> implements BaseRepository<AbstractModel, I>{
    @PersistenceContext
    private EntityManager entitiManager;
    private Class entityClass;

    public BaseRepositoryBean() {
    }

    public BaseRepositoryBean(Class entityClass) {
        this.entityClass = entityClass;
    }
    
    
    public Collection<AbstractModel> getAllElements() {
        return null;
    }

    public AbstractModel getById(I id) {
        return (AbstractModel) entitiManager.find(entityClass, id);
    }

    public void insert(AbstractModel element) {
        entitiManager.persist(element);
    }

    public void update(AbstractModel element) {
        entitiManager.merge(element);
    }

    public void delete(AbstractModel element) {
        entitiManager.remove(element);
    }
    
}
