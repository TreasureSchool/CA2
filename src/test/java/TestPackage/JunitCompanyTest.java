package TestPackage;

import facade.CompanyFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Joachim
 */
public class JunitCompanyTest {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("0PUtest");
    CompanyFacade pf = new CompanyFacade(emf);
    
    public JunitCompanyTest() {
    }
}
