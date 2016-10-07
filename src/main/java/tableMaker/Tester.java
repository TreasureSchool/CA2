/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableMaker;

import Entity.Person;
import javax.persistence.Persistence;

/**
 *
 * @author Martin
 */
public class Tester {

    public static void main(String[] args) {

        Persistence.generateSchema("CA2PU", null);
                
        Person p1 = new Person("navn", "efternavn", "qwe@3wqe.dk");
        Person p2 = new Person("Jon", "Christensen", "dwp@dwp.com");
        Person p3 = new Person("Joachim", "Christensen", "dwp@dwp.com");
        
        
    }
}
