/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.core.entities.datatypes;

import de.verteilteanwendungen.kursanmeldung.core.entities.Benutzer;
import de.verteilteanwendungen.kursanmeldung.dataaccess.BenutzerEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

/**
 *
 * @author christophkrol
 */
@Entity
public class Adresse {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_adressID")
    private int adressID;
    private String strasse;
    private String hausnummer;
    private String plz;
    private String ort;
    
    @OneToOne(mappedBy = "adresse")
    private BenutzerEntity benutzer;
    
    public Adresse(){}

    public Adresse(String strasse, String hausnummer, String plz, String ort) {
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
    }
    
    public Adresse(int id, String strasse, String hausnummer, String plz, String ort) {
        this.adressID = id;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
    }

    public int getAdressID() {
        return adressID;
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
    
    
    
}
