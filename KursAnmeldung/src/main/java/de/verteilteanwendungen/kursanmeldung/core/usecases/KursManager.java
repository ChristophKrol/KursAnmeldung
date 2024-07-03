/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.core.usecases;

import de.verteilteanwendungen.kursanmeldung.core.entities.enumeration.Rhythmus;
import de.verteilteanwendungen.kursanmeldung.dataaccess.KursEntity;
import de.verteilteanwendungen.kursanmeldung.dataaccess.dao.KursDAO;
import de.verteilteanwendungen.kursanmeldung.facade.to.BenutzerTO;
import de.verteilteanwendungen.kursanmeldung.facade.to.KursTO;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author christophkrol
 */
@Stateless
public class KursManager {
    
    @EJB
    private KursDAO kdao;
    
    public boolean kursAnlegen(
        int kursID,
        String kursname,
        Timestamp startdatum,
        int anzahlTermine,
        Rhythmus rhythmus
    ){
        KursEntity kurs = new KursEntity(
            kursID,
            kursname,
            startdatum,
            anzahlTermine,
            rhythmus
        );
        
        kdao.anlegen(kurs);
        return true;
    }
    
    public boolean kursEntfernen(int id){
        KursEntity deleteKurs = kdao.suchen(id);
        if(deleteKurs == null){
            return false;
        }
        else{
            kdao.loeschen(deleteKurs);
            return true;
        }
    }
    
    public boolean kursAendern(KursEntity kursUpdate){
        return kdao.aendern(kursUpdate);
    }
    
    public KursTO kursSuchen(int kursID){
        KursEntity result = kdao.suchen(kursID);
        if(result != null){
            KursTO kurs = new KursTO(
                    result.getKursID(), 
                    result.getKursname(), 
                    result.getStartdatum().toString(),
                    result.getAnzahlTermine(),
                    result.getRhythmus(),
                    null
            );
            return kurs;
        }
        else{
            return null;
        }
    }
    
    
    public List<KursTO> listKurse(){
        return kdao.listKurse().stream()
                .map(k -> new KursTO(
                        k.getKursID(),
                        k.getKursname(),
                        k.getStartdatum().toString(),
                        k.getAnzahlTermine(),
                        k.getRhythmus(),
                        k.getTeilnehmer().stream().map( t -> t.getId()).collect(Collectors.toList())
                        
                )
                ).collect(Collectors.toList());

    }

    
    
    
}
