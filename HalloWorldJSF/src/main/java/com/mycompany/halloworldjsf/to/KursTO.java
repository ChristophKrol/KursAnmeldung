/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.halloworldjsf.to;

import com.mycompany.halloworldjsf.enumeration.Rhythmus;
import java.util.List;

/**
 *
 * @author christophkrol
 */
public record KursTO(
    int kursID,
    String kursname,
    String startdatum,
    int anzahlTermine,
    Rhythmus rhythmus,
    List<Integer> teilnehmer
){

    public int getKursID() {
        return kursID;
    }

    public String getKursname() {
        return kursname;
    }

    public String getStartdatum() {
        return startdatum;
    }

    public int getAnzahlTermine() {
        return anzahlTermine;
    }

    public Rhythmus getRhythmus() {
        return rhythmus;
    }

    public List<Integer> getTeilnehmer() {
        return teilnehmer;
    }
    
    


}
