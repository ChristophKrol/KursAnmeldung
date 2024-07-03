/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.halloworldjsf.resources;

import jakarta.enterprise.context.RequestScoped;
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
@RequestScoped
@Named
public class KursLoeschen {
    
    int chosenKurs;
    List<KursEintrag> kursliste;
    
    
    public KursLoeschen(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/KursAnmeldung/webapi/kurs/list");
        kursliste = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<KursEintrag>>() {});
    }
    
    public List<KursEintrag> getKursliste() {
        return kursliste;
    }

    public void setKursliste(List<KursEintrag> kursliste) {
        this.kursliste = kursliste;
    }

    public int getChosenKurs() {
        return chosenKurs;
    }

    public void setChosenKurs(int chosenKurs) {
        this.chosenKurs = chosenKurs;
    }
    
    
    
        public String kursLoeschen(){
        
         Client client = ClientBuilder.newClient();
        WebTarget baseLink = client.target("http://localhost:8080/KursAnmeldung/webapi/");
        WebTarget authLink = baseLink.path("kurs/").path("{kursID}");
        
        
        
        Response res = authLink
                .resolveTemplate("kursID", this.chosenKurs) 
                .request()
                .delete();
        
        return "/StartseiteKursleiter.xhtml";
        
    }
    
}
