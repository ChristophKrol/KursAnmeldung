/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.halloworldjsf.resources;


import com.mycompany.halloworldjsf.to.AnmeldungTO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 *
 * @author lenamuehren
 */
@Named
@SessionScoped  
public class AnmeldungReq implements Serializable{
    private static final long serialVersionUID = -211073631543658809L;
    final Logger log = Logger.getLogger(getClass().getName());
    String passwort;
    String benutzername;
    int benutzerID;
    boolean istKursleiter;

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public int getBenutzerID() {
        return benutzerID;
    }

    public void setBenutzerID(int benutzerID) {
        this.benutzerID = benutzerID;
    }

    public boolean isIstKursleiter() {
        return istKursleiter;
    }

    public void setIstKursleiter(boolean istKursleiter) {
        this.istKursleiter = istKursleiter;
    }
    
    

    
    

    public String Registrierung () {
        this.setBenutzername(this.getBenutzername());
        this.setPasswort(this.getPasswort());
        return "/Registriere.xhtml";
    
    }
    
    
    public String anmelden(){
        
        this.setBenutzername(this.getBenutzername());
        this.setPasswort(this.getPasswort());
        
        Client client = ClientBuilder.newClient();
        WebTarget baseLink = client.target("http://localhost:8080/KursAnmeldung/webapi/");
        WebTarget authLink = baseLink.path("login/").path("{benutzername}/pwd=").path("{passwort}");
        
        
        
        Response res = authLink
                .resolveTemplate("benutzername", this.benutzername)
                .resolveTemplate("passwort", this.passwort)
                .request()
                .get();
        log.info("RESPONSE-------------------");
        log.info(res.getStatusInfo().toEnum().toString());
  
        log.info("RESPONSE-------------------END");
        
        
        if(res.getStatusInfo().toEnum() == Response.Status.OK ){
            AnmeldungTO responseEntity = res.readEntity(AnmeldungTO.class);
            this.setBenutzerID(responseEntity.benutzerID());
            this.setIstKursleiter(responseEntity.istKursleiter());
            return "/StartseiteTeilnehmer.xhtml";
        }
        else{ 
            // Fehlermeldung rausgeben
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login nicht erfolgreich!", "Falscher Benutzername oder Passwort"));
            return "/AnmeldungApp.xhtml";
        }
             
      
        
    }
    
}
