/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonConverter;

import Entity.Person;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author Nicolai
 */
public class PersonJsonConverter {

    Gson gson = new Gson();

    public Person addPerson(String jsonAsString) {
        Person p = null;

        try {

            JsonObject jo = new JsonParser().parse(jsonAsString).getAsJsonObject();
            String firstName = jo.get("firstname").getAsString();
            String lastName = jo.get("lastname").getAsString();
            String email = jo.get("email").getAsString();
            p = new Person(firstName, lastName, email);
        } catch (Exception e) {
        }

        return p;
    }
    
    //person to json metode skal skrives til get metode
}
