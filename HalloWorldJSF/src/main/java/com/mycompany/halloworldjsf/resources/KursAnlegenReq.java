/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.halloworldjsf.resources;

import com.mycompany.halloworldjsf.enumeration.Rhythmus;
import com.mycompany.halloworldjsf.to.AdresseTO;
import com.mycompany.halloworldjsf.to.BenutzerTO;
import com.mycompany.halloworldjsf.to.KursTO;
import com.mycompany.halloworldjsf.to.KursTORequest;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.json.Json;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author christophkrol
 */
@RequestScoped
@Named
public class KursAnlegenReq {
    private final Logger log = Logger.getLogger(getClass().getName());
    int kursID;
    String kursname;
    String startdatum;
    int anzahlTermine;
    String rhythmus;

    public int getKursID() {
        return kursID;
    }

    public void setKursID(int kursID) {
        this.kursID = kursID;
    }

    
    public String getKursname() {
        return kursname;
    }

    public void setKursname(String kursname) {
        this.kursname = kursname;
    }

    public String getStartdatum() {
        return startdatum;
    }

    public void setStartdatum(String startdatum) {
        this.startdatum = startdatum;
    }

    public int getAnzahlTermine() {
        return anzahlTermine;
    }

    public void setAnzahlTermine(int anzahlTermine) {
        this.anzahlTermine = anzahlTermine;
    }

    public String getRhythmus() {
        return rhythmus;
    }

    public void setRhythmus(String rhythmus) {
        this.rhythmus = rhythmus;
    }
    
    
    
    
    
    
    
     public String kursAktualisieren() throws ParseException{
         
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date parsedDate = dateFormat.parse(this.getStartdatum());
        Timestamp startDatum = new java.sql.Timestamp(parsedDate.getTime());
         
        KursTORequest kto = new KursTORequest(kursID ,kursname, startDatum.toString(), anzahlTermine, rhythmus);
        
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/KursAnmeldung/webapi/kurs/aendern");
        
        Response res = target.request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(kto, MediaType.APPLICATION_JSON), Response.class);
        
        Status s = res.getStatusInfo().toEnum();
        
        if(s  == Response.Status.OK){
            /*
            this.setKursname(null);
           
            this.setStartdatum(null);
            this.setRhythmus(null);
            */
            
            return "/KursÄndernAuswahl.xhtml";
        
        }else{
            
            log.info(Entity.entity(kto, MediaType.APPLICATION_JSON).toString());
             // Fehlermeldung rausgeben
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aktualisierung nicht erfolgreich! (Status  " + s.toString() + ")", ""));
            this.setKursname(null);
           
            this.setStartdatum(null);
            this.setRhythmus(null);
            
        
            return "/KursÄndern.xhtml";     
        }    
        
    }
     
    public String kursAnlegen() throws ParseException{
         
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date parsedDate = dateFormat.parse(this.getStartdatum());
        Timestamp startDatum = new java.sql.Timestamp(parsedDate.getTime());
         
        KursTORequest kto = new KursTORequest(kursID ,kursname, startDatum.toString(), anzahlTermine, rhythmus);
        
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/KursAnmeldung/webapi/kurs/create");
        
        Response res = target.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(kto, MediaType.APPLICATION_JSON), Response.class);
        
        Status s = res.getStatusInfo().toEnum();
        
        if(s  == Response.Status.CREATED){
            
            this.setKursname(null);
           
            this.setStartdatum(null);
            this.setRhythmus(null);
            
            
            return "/StartseiteKursleiter.xhtml";
        
        }else{
            
            log.info(Entity.entity(kto, MediaType.APPLICATION_JSON).toString());
             // Fehlermeldung rausgeben
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Anlegen nicht erfolgreich! (Status  " + s.toString() + ")", ""));
            this.setKursname(null);
           
            this.setStartdatum(null);
            this.setRhythmus(null);
            
            
            
            return "/KursAnlegen.xhtml";
        
        }
        
        
    }
    
}
