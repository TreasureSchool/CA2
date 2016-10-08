/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableMaker;

import Entity.Person;
import facade.PersonFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Martin
 */
public class Tester {

    public static void main(String[] args) {
        
        PersonFacade pf = new PersonFacade(Persistence.createEntityManagerFactory("CA2PU"));
        Person p = new Person();
        p.setFirstName("Nicolai");
        p.setLastName("Mikkelsen");
        p.setEmail("hej@hotaåk");
        
        pf.addPerson(p);
    }
}
