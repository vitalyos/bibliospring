/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
