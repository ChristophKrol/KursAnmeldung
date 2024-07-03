/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.core.usecases;

import de.verteilteanwendungen.kursanmeldung.dataaccess.dao.KursDAO;
import de.verteilteanwendungen.kursanmeldung.facade.to.AdresseTO;
import de.verteilteanwendungen.kursanmeldung.facade.to.BenutzerTO;
import de.verteilteanwendungen.kursanmeldung.facade.to.KursTO;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author christophkrol
 */
@Stateless
public class TeilnehmerlisteManager {
    
    @EJB
    private KursDAO kdao;
    
    public List<BenutzerTO> teilnehmerlisteAnzeigen(int kursID){
        return kdao.listTeilnehmer(kursID).stream()
                 .map(b -> new BenutzerTO(
                                b.getId(), 
                                b.getBenutzername(), 
                                "",
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
                                ""
                        )).collect(Collectors.toList());

    }
    
    
    
}
