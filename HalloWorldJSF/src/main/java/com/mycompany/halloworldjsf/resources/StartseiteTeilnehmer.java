/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.halloworldjsf.resources;

import com.mycompany.halloworldjsf.to.KursTO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author christophkrol
 */
@RequestScoped
@Named("startseiteTeilnehmer")
public class StartseiteTeilnehmer {
    final Logger log = Logger.getLogger(getClass().getName());
    
    
     List<KursTO> kursliste;

    public List<KursTO> getKursliste() {
        return kursliste;
    }

    public void setKursliste(List<KursTO> kursliste) {
        this.kursliste = kursliste;
    }
     
     
    
    public StartseiteTeilnehmer(){
        
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/KursAnmeldung/webapi/kurs/list");
        kursliste =  target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<KursTO>>() {});
        
        
    }
    
    
    public void reloadPage() {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    
    try {
        externalContext.redirect(externalContext.getRequestContextPath() + externalContext.getRequestServletPath());
    } catch (IOException e) {
        e.printStackTrace(); 
    }
}
    
    
    public boolean checkTeilnahme(KursTO kurs, int teilnehmerID){
       
        return kurs.getTeilnehmer().contains(teilnehmerID);

    }
    
    public String kursAnmelden(int kursID, int benutzerID){
        Client client = ClientBuilder.newClient();
        WebTarget baseLink = client.target("http://localhost:8080/KursAnmeldung/webapi/kurs/");
        WebTarget kursAnmeldungLink = baseLink.path("{kursID}").path("/anmelden/").path("{benutzerID}");
        
        
        Invocation.Builder invocationBuilder =  kursAnmeldungLink
                .resolveTemplate("kursID", kursID)
                .resolveTemplate("benutzerID", benutzerID)
                .request();
        Response res = invocationBuilder.method("PUT", Entity.json("{}"));
        //log.info(res.readEntity(String.class));
        if(res.readEntity(String.class).equals("Anmeldezeitraum abgelaufen!")){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Anmeldezeitraum abgelaufen!", "Startdatum ist in der Vergangenheit"));
            return "/StartseiteTeilnehmer.xhtml";
        }
        else{
            return "/StartseiteTeilnehmer.xhtml";
        }
        
       
        
    }
    
    public String kursAbmelden(int kursID, int benutzerID){
        Client client = ClientBuilder.newClient();
        WebTarget baseLink = client.target("http://localhost:8080/KursAnmeldung/webapi/kurs/");
        WebTarget kursAnmeldungLink = baseLink.path("{kursID}").path("/abmelden/").path("{benutzerID}");
        
        
        Invocation.Builder invocationBuilder =  kursAnmeldungLink
                .resolveTemplate("kursID", kursID)
                .resolveTemplate("benutzerID", benutzerID)
                .request();
        Response res = invocationBuilder.method("PUT", Entity.json("{}"));
       
        if(res.readEntity(String.class).equals("Abmeldezeitraum abgelaufen!")){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Kurs läuft bereits!", "Startdatum ist in der Vergangenheit"));
            return "/StartseiteTeilnehmer.xhtml";
        }
        else{
            return "/StartseiteTeilnehmer.xhtml";
        }
    
        
        
    
        
    }
    
    
}
