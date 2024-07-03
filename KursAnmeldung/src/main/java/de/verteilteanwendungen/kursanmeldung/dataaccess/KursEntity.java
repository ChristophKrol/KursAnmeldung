/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.dataaccess;

import de.verteilteanwendungen.kursanmeldung.core.entities.enumeration.Rhythmus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author christophkrol
 */
@Entity
public class KursEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_kursID")
    private int kursID;
    private String kursname;
    private Timestamp startdatum;
    private int anzahlTermine;
    
    @Enumerated(EnumType.STRING)
    private Rhythmus rhythmus;
    
    @ManyToMany 
    @JoinTable( 
            name = "Kursteilnahme",
            joinColumns = @JoinColumn(       
                    name = "kursID",       
                    referencedColumnName="kursID"),     
            inverseJoinColumns = @JoinColumn(       
                    name = "benutzerID",       
                    referencedColumnName="benutzerID")
    )
    private Set<BenutzerEntity> teilnehmer;
    
    public KursEntity(){}

    public KursEntity(int kursID, String kursname, Timestamp startdatum, int anzahlTermine, Rhythmus rhythmus) {
        this.kursID = kursID;
        this.kursname = kursname;
        this.startdatum = startdatum;
        this.anzahlTermine = anzahlTermine;
        this.rhythmus = rhythmus;
    }
    
    
    

    public int getKursID() {
        return kursID;
    }

    public void setKursID(int kursID) {
        this.kursID = kursID;
    }

    public String getKursname() {
        return kursname;
    }

    public void setKursname(String kursname) {
        this.kursname = kursname;
    }

    public Timestamp getStartdatum() {
        return startdatum;
    }

    public void setStartdatum(Timestamp startdatum) {
        this.startdatum = startdatum;
    }

    public int getAnzahlTermine() {
        return anzahlTermine;
    }

    public void setAnzahlTermine(int anzahlTermine) {
        this.anzahlTermine = anzahlTermine;
    }

    public Rhythmus getRhythmus() {
        return rhythmus;
    }

    public void setRhythmus(Rhythmus rhythmus) {
        this.rhythmus = rhythmus;
    }

    public Set<BenutzerEntity> getTeilnehmer() {
        return teilnehmer;
    }

    public void setTeilnehmer(Set<BenutzerEntity> teilnehmer) {
        this.teilnehmer = teilnehmer;
    }

    
    
}
