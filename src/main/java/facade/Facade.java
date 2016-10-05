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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Martin
 */
public class Facade implements IFacade {

    EntityManagerFactory emf;
    EntityManager em;
    public Facade(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public void addEntityManager(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }
    
    @Override
    public Person PersonInfoTlf(int tlf) {
        addEntityManager(emf);
        Person person;
        try{
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT e FROM Person e WHERE e.number = :number").setParameter("number", tlf);
            person = (Person) query.getSingleResult();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return person;
    }
    
    @Override
    public Company CompanyInfoCVR(int cvr) {
        addEntityManager(emf);
        Company company;
            try{
                em.getTransaction().begin();
                Query query = em.createQuery("Select e FROM Company e where e.cvr = :cvr").setParameter("cvr", cvr);
                company = (Company) query.getSingleResult();
                em.getTransaction().commit();
            }finally{
                em.close();
            }
            return company;
    }

    @Override
    public Company CompanyInfoTlf(int tlf) {
        addEntityManager(emf);
        Company company;
            try{
                em.getTransaction().begin();
                Query query = em.createQuery("Select e FROM Phone e WHERE e.number = :number").setParameter("number", tlf);
                company = (Company) query.getSingleResult();
                em.getTransaction().commit();
            }finally{
                em.close();
            }
            return company;
    }

    @Override
    public List<Person> PeopleWithHobby(String hobby) {
    
        addEntityManager(emf);
        List<Person> people;
            try{
                em.getTransaction().begin();
                Query query = em.createQuery("Select e FROM Hobby e WHERE e.name = :hobby").setParameter("hobby", hobby);
                people = query.getResultList();
                em.getTransaction().commit();
            }finally{
                em.close();
            }
        return people;
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
