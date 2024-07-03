/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.facade.to;

import de.verteilteanwendungen.kursanmeldung.core.entities.enumeration.Rhythmus;
import de.verteilteanwendungen.kursanmeldung.dataaccess.BenutzerEntity;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

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
){}
