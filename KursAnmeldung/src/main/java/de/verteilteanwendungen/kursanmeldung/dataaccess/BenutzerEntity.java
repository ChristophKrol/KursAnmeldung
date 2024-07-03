/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.dataaccess;

import de.verteilteanwendungen.kursanmeldung.core.entities.Benutzer;
import de.verteilteanwendungen.kursanmeldung.core.entities.datatypes.Adresse;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;


/**
 *
 * @author christophkrol
 */
@Entity
public class BenutzerEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_benutzerID")
    @Column(name = "benutzerID")
    private int id;
    private String benutzername;
    private String passwort;
    
    private String vorname;
    
    @Column(name = "name")
    private String nachname;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adressID")
    private Adresse adresse;
    
    private boolean istKursleiter;
    private String bankverbindung;
    
    
    public BenutzerEntity(){}

    public BenutzerEntity(int id, String benutzername, String passwort, String vorname, String nachname, Adresse adresse, String bankverbindung, boolean istKursleiter) {
        this.id = id;
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.bankverbindung = bankverbindung;
        this.istKursleiter = istKursleiter;
    }
    
        public BenutzerEntity( String benutzername, String passwort, String vorname, String nachname, Adresse adresse, String bankverbindung, boolean istKursleiter) {

        this.benutzername = benutzername;
        this.passwort = passwort;
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.bankverbindung = bankverbindung;
        this.istKursleiter = istKursleiter;
    }
    
    public BenutzerEntity(Benutzer benutzer){
        this.id = benutzer.getId();
        this.benutzername = benutzer.getBenutzername();
        this.passwort = benutzer.getPasswort();
        this.vorname = benutzer.getVorname();
        this.nachname = benutzer.getNachname();
        this.adresse = benutzer.getAdresse();
        this.bankverbindung = benutzer.getBankverbindung();
        this.istKursleiter = benutzer.getIstKursleiter();
        
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getBankverbindung() {
        return bankverbindung;
    }

    public void setBankverbindung(String bankverbindung) {
        this.bankverbindung = bankverbindung;
    }

    public boolean getIstKursleiter() {
        return istKursleiter;
    }

    public void setKursleiter(boolean istKursleiter) {
        this.istKursleiter = istKursleiter;
    }
    
    

   
    
    
}
