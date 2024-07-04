/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.core.usecases;

import de.verteilteanwendungen.kursanmeldung.core.exception.BenutzerNotFoundException;
import de.verteilteanwendungen.kursanmeldung.core.entities.datatypes.Adresse;
import de.verteilteanwendungen.kursanmeldung.dataaccess.BenutzerEntity;

import de.verteilteanwendungen.kursanmeldung.dataaccess.dao.AdresseDAO;
import de.verteilteanwendungen.kursanmeldung.dataaccess.dao.BenutzerDAO;
import de.verteilteanwendungen.kursanmeldung.facade.to.AdresseTO;
import de.verteilteanwendungen.kursanmeldung.facade.to.BenutzerTO;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author christophkrol
 */
@Stateless
public class BenutzerManager{
    
    @EJB
    private BenutzerDAO bdao;
    
    @EJB 
    private AdresseDAO adao;


    public boolean benutzerAnlegen(int id, String benutzername, String passwort, String vorname, 
            String nachname, AdresseTO adresse, String bankverbindung, boolean istKursleiter) {
        
        //Adresse DAO
        //neue adresse anlegen
        Adresse benutzerAdresse = new Adresse(adresse.strasse(), adresse.hausnummer(), adresse.plz(), adresse.ort());
        adao.anlegen(benutzerAdresse);
       
        bdao.anlegen(new BenutzerEntity(benutzername, passwort, vorname,
        nachname, benutzerAdresse,
                bankverbindung, istKursleiter));
        return true;
    }
    
    /*
    public boolean adresseAnlegen(int id, String strasse, String hausnummer, String plz, String ort ){
        Adresse adresse = new Adresse(id, strasse, hausnummer, plz, ort);
        adao.anlegen(adresse);
        return true;
    }
*/

 
    public boolean benutzerEntfernen(int id) {
        BenutzerEntity deleteBenutzer = bdao.suchen(id);
        if(deleteBenutzer == null){
            return false;
        }
        else{
            bdao.loeschen(deleteBenutzer);
            return true;
        }
        
       
    }
    
    
    public List<BenutzerTO> listBenutzer(){
        List <BenutzerTO> benutzerList = 
                bdao.listBenutzer().stream()
                        .map(b -> new BenutzerTO(
                                b.getId(), 
                                b.getBenutzername(), 
                                b.getPasswort(), 
                                b.getVorname(), 
                                b.getNachname(),
                                new AdresseTO(
                                        b.getAdresse().getAdressID(),
                                        b.getAdresse().getStrasse(),
                                        b.getAdresse().getHausnummer(),
                                        b.getAdresse().getPlz(),
                                        b.getAdresse().getOrt()
                                ),
                                b.getIstKursleiter(),
                                b.getBankverbindung()
                        )).collect(Collectors.toList());
        
       return benutzerList;
                
    }
    
    public BenutzerTO benutzerSuchen(int id) throws BenutzerNotFoundException{
        BenutzerEntity foundBenutzer = bdao.suchen(id);
        if(foundBenutzer == null){
            throw new BenutzerNotFoundException(id);
        }
        return new BenutzerTO(
                foundBenutzer.getId(),
                foundBenutzer.getBenutzername(),
                foundBenutzer.getPasswort(),
                foundBenutzer.getVorname(),
                foundBenutzer.getNachname(),
                new AdresseTO(
                        foundBenutzer.getAdresse().getAdressID(),
                        foundBenutzer.getAdresse().getStrasse(),
                        foundBenutzer.getAdresse().getHausnummer(),
                        foundBenutzer.getAdresse().getPlz(),
                        foundBenutzer.getAdresse().getOrt()
                ),
                foundBenutzer.getIstKursleiter(),
                foundBenutzer.getBankverbindung()
        );
    }
    
    
    
    
    
    
    
    
}
