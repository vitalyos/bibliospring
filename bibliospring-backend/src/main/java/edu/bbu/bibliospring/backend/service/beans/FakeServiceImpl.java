package edu.bbu.bibliospring.backend.service.beans;

import edu.bbu.bibliospring.backend.repo.FakeRepoInterface;
import edu.bbu.bibliospring.backend.service.FakeSericeInterface;
import javax.ejb.Stateless;

/**
 *
 * @author zsvitalyos
 */
@Stateless
public class FakeServiceImpl implements FakeSericeInterface {
    
    private FakeRepoInterface repo;

    public void doSomething() {
        repo.doSomething();
    }
    
}
