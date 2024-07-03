/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.facade.to;



/**
 *
 * @author christophkrol
 */
public record BenutzerTO (
    int id,
    String benutzername,
    String passwort,
    String vorname,
    String nachname,
    AdresseTO adresse,
    boolean istKursleiter,
    String bankverbindung
    
        ){}
