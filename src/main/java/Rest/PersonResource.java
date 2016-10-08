/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Entity.Person;
import JsonConverter.PersonJsonConverter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import facade.PersonFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.POST;

/**
 * REST Web Service
 *
 * @author Nicolai
 */
@Path("person")
public class PersonResource {

    static Gson gson = new Gson();

    //private Gson gson = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public PersonResource() {

    }

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2PU");
    EntityManager em;

    PersonFacade pf = new PersonFacade(emf);

    /**
     * Retrieves representation of an instance of Entity.PersonResource
     *
     * @return an instance of java.lang.String
     */
//    @GET
//    @Path("{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getXml(@PathParam("id") int id, Map<Integer, String> name) {
//        Gson gson = new com.google.gson.GsonBuilder().create();
//        JsonObject PersonTest = new JsonObject();
//        int key = id;
//        PersonTest.addProperty("person", persons.get(key));
//        String jsonRes = gson.toJson(PersonTest);
//        return jsonRes;
//    }
//
//    @GET
//    @Path("random")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getRandom(@PathParam("random") int id, Map<Integer, String> peo) {
//        Gson gson = new com.google.gson.GsonBuilder().create();
//        JsonObject RPeople = new JsonObject();
//        List<String> peopleList = new ArrayList<>();
//        for (int i = 0; i < persons.size() + 1; i++) {
//            peopleList.add(persons.get(i));
//        }
//        int randomPerson = new Random().nextInt(peopleList.size());
//        String randompeople = peopleList.get(randomPerson);
//        RPeople.addProperty("quote", randompeople);
//        String jsonRes = gson.toJson(RPeople);
//        return jsonRes;
//
//    }
    @GET
    @Path("persons/{userid}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Person getUserById(@PathParam("userid") int userid) {
        return pf.getPerson(userid);
    }

//    @POST
//    @Path("/persons/add")
//    @Produces(MediaType.APPLICATION_XML)
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    public void addUser(@FormParam("id") int id,
//            @FormParam("firstName") String firstname,
//            @FormParam("lastName") String lastname,
//            //  @FormParam("hobby") String hobby,
//            @FormParam("email") String email) throws IOException {
//            //  @FormParam("address") String address){
//
//        Person p = new Person(firstname, lastname, email);
//        pf.addPerson(p);
//
//    }
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addPerson(String text) {
        Person p = null;

        try {

            p = new PersonJsonConverter().addPerson(text);
            pf.addPerson(p);
        } catch (Exception e) {
        }

        return gson.toJson(p);
    }

    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonById(@PathParam("id") int id) {
        Person person = pf.getPerson(id);

        return gson.toJson(person);

    }
}
//    public String getXml(@PathParam("id") int id, Map<Integer, String> name) {
//        Gson gson = new com.google.gson.GsonBuilder().create();
//        JsonObject PersonTest = new JsonObject();
//        int key = id;
//        PersonTest.addProperty("person", persons.get(key));
//        String jsonRes = gson.toJson(PersonTest);
//        return jsonRes;
