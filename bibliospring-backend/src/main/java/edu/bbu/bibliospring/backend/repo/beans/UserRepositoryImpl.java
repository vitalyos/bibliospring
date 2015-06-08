package edu.bbu.bibliospring.backend.repo.beans;

import edu.bbu.bibliospring.backend.model.User;
import edu.bbu.bibliospring.backend.repo.UserRepository;
import javax.ejb.Stateless;

/**
 *
 * @author zsvitalyos
 */
@Stateless (name = "UserRepository", mappedName = "ejb/UserRepository")
public class UserRepositoryImpl extends BaseRepositoryImpl<User, Long > implements UserRepository {
    public UserRepositoryImpl () {
        super(User.class);
    }
    
}
