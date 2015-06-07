package edu.bbu.bibliospring.backend.repo;

import edu.bbu.bibliospring.backend.model.AbstractModel;
import edu.bbu.bibliospring.backend.repo.exception.RepositoryException;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author zsvitalyos
 *
 */
@Local
public interface BaseRepository<T extends AbstractModel, I> {
    Collection<T> getAllElements () throws RepositoryException;
    T getById (I id) throws RepositoryException;
    void insert (T element) throws RepositoryException;
    void update (T element) throws RepositoryException;
    void delete (T element) throws RepositoryException;
}
