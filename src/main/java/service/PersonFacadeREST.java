/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entity.Person;
import facade.PersonFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Martin
 */
@Stateless
@Path("/person")
public class PersonFacadeREST extends AbstractFacade<Person> {

    EntityManagerFactory emf;

    @PersistenceContext(unitName = "0PU")
    EntityManager em;

    public PersonFacadeREST() {
        super(Person.class);
    }
    PersonFacade pf = new PersonFacade(emf);



        @PUT
        @Path("{id}")
        @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        public void edit
        (@PathParam("id")
        Integer id, Person entity
        
            ) {
        super.edit(entity);
        }

        @DELETE
        @Path("{id}")
        public void remove
        (@PathParam("id")
        Integer id
        
            ) {
        super.remove(super.find(id));
        }

        @GET
        @Path("{id}")
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        public Person find
        (@PathParam("id")
        Integer id
        
            ) {
        return super.find(id);
        }

        @GET
        @Path("persons/{userid}")
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        public Person getUserById
        (@PathParam("userid")
        int userid
        
            ) {        
        return pf.getPerson(userid);
        }

        @GET
        @Path("persons")
        @Produces(MediaType.TEXT_PLAIN)
        public List<Person> getUsers
        
            () {
        return pf.getPersons();
        }

        @Override
        protected EntityManager getEntityManager
        
            () {
        return em;
        }

    }
