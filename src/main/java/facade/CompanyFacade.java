package facade;

import Entity.Address;
import Entity.Company;
import Entity.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 * @author Joachim
 */
public class CompanyFacade implements ICompanyFacade{

    
    EntityManagerFactory emf;
    EntityManager em;
    public CompanyFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public void addEntityManager(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }
    
    @Override
    public Company addCompany(Company company) {
        addEntityManager(emf);
            try{
                em.getTransaction().begin();
                em.persist(company);
                em.getTransaction().commit();
            }finally{
                em.close();
            }
        return company;
    }

    @Override
    public Company getCompanyOnCvr(int cvr) {
        addEntityManager(emf);
        Company company;
            try{
                em.getTransaction().begin();
                company = em.find(Company.class, cvr);
                em.getTransaction().commit();
            }finally{
                em.close();
            }
        return company;
    }

    @Override
    public Company getCompanyOnId(int id) {
        addEntityManager(emf);
        Company company;
            try{
                em.getTransaction().begin();
                company = em.find(Company.class, id);
                em.getTransaction().commit();
            }finally{
                em.close();
            }
        return company;
    }

    @Override
    public Company getCompanyOnPhone(String number) {
        addEntityManager(emf);
        Company company;
            try{
                em.getTransaction().begin();
                company = em.find(Company.class, number);
                em.getTransaction().commit();
            }finally{
                em.close();
            }
        return company;
    }

    @Override
    public List<Company> getCompanies() {
        addEntityManager(emf);
        List<Company> companies; 
            try{
                em.getTransaction().begin();
                Query query = em.createQuery("SELECT e FROM Company e");
                companies = query.getResultList();
                em.getTransaction().commit();
            }finally{
                em.close();
            }
        return companies;
    }

    @Override
    public Company addPhoneToCompany(Phone phone, long id) {
        addEntityManager(emf);
        Company company;
        Phone p = null;
        try {
            em.getTransaction().begin();
            company = em.find(Company.class, id);
            p = em.find(Phone.class, phone.getId());
            if (p == null) {
                p = phone;
            }
            if (company != null) {
                company.addPhone(p);
                em.merge(company);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
        return company;
    }

    @Override
    public Company addAddressToCompany(Address address, long id) {
        addEntityManager(emf);
        Address a = null;
        Company company = null;
        try {
            em.getTransaction().begin();
            company = em.find(Company.class, id);
            a = em.find(Address.class, address.getId());
            if (a == null) {
                a = address;
            }
            if (company != null) {
                company.setAddress(a);
                em.merge(company);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
        return company;
    }

    @Override
    public Company editCompany(Company company, long id) {
        addEntityManager(emf);
        Company c = null;

        try {
            em.getTransaction().begin();
            company.setId(id);
            em.merge(company);
            em.getTransaction().commit();
            c = em.find(Company.class, id);
        } finally {
            em.close();
        }
        return c;
    }

    @Override
    public Company deleteCompany(long id) {
        addEntityManager(emf);
        Company company = null;

        try {
            em.getTransaction().begin();
            company = em.find(Company.class, id);
            em.remove(company);
            em.getTransaction().commit();
        }finally{
                em.close();
        }
        return company;
    }
    
}
