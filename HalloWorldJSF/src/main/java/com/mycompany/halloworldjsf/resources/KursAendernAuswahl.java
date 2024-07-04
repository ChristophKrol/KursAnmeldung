/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.halloworldjsf.resources;

import com.mycompany.halloworldjsf.to.KursTO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author christophkrol
 */
@RequestScoped
@Named
public class KursAendernAuswahl implements Serializable{
    private static final long serialVersionUID = -211073331543638808L;
    
    
    List<KursTO> kursliste;
    KursTO chosenKurs;
    int chosenKursID;
    

    public KursAendernAuswahl() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/KursAnmeldung/webapi/kurs/list");
        kursliste = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<KursTO>>() {});
    }

    public List<KursTO> getKursliste() {
        return kursliste;
    }

    public void setKursliste(List<KursTO> kursliste) {
        this.kursliste = kursliste;
    }

    public KursTO getChosenKurs() {
        return chosenKurs;
    }

    public void setChosenKurs(KursTO chosenKurs) {
        this.chosenKurs = chosenKurs;
    }

    public int getChosenKursID() {
        return chosenKursID;
    }

    public void setChosenKursID(int chosenKursID) {
        this.chosenKursID = chosenKursID;
    }
    
    
    
    
    public String fetchChosenKurs(){
         Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/KursAnmeldung/webapi/kurs/{kursID}");
        chosenKurs = target.resolveTemplate("kursID", this.getChosenKursID()) .request(MediaType.APPLICATION_JSON).get(KursTO.class);
        return "/KursÄndern.xhtml";
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    
    
    
}
