/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Entity.CityInfo;
import Entity.Company;
import Entity.Person;
import java.util.List;

/**
 *
 * @author Martin
 */
public class Facade implements IFacade{

    @Override
    public Person PersonInfoTlf(List<Person> people, int tlf) {
    
        for (Person person : people) {
            
            if(person)
            
        }
        
        
    }

    @Override
    public Company CompanyInfoCVR(int cvr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Company CompanyInfoTlf(int tlf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> PeopleWithHobby(String hobby) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> PeopleInCity(int zipcode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Integer> AllZips(CityInfo ci) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Company> BigCompanies(int employees) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
