/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.halloworldjsf.resources;

import com.mycompany.halloworldjsf.to.AdresseTO;

/**
 *
 * @author christophkrol
 */
public class TeilnehmerEintrag {
    
        AdresseTO adresse;
        String bankverbindung;
        String benutzername;
        int id;
        boolean istKursleiter;
        String nachname;
        String passwort;
        String vorname;

    public AdresseTO getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseTO adresse) {
        this.adresse = adresse;
    }

    public String getBankverbindung() {
        return bankverbindung;
    }

    public void setBankverbindung(String bankverbindung) {
        this.bankverbindung = bankverbindung;
    }

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIstKursleiter() {
        return istKursleiter;
    }

    public void setIstKursleiter(boolean istKursleiter) {
        this.istKursleiter = istKursleiter;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
        
        
        
        
    
    
    
}
