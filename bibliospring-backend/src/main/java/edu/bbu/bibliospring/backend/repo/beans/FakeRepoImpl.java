package edu.bbu.bibliospring.backend.repo.beans;

import edu.bbu.bibliospring.backend.repo.FakeRepoInterface;
import javax.ejb.Stateless;

/**
 *
 * @author zsvitalyos
 */
@Stateless
public class FakeRepoImpl implements FakeRepoInterface {

    public void doSomething() {
        System.out.println("Hello! I am fake repo :P...");
    }
    
    
}
