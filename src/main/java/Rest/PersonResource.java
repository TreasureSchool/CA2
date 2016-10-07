/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;


import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * REST Web Service
 *
 * @author Nicolai
 */
@Path("person")
public class PersonResource {
    
    
    private static HashMap<Integer, String> persons = new HashMap<Integer, String>() {
        {
            put(1, "Nicolai Mikkelsen");
            put(2, "Peter Henriksen");
            put(3, "Ib Skåbe");
            put(4, "Bæskubberen");
        }
    };
 
    private Gson gson = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
    
    @Context
    private UriInfo context;
    

    /**
     * Creates a new instance of GenericResource
     */
    public PersonResource() {
    }

    /**
     * Retrieves representation of an instance of Entity.PersonResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getXml(@PathParam("id") int id, Map<Integer, String> name) {
        Gson gson = new com.google.gson.GsonBuilder().create();
        JsonObject PersonTest = new JsonObject();
        int key = id;
        PersonTest.addProperty("person", persons.get(key));
        String jsonRes = gson.toJson(PersonTest);
        return jsonRes;
    }
    
    
    @GET
    @Path("random")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandom(@PathParam("random") int id, Map<Integer, String> peo) {
        Gson gson = new com.google.gson.GsonBuilder().create();
        JsonObject RPeople = new JsonObject();
        List<String> peopleList = new ArrayList<>();
        for (int i = 0; i < persons.size()+1; i++) {
            peopleList.add(persons.get(i));
        }
        int randomPerson = new Random().nextInt(peopleList.size());
        String randompeople = peopleList.get(randomPerson);
        RPeople.addProperty("quote", randompeople);
        String jsonRes = gson.toJson(RPeople);
        return jsonRes;
        
    }
    }
