package edu.bbu.bibliospring.backend.repo;

import edu.bbu.bibliospring.backend.model.AbstractModel;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author zsvitalyos
 * @param <T>
 */
@Local
public interface BaseRepository<T extends AbstractModel, I> {
    Collection<T> getAllElements ();
    T getById (I id);
    void insert (T element);
    void update (T element);
    void delete (T element);
}
