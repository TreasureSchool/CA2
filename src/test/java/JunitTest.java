/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.EntityManagerFactory;
import org.junit.Test;
import facade.Facade;
import javax.persistence.Persistence;
import static org.junit.Assert.*;

/**
 *
 * @author Martin
 */
public class JunitTest {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("0PU");
    Facade facade = new Facade(emf);
    public JunitTest() {
    }
    
    @Test
    public void testPersonTlf(){
        
    }
    
}
