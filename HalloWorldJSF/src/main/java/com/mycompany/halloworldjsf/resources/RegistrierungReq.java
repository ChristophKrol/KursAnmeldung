/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.halloworldjsf.resources;

import com.mycompany.halloworldjsf.to.AdresseTO;
import com.mycompany.halloworldjsf.to.BenutzerTO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.Serializable;

/**
 *
 * @author christophkrol
 */
@Named
@RequestScoped 
public class RegistrierungReq implements Serializable{
    private static final long serialVersionUID = -211073631143658809L;
    
    String benutzername;
    String passwort;
    String nachname;
    String vorname;
    String bankverbindung;
    boolean istKursleiter;
    String strasse;
    String hausnummer;
    String plz;
    String ort;

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getBankverbindung() {
        return bankverbindung;
    }

    public void setBankverbindung(String bankverbindung) {
        this.bankverbindung = bankverbindung;
    }

    public boolean isIstKursleiter() {
        return istKursleiter;
    }

    public void setIstKursleiter(boolean istKursleiter) {
        this.istKursleiter = istKursleiter;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
    
    
    
    /*
    public String registrieren(){
        return "/Hauptmenu.xhtml";
    }
*/
    
    public String registrieren(){
        AdresseTO adresseTO = new AdresseTO(strasse, hausnummer, plz, ort);
        BenutzerTO benutzerTO = new BenutzerTO(benutzername, passwort, vorname, nachname, adresseTO, istKursleiter, bankverbindung);
    
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/KursAnmeldung/webapi/benutzer/create");
        
        Response res = target.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(benutzerTO, MediaType.APPLICATION_JSON), Response.class);
        if(res.getStatusInfo().toEnum() == Response.Status.CREATED){
            return "/AnmeldungApp.xhtml";
        
        }else{
             // Fehlermeldung rausgeben
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registrierung nicht erfolgreich!", ""));
            return "/Registriere.xhtml";
        
        }
        
        
    }
   
    
}
