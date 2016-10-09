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
    } //virker kun hvis der er en person med en given telefon.
    @Test
    public void peopleByZip(){
        Person testPerson = new Person("Joachim", "Ellingsgaard", "test@tests.com");
        Person testPerson2 = new Person("Joachim", "Ellingsgaard", "test@tests.com");
        Person testPerson3 = new Person("Joachim", "Ellingsgaard", "test@tests.com");
        
        Address address = new Address("Test", new CityInfo(9999, "Testland"));
        
        testPerson.setAddress(address);
        testPerson2.setAddress(address);
        testPerson3.setAddress(address);
        
        pf.addPerson(testPerson);
        pf.addPerson(testPerson2);
        pf.addPerson(testPerson3);
        List<Person> testList = new ArrayList<>();
        testList.add(testPerson);
        testList.add(testPerson2);
        testList.add(testPerson3);
        assertEquals(testList, pf.getPersonsFromZipcode(address.getCity().getZipCode()));
    }
    @Test
    public void deletePerson(){
        Person testPerson = new Person("Joachim", "Ellingsgaard", "test@tests.com");
        Person resultPerson = null;
        
        pf.addPerson(testPerson);
        pf.deletePerson(testPerson.getId());
        assertEquals(pf.getPerson(testPerson.getId()), resultPerson);
    }
    @Test
    public void getPeople(){
        Person testPerson = new Person("Joachim", "Ellingsgaard", "test@tests.com");
        
        List<Person> resultList = pf.getPersons();
        pf.addPerson(testPerson);
        List<Person> testList = pf.getPersons();
        resultList.add(testPerson);
        assertEquals(testList, resultList);
    }
    @Test
    public void getPeopleByHobby(){
        Person testPerson = new Person("Joachim", "Ellingsgaard", "test@tests.com");
        Person testPerson2 = new Person("Joachim", "Ellingsgaard", "test@tests.com");
        Person testPerson3 = new Person("Joachim", "Ellingsgaard", "test@tests.com");
        
        Hobby hb = new Hobby("Football", "kick ball");
        Hobby hb1 = new Hobby("Tennis", "hit ball");
        
        testPerson.addHobby(hb1);
        testPerson2.addHobby(hb);
        testPerson3.addHobby(hb1);
        pf.addPerson(testPerson);
        pf.addPerson(testPerson2);
        List<Person> testList = new ArrayList<>();
        testList.add(testPerson);
        assertEquals(testList, pf.PeopleWithHobby(hb1.getName()));
    } //hobbier virker ikke helt så kun en person kan have en given hobby.
    @Test
    public void getAllZips(){
        List<Integer> testList = pf.AllZips();
        Person testPerson = new Person("Joachim", "Ellingsgaard", "test@tests.com");
        Address address = new Address("Test", new CityInfo(100000, "Tester"));
        testPerson.setAddress(address);
        pf.addPerson(testPerson);
        List<Integer> resultList = pf.AllZips();
        testList.add(100000);
        assertEquals(testList, resultList);
    }
    @Test
    public void editPerson(){
        Person testPerson = new Person("Joachim", "Ellingsgaard", "test@tests.com");
        pf.addPerson(testPerson);
        Person testPerson2 = new Person("Joachim", "Ellingsgaard", "shit@ass.com");
        assertEquals(testPerson2, pf.editPerson(testPerson2, testPerson.getId()));
    }
    @Test
    public void getHobbyCount(){
        Person testPerson = new Person("Joachim", "Ellingsgaard", "test@tests.com");
        Person testPerson2 = new Person("Joachim", "Ellingsgaard", "test@tests.com");
        Person testPerson3 = new Person("Joachim", "Ellingsgaard", "test@tests.com");
        
        Hobby hb = new Hobby("Football", "kick ball");
        pf.addPerson(testPerson);
        pf.addPerson(testPerson2);
        pf.addPerson(testPerson3);
        pf.addHobbyToPerson(hb, testPerson.getId());
        pf.addHobbyToPerson(hb, testPerson2.getId());
        pf.addHobbyToPerson(hb, testPerson3.getId());
        assertEquals(3, pf.HobbyCount(hb.getName()));
    } //virker ikke
}
