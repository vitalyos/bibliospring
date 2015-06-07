package edu.bbu.bibliospring.backend.service;

import edu.bbu.bibliospring.backend.model.User;
import edu.bbu.bibliospring.backend.service.exception.ServiceException;
import java.util.Collection;
import javax.ejb.Remote;

/**
 *
 * @author zsvitalyos
 */
@Remote
public interface UserService {
    Collection<User> getAllUsers () throws ServiceException;
    User getUserById (Long id) throws ServiceException;
    void insertUser (final User user) throws ServiceException;
    void updateUser (final User user) throws ServiceException;
    void deleteUser (final User user) throws ServiceException;
}
