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
public interface IFacade {
 
    public Person PersonInfoTlf(int tlf);
    
    public Company CompanyInfoCVR(int cvr);
    public Company CompanyInfoTlf(int tlf);
    
    public List<Person> PeopleWithHobby(String hobby);
    public List<Person> PeopleInCity(int zipcode);
    
    public List<Integer> AllZips(CityInfo ci);
    public List<Company> BigCompanies(int employees); 
    
    
}
