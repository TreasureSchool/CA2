package TestPackage;

import Entity.Company;
import Entity.Phone;
import facade.CompanyFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;

 /**
 * @author Joachim
 */
public class JunitCompanyTest {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("0PUTest");
    CompanyFacade cf = new CompanyFacade(emf);
    
    public JunitCompanyTest() {
    }
    
    @Test
    public void getCompanyOnCvr() {
        Company company = new Company("TestCo","Et test company","111",0,0.0,"test@test.com");
        cf.addCompany(company);
        assertEquals(company, cf.getCompanyOnCvr(company.getCvr()));
    } //virker kun hvis companierne har unikt cvr.
    @Test
    public void getCompanyOnId() {
        Company company = new Company("TestCo","Et test company","222",0,0.0,"test@test.com");
        cf.addCompany(company);
        assertEquals(company, cf.getCompanyOnId(company.getId()));
    }
    @Test
    public void getCompanyOnPhone(){
        Company company = new Company("TestCo","Et test company","333",0,0.0,"test@test.com");
        Phone p = new Phone("123123", "TestPhone");
        company.addPhone(p);
        cf.addCompany(company);
        assertEquals(company, cf.getCompanyOnPhone(p.getNumber()));
    } //virker kun hvis der er et company der har en specifik mobil
    @Test
    public void getCompanies(){
        Company company = new Company("TestCo","Et test company","333",0,0.0,"test@test.com");
        Company company2 = new Company("TestCo","Et test company","333",0,0.0,"test@test.com");
        Company company3 = new Company("TestCo","Et test company","333",0,0.0,"test@test.com");
        cf.addCompany(company);
        cf.addCompany(company2);
        cf.addCompany(company3);
        List<Company> testList = cf.getCompanies();
        testList.add(company);
        cf.addCompany(company);
        assertEquals(testList, cf.getCompanies());
    }
    @Test
    public void deleteCompany(){
        Company company = new Company("TestCo","Et test company","333",0,0.0,"test@test.com");
        Company company2 = null;
        cf.addCompany(company);
        cf.deleteCompany(company.getId());
        assertEquals(company2, cf.getCompanyOnId(company.getId()));
    }
    @Test
    public void editCompany(){
        Company company = new Company("TestCo","Et test company","333",0,0.0,"test@test.com");
        Company company2 = new Company("TestCo","Et test company","444",0,0.0,"test@test.com");
        cf.addCompany(company);
        cf.editCompany(company2, company.getId());
        assertEquals(company2, cf.getCompanyOnId(company.getId()));
    }
}