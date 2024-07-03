/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.facade.services;

import de.verteilteanwendungen.kursanmeldung.core.usecases.Anmelden;
import de.verteilteanwendungen.kursanmeldung.facade.to.AnmeldungTO;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author christophkrol
 */
@Path("/")
public class ServiceAuthentifizierung {
    
    @EJB
    private Anmelden anmeldung;
    
    @GET
    @Path("/login/{username}/pwd=/{password}")
    @Produces("application/json")
    public Response anmelden(@PathParam("username") String username, @PathParam("password") String password){
        AnmeldungTO result = anmeldung.anmelden(username, password);
        
        if(result.benutzerID() != -1){
            return Response.status(Response.Status.OK)
                    .entity(result).build();
        }
        else{
            
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("FAILED").build();
        
        }
    }
    
}
