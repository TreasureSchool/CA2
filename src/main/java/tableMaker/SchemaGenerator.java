package tableMaker;

import Entity.Address;
import Entity.CityInfo;
import Entity.Company;
import Entity.Hobby;
import Entity.Person;
import Entity.Phone;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class SchemaGenerator {

    public static void main(String[] args) {
        Persistence.generateSchema("0PUTest", null);

        EntityManager em = Persistence.createEntityManagerFactory("0PUTest").createEntityManager();

        em.getTransaction().begin();

        Person p = new Person("Joachim", "Ellingsgaard", "dwp@dwp.com");
        Person p1 = new Person("Jon", "Christensen", "dwp@dwp.com");
        Person p2 = new Person("Joachim", "Christensen", "dwp@dwp.com");
        
        Company c = new Company("DWP Web", "Programming og development", "384729", 1, 1500000.00,"daniel@dwpweb.dk");
        Company c1 = new Company("Mo's kebab", "Making kebabs", "352349", 1, 30.00,"moha@mohamed.dk");
        Company c2 = new Company("Saeid IT support", "IT support", "234239", 1, 500.50,"hazem@saeid.dk");
        Company c3 = new Company("CES A/S", "Programming og development", "938472", 1, 1000.00,"emil@peder.dk");

        Address address = new Address("Nygardsvej 123", new CityInfo(2980, "Kokkedal"));
        Address address1 = new Address("Gaggervej 72", new CityInfo(3000, "Helsingoer"));
        Address address2 = new Address("Wall Street 983", new CityInfo(2820, "Gentofte"));
        
        
        Phone ph = new Phone("93949192", "mobil");
        Phone ph1 = new Phone("1234567","mobil");
        Hobby hb = new Hobby("Football", "kick ball");
        Hobby hb1 = new Hobby("Tennis", "hit ball");
        Hobby hb2 = new Hobby("Swimming", "swim in water");
        Hobby hb3 = new Hobby("Running", "run Forest run!");

        c.addPhone(ph);
        c3.addPhone(ph1);
        
        c.setAddress(address);
        c1.setAddress(address1);
        c3.setAddress(address2);
        
        p.addHobby(hb);
        p.addHobby(hb1);
        p.addHobby(hb2);
        p1.addHobby(hb3);
        
        p.addPhone(ph);
        p.addPhone(ph1);
        
        p.setAddress(address);
        p1.setAddress(address);

        em.persist(p);
        em.persist(p1);
        em.persist(p2);
        
        em.persist(c);
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        
        em.getTransaction().commit();

//        List<Person> ps = new ArrayList();
//        ps.add(em.find(Person.class, p.getId()));
//        ps.add(em.find(Person.class, p1.getId()));
//        ps.add(em.find(Person.class, p2.getId()));
//
//        for (Person pp : ps) {
//            if (!pp.getHobbies().isEmpty()) {
//                System.out.println(pp.getHobbies().get(0).getName());
//            }
//            System.out.println(pp.getFirstName());
//            if (pp.getAddress() != null) {
//                System.out.println(pp.getAddress().getStreet());
//            }
//        }
        em.close();

    }

}
