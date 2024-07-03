/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.halloworldjsf.resources;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import java.io.Serializable;

/**
 *
 * @author christophkrol
 */
@Named
@SessionScoped
public class StartseiteKursleiter implements Serializable {
    
    KursEintrag ausgewählterKurs;
    
    int chosenKurs;

    public int getChosenKurs() {
        return chosenKurs;
    }

    public void setChosenKurs(int chosenKurs) {
        this.chosenKurs = chosenKurs;
    }
    
    

    public KursEintrag getAusgewählterKurs() {
        return ausgewählterKurs;
    }

    public void setAusgewählterKurs(KursEintrag ausgewählterKurs) {
        this.ausgewählterKurs = ausgewählterKurs;
    }
    
    
    
    // Öffne KursDetails-Seite und übergebe den Kurs
    public String getKursdetails(KursEintrag kurs){
        this.setAusgewählterKurs(kurs);
        return "/Kursdetails.xhtml";
        
        
    }
    
    
    public String teilnehmerliste(){
        
        return "/KurseTeilnehmer.xhtml";
    }
    
     public String kursLoeschen(){
        
           
        return "/KursLöschen.xhtml";
    }
    
    

    public String kursAendern(){
        return "/KursÄndernAuswahl.xhtml";
    }
    
}
