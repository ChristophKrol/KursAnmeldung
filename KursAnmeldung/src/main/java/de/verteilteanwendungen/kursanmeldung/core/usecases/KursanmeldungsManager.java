/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.core.usecases;

import de.verteilteanwendungen.kursanmeldung.dataaccess.KursEntity;
import de.verteilteanwendungen.kursanmeldung.dataaccess.dao.KursDAO;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author christophkrol
 */
@Stateless
public class KursanmeldungsManager {
    @EJB
    KursDAO kdao;
    
    public boolean kursAnmelden(int kursID, int benutzerID){
        KursEntity kurs = kdao.suchen(kursID);
        Date d = new Date();
        Timestamp now = new Timestamp(d.getTime());
        if(kurs.getStartdatum().before(now)){
            return false;
            
        }else{
            kdao.kursAnmelden(kursID, benutzerID);
            return true;
        }
        
    }
    
    
    public boolean kursAbmelden(int kursID, int benurtzerID){
        Date d = new Date();
        Timestamp now = new Timestamp(d.getTime());
        KursEntity kurs = kdao.suchen(kursID);
        if(kurs.getStartdatum().before(now)){
            return false;
        }else{
            kdao.kursAbmelden(kursID, benurtzerID);
            return true;
        }
        
        
    }
    
}
