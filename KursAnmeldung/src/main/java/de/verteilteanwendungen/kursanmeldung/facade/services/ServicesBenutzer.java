/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.facade.services;

import de.verteilteanwendungen.kursanmeldung.core.exception.BenutzerNotFoundException;

import de.verteilteanwendungen.kursanmeldung.core.usecases.BenutzerManager;
import de.verteilteanwendungen.kursanmeldung.dataaccess.BenutzerEntity;

import de.verteilteanwendungen.kursanmeldung.dataaccess.dao.BenutzerDAO;
import de.verteilteanwendungen.kursanmeldung.facade.to.AdresseTO;
import de.verteilteanwendungen.kursanmeldung.facade.to.BenutzerTO;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author christophkrol
 * BeuntzerTO
 */
@Path("/")
public class ServicesBenutzer {
  
    @EJB private BenutzerDAO bdao;
    @EJB private BenutzerManager bManager;
    
    
    @POST
    @Path("/benutzer/create")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createBenutzer(BenutzerTO bto){
        
        if(bManager.benutzerAnlegen(bto.id(), bto.benutzername(), bto.passwort(),
                bto.vorname(), bto.nachname(), bto.adresse(), bto.bankverbindung(), bto.istKursleiter())){
            return Response.status(Response.Status.CREATED).build();
            
        }
        else{
            return Response.status(Response.Status.CONFLICT).build();
        }
        
        //bdao.anlegen(new BenutzerEntity(bto.adresse()));
    }
    
    
    @GET
    @Path("/benutzer/list")
    @Produces("application/json")
    public Response listBenutzer(){
        
        List<BenutzerTO> benutzerList = bManager.listBenutzer();
        return Response.ok().entity(benutzerList).build();
    }
    
    @GET
    @Path("/benutzer/{id}")
    @Produces("application/json")
    public Response getBenutzer(@PathParam("id") int benutzerID){
        try {
            BenutzerTO foundBenutzer = bManager.benutzerSuchen(benutzerID);
            return Response.ok().entity(foundBenutzer).build();
        } catch (BenutzerNotFoundException ex) {
            Logger.getLogger(ServicesBenutzer.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.NOT_FOUND).entity(ex.getMessage()).build();
        }

        
    }
    
    @DELETE
    @Path("/benutzer/{id}")
    @Produces("application/json")
    public Response deleteBenutzer(@PathParam("id") int benutzerID){
        if(bManager.benutzerEntfernen(benutzerID)){
            return Response.ok().entity("Benutzer mit ID " + benutzerID + " entfernt").build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Benutzer mit ID  " + benutzerID + " nicht gefunden").build();
        }
    }
    
    
    
    
    
}
