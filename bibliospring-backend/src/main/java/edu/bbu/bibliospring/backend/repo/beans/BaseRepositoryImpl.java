package edu.bbu.bibliospring.backend.repo.beans;

import edu.bbu.bibliospring.backend.model.AbstractModel;
import edu.bbu.bibliospring.backend.repo.BaseRepository;
import edu.bbu.bibliospring.backend.repo.exception.RepositoryException;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author zsvitalyos
 */
@Stateless
public class BaseRepositoryImpl<T extends AbstractModel, I> implements BaseRepository<T, I> {

    @PersistenceContext(unitName = "VitiUnit")
    private EntityManager entityManager;
    private Class<T> entityClass;

    public BaseRepositoryImpl() {
    }

    public BaseRepositoryImpl(final Class entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public Collection<T> getAllElements() throws RepositoryException {
        try {
            final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            final CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
            final Root<T> rootEntity = criteriaQuery.from(entityClass);
            final CriteriaQuery<T> all = criteriaQuery.select(rootEntity);
            final TypedQuery<T> allQuery = entityManager.createQuery(all);
            return (Collection<T>) allQuery.getResultList();
        } catch (PersistenceException pex) {
            throw new RepositoryException(pex, "Error in getAllElements()");
        }
    }

    @Override
    public T getById(I id) throws RepositoryException {
        try {
            return (T) entityManager.find(entityClass, id);
        } catch (PersistenceException pex) {
            throw new RepositoryException(pex, "Error in getById()");
        }
    }

    @Override
    public void insert(T element) throws RepositoryException {
        try {
            entityManager.persist(element);
            entityManager.flush();
        } catch (PersistenceException pex) {
            throw new RepositoryException(pex, "Error in insert()");
        }
    }

    @Override
    public void update(T element) throws RepositoryException {
        try {
            entityManager.merge(element);
        } catch (PersistenceException pex) {
            throw new RepositoryException(pex, "Error in update()");
        }
    }

    @Override
    public void delete(T element) throws RepositoryException {
        try {
            T e = entityManager.merge(element);
            entityManager.remove(e);
        } catch (PersistenceException pex) {
            throw new RepositoryException(pex, "Error in delete()");
        }
    }

}
