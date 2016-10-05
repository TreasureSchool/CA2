package TestPackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.EntityManagerFactory;
import org.junit.Test;
import facade.PersonFacade;
import facade.CompanyFacade;
import javax.persistence.Persistence;
import static org.junit.Assert.*;

/**
 *
 * @author Martin
 */
public class JunitPersonTest {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("0PUtest");
    PersonFacade pf = new PersonFacade(emf);
    public JunitPersonTest() {
        
    }
    
    @Test
    public void testPersonTlf(){
        
    }
    
}
