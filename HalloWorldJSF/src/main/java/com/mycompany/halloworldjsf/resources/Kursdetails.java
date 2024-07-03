/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.halloworldjsf.resources;

import com.mycompany.halloworldjsf.to.KursTO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author christophkrol
 */
@Named
@RequestScoped
public class Kursdetails {
    
    @Inject
    private StartseiteKursleiter startseite;
    
    @ManagedProperty(value="#{param.ausgewählterKurs}")
    private  KursEintrag ausgewählterKurs;
    
    
    
    List<TeilnehmerEintrag> teilnehmerliste;

    public List<TeilnehmerEintrag> getTeilnehmerliste() {
        return teilnehmerliste;
    }

    public void setTeilnehmerliste(List<TeilnehmerEintrag> teilnehmerliste) {
        this.teilnehmerliste = teilnehmerliste;
    }

    public KursEintrag getAusgewählterKurs() {
        return ausgewählterKurs;
    }

    public void setAusgewählterKurs(KursEintrag ausgewählterKurs) {
        this.ausgewählterKurs = ausgewählterKurs;
    }
    
    public void zeigeTeilnehmerliste(int kursID){
         Client client = ClientBuilder.newClient();
        WebTarget apiLink = client.target("http://localhost:8080/KursAnmeldung/webapi/kurs/");
        WebTarget target = apiLink.path("{kursID}").path("/list");
        
         List<TeilnehmerEintrag> res = target
                .resolveTemplate("kursID", kursID)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<TeilnehmerEintrag>>(){});
        
    }
    
    
    

    
    /*

   public Kursdetails(){
        Client client = ClientBuilder.newClient();
        WebTarget apiLink = client.target("http://localhost:8080/KursAnmeldung/webapi/kurs/");
        WebTarget target = apiLink.path("{kursID}").path("/list");
        
         List<TeilnehmerEintrag> res = target
                .resolveTemplate("kursID", this.ausgewählterKurs.kursID)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<TeilnehmerEintrag>>(){});
   
       
   }    */
    
    
    
    
    
    
    
}
