package TestPackage;

import Entity.Address;
import Entity.CityInfo;
import Entity.Hobby;
import Entity.Person;
import Entity.Phone;
import javax.persistence.EntityManagerFactory;
import org.junit.Test;
import facade.PersonFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Martin
 */
public class JunitPersonTest {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("0PUTest");
    PersonFacade pf = new PersonFacade(emf);
    public JunitPersonTest() {
    }
    
    
    @Test
    public void personCreation(){
        Person testPerson = new Person("Joachim", "Ellingsgaard", "test@tests.com");
        pf.addPerson(testPerson);
        assertEquals(testPerson, pf.getPerson(testPerson.getId()));
    }
    @Test
    public void personByTlf(){
        Person testPerson = new Person("Joachim", "Ellingsgaard", "test@tests.com");
        Phone ph1 = new Phone("1234567","mobil");
        Hobby hb = new Hobby("Football", "kick ball");
        testPerson.addHobby(hb);
        testPerson.addPhone(ph1);
        pf.addPerson(testPerson);
        Person resultPerson = pf.GetPersonInfoTlf(ph1.getNumber());
        assertEquals(testPerson, resultPerson);
    }
    @Test
    public void peopleByZip(){
        Person testPerson = new Person("Joachim", "Ellingsgaard", "test@tests.com");
        Person testPerson2 = new Person("Joachim", "Ellingsgaard", "test@tests.com");
        Person testPerson3 = new Person("Joachim", "Ellingsgaard", "test@tests.com");
        
        Address address1 = new Address("Test", new CityInfo(9999, "Testland"));
        Address address2 = new Address("Test2", new CityInfo(9994, "Testcountry"));
        
        testPerson.setAddress(address2);
        testPerson2.setAddress(address1);
        testPerson3.setAddress(address2);
        
        pf.addPerson(testPerson);
        pf.addPerson(testPerson2);
        pf.addPerson(testPerson3);
        List<Person> testList = new ArrayList<>();
        testList.add(testPerson);
        testList.add(testPerson3);
        assertEquals(testList, pf.getPersonsFromZipcode(address2.getCity().getZipCode()));
    }
}
