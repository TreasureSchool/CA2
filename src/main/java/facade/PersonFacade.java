package facade;

import Entity.Address;
import Entity.CityInfo;
import Entity.Hobby;
import Entity.Person;
import Entity.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 * @author Martin
 */
public class PersonFacade implements IPersonFacade {

    EntityManagerFactory emf;
    EntityManager em;
    public PersonFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public void addEntityManager(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }

    @Override
    public List<Person> PeopleWithHobby(String hobby) {
    
        addEntityManager(emf);
        List<Person> people;
            try{
                em.getTransaction().begin();
                Query query = em.createQuery("Select e FROM Person e WHERE e.hobbies = :hobby").setParameter("hobby", hobby);
                people = query.getResultList();
                em.getTransaction().commit();
            }finally{
                em.close();
            }
        return people;
    }

    @Override
    public List<Integer> AllZips(CityInfo ci) {
        addEntityManager(emf);
        List<Integer> zips;
            try{
                em.getTransaction().begin();
                Query query = em.createQuery("Select e.zip FROM CityInfo e");
                zips = query.getResultList();
                em.getTransaction().commit();
            }finally{
                em.close();
            }
        return zips;
    }

    @Override
    public Person addPerson(Person person) {
        addEntityManager(emf);
            try{
                em.getTransaction().begin();
                em.persist(person);
                em.getTransaction().commit();
            }finally{
                em.close();
            }
        return person;
    }

    @Override
    public Person addHobbyToPerson(Hobby hobby, long id) {
        addEntityManager(emf);
        Person person = null;
            try{
                em.getTransaction().begin();
                person = em.find(Person.class, id);
                hobby = addHobby(hobby);
                person.addHobby(hobby);
                em.merge(person);
                em.getTransaction().commit();
            }finally{
                em.close();
            }
        return person;
    }

    @Override
    public Hobby addHobby(Hobby hobby) {
        addEntityManager(emf);
        try {
            em.getTransaction().begin();
            Hobby h = em.find(Hobby.class, hobby);
            if (h != null) {
                return h;
            }
            em.persist(hobby);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return hobby;
    }

    @Override
    public Person addPhoneToPerson(Phone phone, long id) {
        addEntityManager(emf);
        Person person = null;
            try{
                em.getTransaction().begin();
                person = em.find(Person.class, id);
                person.addPhone(phone);
                em.merge(person);
                em.getTransaction().commit();
            }finally{
                em.close();
            }
        return person;
    }

    @Override
    public Person addAddressToPerson(Address address, long id) {
        addEntityManager(emf);
        Address a = null;
        Person person = null;
        try {
            em.getTransaction().begin();
            person = em.find(Person.class, id);
            a = em.find(Address.class, address.getId());
            if (a == null) {
                a = address;
            }
            if (person != null) {
                person.setAddress(a);
                em.merge(person);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
        return person;
    }

    @Override
    public boolean deletePerson(long id) {
        addEntityManager(emf);
        Person p = null;
        try {
            em.getTransaction().begin();
            p = em.find(Person.class, id);
            em.remove(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return true;
    }

    @Override
    public Person editPerson(Person person, long id) {
        addEntityManager(emf);
        Person p = null;
        try {
            em.getTransaction().begin();
            person.setId(id);
            em.merge(person);
            em.getTransaction().commit();
            p = em.find(Person.class, id);
        } finally {
            em.close();
        }
        return p;
    }

    @Override
    public Person getPerson(long id) {
        addEntityManager(emf);
        Person p = null;
        try {
            em.getTransaction().begin();
            p = em.find(Person.class, id);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return p;
    }

    @Override
    public List<Person> getPersons() {
        addEntityManager(emf);
        List<Person> people;
        try{
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT e FROM Person e");
            people = query.getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return people;
    }

    @Override
    public Person GetPersonInfoTlf(String tlf) {
        addEntityManager(emf);
        Person person;
        try{
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT e FROM Person e WHERE e.phones = :number").setParameter("number", tlf);
            person = (Person) query.getSingleResult();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return person;
    }

    @Override
    public List<Person> getPersonsFromZipcode(String city) {
        addEntityManager(emf);
        List<Person> people;
            try{
                em.getTransaction().begin();
                Query query = em.createQuery("Select e FROM Person e WHERE e.address.city = :city").setParameter("city", city);
                people = query.getResultList();
                em.getTransaction().commit();
            }finally{
                em.close();
            }
        return people;
    }

    @Override
    public int HobbyCount(String hobby) {
        addEntityManager(emf);
        int peopleCount;
            try{
                em.getTransaction().begin();
                Query query = em.createQuery("Select e FROM Person e WHERE e.hobbies = :hobby").setParameter("hobby", hobby);
                peopleCount = query.getResultList().size();
                em.getTransaction().commit();
            }finally{
                em.close();
            }
        return peopleCount;
    }
}
