/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.facade.services;

import de.verteilteanwendungen.kursanmeldung.core.usecases.TeilnehmerlisteManager;
import de.verteilteanwendungen.kursanmeldung.facade.to.BenutzerTO;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author christophkrol
 */
@Path("/")
public class ServicesTeilnehmerliste {
    
    @EJB
    TeilnehmerlisteManager tlManager;
    
    @GET
    @Path("/kurs/{kursID}/list")
    @Produces("application/json")
    public Response listTeilnehmer(@PathParam("kursID") int kursID){
        
        List<BenutzerTO> teilnehmerListe = tlManager.teilnehmerlisteAnzeigen(kursID);
        return Response.ok().entity(teilnehmerListe).build();
    }
    
}
