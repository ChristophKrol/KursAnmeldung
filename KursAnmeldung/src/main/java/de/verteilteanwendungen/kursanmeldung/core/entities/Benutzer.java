/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.core.entities;

import de.verteilteanwendungen.kursanmeldung.core.entities.datatypes.Adresse;


/**
 *
 * @author christophkrol
 */
public class Benutzer {
    
    private int id;
    private String benutzername;
    private String passwort;
    private String vorname;
    private String nachname;
    private Adresse adresse;
    private boolean istKursleiter;
    private String bankverbindung;
    
    

    public int getId() {
        return id;
    }

    public String getBenutzername() {
        return benutzername;
    }

    public String getPasswort() {
        return passwort;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public String getBankverbindung() {
        return bankverbindung;
    }

    public boolean getIstKursleiter() {
        return this.istKursleiter;
    }
    
    
    
}
