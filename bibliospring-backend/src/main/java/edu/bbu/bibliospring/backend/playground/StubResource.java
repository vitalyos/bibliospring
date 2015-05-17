package edu.bbu.bibliospring.backend.playground;

import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.ejb.Stateless;

/**
 *
 * @author zsvitalyos
 */
@Stateless
@LocalBean
@Startup
public class StubResource {
    public  StubResource () {
        System.out.println("HelloBean");
    }
}
