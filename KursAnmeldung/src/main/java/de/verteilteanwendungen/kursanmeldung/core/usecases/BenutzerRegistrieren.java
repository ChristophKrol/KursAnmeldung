/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.core.usecases;

import de.verteilteanwendungen.kursanmeldung.facade.to.AdresseTO;
import jakarta.ejb.EJB;

/**
 *
 * @author christophkrol
 */
public class BenutzerRegistrieren {
    @EJB
    private BenutzerManager benutzerManager;
    
    public boolean registrieren(int id, String benutzername, String passwort, String vorname, 
            String nachname, AdresseTO adresse, String bankverbindung, 
            boolean istKursleiter){
        
      return   benutzerManager
                .benutzerAnlegen(id, benutzername, passwort, vorname, nachname, 
                        adresse, bankverbindung, istKursleiter);
    }
    
}
