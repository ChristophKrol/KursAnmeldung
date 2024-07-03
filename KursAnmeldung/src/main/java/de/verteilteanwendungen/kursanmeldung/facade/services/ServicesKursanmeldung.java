/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.facade.services;

import de.verteilteanwendungen.kursanmeldung.core.usecases.KursanmeldungsManager;
import jakarta.ejb.EJB;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.Response.StatusType;

/**
 *
 * @author christophkrol
 */
@Path("/")
public class ServicesKursanmeldung {
    
    @EJB
    KursanmeldungsManager anmeldungsmanager;
    
    
    @PUT
    @Path("kurs/{kursID}/anmelden/{benutzerID}")
    public Response kursAnmelden(@PathParam("kursID") int kursID, @PathParam("benutzerID") int benutzerID){
        if(anmeldungsmanager.kursAnmelden(kursID, benutzerID)){
            return Response.ok().entity("Anmeldung erfolgreich!").build();
        }else{
            return Response.status(Status.CONFLICT).entity("Anmeldezeitraum abgelaufen!").build();
        }
        
    }
    
    @PUT
    @Path("kurs/{kursID}/abmelden/{benutzerID}")
    public Response kursAbmelden(@PathParam("kursID") int kursID, @PathParam("benutzerID") int benutzerID){
        if(anmeldungsmanager.kursAbmelden(kursID, benutzerID)){
            return Response.ok().entity("Abmeldung erfolgreich!").build();
        }else{
            return Response.status(Status.CONFLICT).entity("Abmeldezeitraum abgelaufen!").build();
        }
        
        
    }
    
}
