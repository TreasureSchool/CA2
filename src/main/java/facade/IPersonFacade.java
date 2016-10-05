/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Entity.Address;
import Entity.CityInfo;
import Entity.Hobby;
import Entity.Person;
import Entity.Phone;
import java.util.List;
/**
 * @author Martin
 */
public interface IPersonFacade {
    Person addPerson(Person person);
    Person addHobbyToPerson(Hobby hobby, long id);
    Hobby addHobby(Hobby hobby);
    Person addPhoneToPerson(Phone phone, long id);
    Person addAddressToPerson(Address address, long id);
    boolean deletePerson(long id);
    Person editPerson(Person person, long id);
    Person getPerson(long id);
    List<Person> getPersons();
    Person GetPersonInfoTlf(String tlf);
    List<Person> getPersonsFromZipcode(String city);
    List<Person> PeopleWithHobby(String hobby);
    int HobbyCount(String hobby);
    List<Integer> AllZips(CityInfo ci);
}
