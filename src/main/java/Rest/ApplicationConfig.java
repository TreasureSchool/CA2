/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Joachim
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Rest.PersonResource.class);
        resources.add(service.AddressFacadeREST.class);
        resources.add(service.CityInfoFacadeREST.class);
        resources.add(service.CompanyFacadeREST.class);
        resources.add(service.HobbyFacadeREST.class);
        resources.add(service.InfoEntityFacadeREST.class);
        resources.add(service.PersonFacadeREST.class);
        resources.add(service.PhoneFacadeREST.class);
    }
    
}
