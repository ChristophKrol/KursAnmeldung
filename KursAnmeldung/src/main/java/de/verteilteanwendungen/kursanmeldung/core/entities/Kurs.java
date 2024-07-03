/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.core.entities;

import de.verteilteanwendungen.kursanmeldung.core.entities.enumeration.Rhythmus;
import java.util.Date;

/**
 *
 * @author christophkrol
 */
public class Kurs {
    private int kursID;
    private String kursname;
    private Date startdatum;
    private int anzahlTermine;
    private Rhythmus rhythmus;
    private int kursleiterID;

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

    public Date getStartdatum() {
        return startdatum;
    }

    public void setStartdatum(Date startdatum) {
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

    public int getKursleiterID() {
        return kursleiterID;
    }

    public void setKursleiterID(int kursleiterID) {
        this.kursleiterID = kursleiterID;
    }
    
    
    
}


