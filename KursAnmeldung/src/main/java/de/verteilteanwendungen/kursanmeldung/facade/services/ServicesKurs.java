/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.facade.services;

import de.verteilteanwendungen.kursanmeldung.core.entities.enumeration.Rhythmus;
import de.verteilteanwendungen.kursanmeldung.core.usecases.KursManager;
import de.verteilteanwendungen.kursanmeldung.dataaccess.KursEntity;
import de.verteilteanwendungen.kursanmeldung.dataaccess.dao.KursDAO;
import de.verteilteanwendungen.kursanmeldung.facade.to.BenutzerTO;
import de.verteilteanwendungen.kursanmeldung.facade.to.KursTO;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author christophkrol
 */
@Path("/")
public class ServicesKurs {
    
    @EJB 
    private KursManager kManager;
    
    private static final Logger log = Logger.getLogger(ServicesKurs.class.getName());
    
    
    @POST
    @Path("/kurs/create")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createKurs(KursTO kto) throws ParseException{
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date parsedDate = dateFormat.parse(kto.startdatum());
        Timestamp startDatum = new java.sql.Timestamp(parsedDate.getTime());
        
        if(kManager.kursAnlegen(
                kto.kursID(), kto.kursname(), startDatum,
                kto.anzahlTermine(), kto.rhythmus())
                ){
            return Response.status(Response.Status.CREATED).build();
            
        }
        else{
            return Response.status(Response.Status.CONFLICT).build();
        }
        
    }
    
    
    @DELETE
    @Path("/kurs/{id}")
    @Produces("application/json")
    public Response deleteKurs(@PathParam("id") int kursID){
        if(kManager.kursEntfernen(kursID)){
            return Response.ok().entity("Kurs mit ID " + kursID + " entfernt").build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Kurs mit ID  " + kursID + " nicht gefunden").build();
        }
    }
    
    
    @PUT
    @Path("/kurs/aendern")
    @Produces("application/json")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateKurs(KursTO kto) throws ParseException{
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date parsedDate = dateFormat.parse(kto.startdatum());
        Timestamp startDatum = new java.sql.Timestamp(parsedDate.getTime());
        
        KursEntity updateKurs = new KursEntity(
                kto.kursID(), kto.kursname(), 
                startDatum, kto.anzahlTermine(),
                kto.rhythmus()
        );
        if(kManager.kursAendern(updateKurs)){
            return Response.ok().entity("Kurs mit ID " + kto.kursID() + " geändert").build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Kurs mit ID  " + kto.kursID() + " nicht gefunden").build();
        
        }
                
    }
    
    
    @GET
    @Path("/kurs/list")
    @Produces("application/json")
    public Response listKurse(){
        List<KursTO> kursList = kManager.listKurse();
        return Response.ok().entity(kursList).build();     
    }
    
    
    @GET
    @Path("/kurs/{id}")
    @Produces("application/json")
    public Response getKurs(@PathParam("id") int kursID){
        KursTO kurs = kManager.kursSuchen(kursID);
        log.info("Kurs mit ID: " + kurs.kursID() + "zurückgeben");
        log.info(kurs.toString());
        return Response.ok().entity(kurs).build();     
    }
    
    

    
    
}
