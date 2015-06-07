/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bbu.bibliospring.backend.repo.beans;

import edu.bbu.bibliospring.backend.model.User;
import edu.bbu.bibliospring.backend.repo.UserRepository;
import javax.ejb.Stateless;

/**
 *
 * @author zsvitalyos
 */
@Stateless (name = "UserRepository", mappedName = "ejb/UserReository")
public class UserRepositoryImpl extends BaseRepositoryBean<User, Long > implements UserRepository {
    public UserRepositoryImpl () {
        super(User.class);
    }
    
}
