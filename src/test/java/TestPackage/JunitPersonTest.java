//package TestPackage;
//
//import Entity.Hobby;
//import Entity.Person;
//import Entity.Phone;
//import javax.persistence.EntityManagerFactory;
//import org.junit.Test;
//import facade.PersonFacade;
//import javax.persistence.Persistence;
//import static org.junit.Assert.assertEquals;
//
///**
// *
// * @author Martin
// */
//public class JunitPersonTest {
//    
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("0PUTest");
//    PersonFacade pf = new PersonFacade(emf);
//    public JunitPersonTest() {
//    }
//    
//    
//    @Test
//    public void personCreation(){
//        Person testPerson = new Person("Joachim", "Ellingsgaard", "test@tests.com");
//        pf.addPerson(testPerson);
//        assertEquals(testPerson, pf.getPerson(testPerson.getId()));
//    }
//    @Test
//    public void personByTlf(){
//        Person testPerson = new Person("Joachim", "Ellingsgaard", "test@tests.com");
//        Phone ph1 = new Phone("1234567","mobil");
//        Hobby hb = new Hobby("Football", "kick ball");
//        testPerson.addHobby(hb);
//        testPerson.addPhone(ph1);
//        pf.addPerson(testPerson);
//        assertEquals(testPerson, pf.GetPersonInfoTlf("1234567"));
//    }
//}
