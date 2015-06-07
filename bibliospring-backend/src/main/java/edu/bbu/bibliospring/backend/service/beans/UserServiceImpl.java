package edu.bbu.bibliospring.backend.service.beans;

import edu.bbu.bibliospring.backend.model.User;
import edu.bbu.bibliospring.backend.repo.UserRepository;
import edu.bbu.bibliospring.backend.repo.exception.RepositoryException;
import edu.bbu.bibliospring.backend.service.UserService;
import edu.bbu.bibliospring.backend.service.exception.ServiceException;
import java.util.Collection;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author zsvitalyos
 */
@Stateless(name = "UserService", mappedName = "ejb/UserService")
@DependsOn({"UserRepository", "User"})
public class UserServiceImpl implements UserService {

    @EJB
    private UserRepository userRepository;
    
    @Override
    public Collection<User> getAllUsers() throws ServiceException {
        try {
            return userRepository.getAllElements();
        } catch (final RepositoryException rex) {
            throw new ServiceException("Error: getAllUsers()", rex);
        }
    }
    
    @Override
    public User getUserById(Long id) throws ServiceException {
        try {
            return userRepository.getById(id);
        } catch (final RepositoryException rex) {
            throw new ServiceException("Error: getUserById()", rex);
        }
        
    }
    
    @Override
    public void insertUser(User user) throws ServiceException {
        try {
            userRepository.insert(user);
        } catch (final RepositoryException rex) {
            throw new ServiceException("Error: insertUser()", rex);
        }
    }
    
    @Override
    public void updateUser(User user) throws ServiceException {
        try {
            userRepository.update(user);
        } catch (final RepositoryException rex) {
            throw new ServiceException("Error: updateUser()", rex);
        }
    }
    
    @Override
    public void deleteUser(User user) throws ServiceException {
        try {
            userRepository.delete(user);
        } catch (final RepositoryException rex) {
            throw new ServiceException("Error: deleteUser()", rex);
        }
    }
    
}
