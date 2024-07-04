/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.halloworldjsf.resources;

import com.mycompany.halloworldjsf.enumeration.Rhythmus;
import java.util.List;

/**
 *
 * @author christophkrol
 */
public class KursEintrag{
    int kursID;
    String kursname;
    String startdatum;
    int anzahlTermine;
    String rhythmus;
    List<Integer> teilnehmer;

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

    public String getStartdatum() {
        return startdatum;
    }

    public void setStartdatum(String startdatum) {
        this.startdatum = startdatum;
    }

    public int getAnzahlTermine() {
        return anzahlTermine;
    }

    public void setAnzahlTermine(int anzahlTermine) {
        this.anzahlTermine = anzahlTermine;
    }

    public String getRhytmus() {
        return rhythmus;
    }

    public void setRhytmus(String rhytmus) {
        this.rhythmus = rhytmus;
    }

    public List<Integer> getTeilnehmer() {
        return teilnehmer;
    }

    public void setTeilnehmer(List<Integer> teilnehmer) {
        this.teilnehmer = teilnehmer;
    }

    public KursEintrag(int kursID, String kursname, String startdatum, int anzahlTermine, String rhythmus) {
        this.kursID = kursID;
        this.kursname = kursname;
        this.startdatum = startdatum;
        this.anzahlTermine = anzahlTermine;
        this.rhythmus = rhythmus;
    }
    
    
    public KursEintrag(){}
    
    
    
    
    
    
    
}

   
