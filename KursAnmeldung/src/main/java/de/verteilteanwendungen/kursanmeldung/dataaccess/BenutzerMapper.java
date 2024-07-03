/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.dataaccess;

import de.verteilteanwendungen.kursanmeldung.core.entities.datatypes.Adresse;
import de.verteilteanwendungen.kursanmeldung.facade.to.AdresseTO;
import de.verteilteanwendungen.kursanmeldung.facade.to.BenutzerTO;
import java.util.function.Function;

/**
 *
 * @author christophkrol
 */
public class BenutzerMapper implements Function<BenutzerEntity, BenutzerTO>{
    
    public BenutzerMapper(){}
    
    private  AdresseTO buildAdressTO(Adresse adresse){
        return new AdresseTO(
                adresse.getAdressID(),
                adresse.getStrasse(),
                adresse.getHausnummer(),
                adresse.getPlz(),
                adresse.getOrt()
        );
    }
    

    @Override
    public BenutzerTO apply(BenutzerEntity benutzer) {
        return new BenutzerTO(
                benutzer.getId(),
                benutzer.getBenutzername(),
                benutzer.getPasswort(),
                benutzer.getVorname(),
                benutzer.getNachname(),
                buildAdressTO(benutzer.getAdresse()),
                benutzer.getIstKursleiter(),
                benutzer.getBankverbindung()
        
        );
        
    }
    
}
