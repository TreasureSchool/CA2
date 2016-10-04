/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import facade.Facade;
import facade.IFacade;
import static org.junit.Assert.*;

/**
 *
 * @author Martin
 */
public class JunitTest {
    
    public JunitTest() {
    }
    
    @Before
    public void setUp() {
    
    EntityManagerFactory emf;
    EntityManager em;
    Facade facade = new Facade();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testPersonTlf(){
        
        int tlf = 12345678;
        facade.
        
    }
    
}
