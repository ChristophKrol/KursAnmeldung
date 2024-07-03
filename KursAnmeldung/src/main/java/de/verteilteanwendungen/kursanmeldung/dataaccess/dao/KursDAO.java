/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.dataaccess.dao;

import de.verteilteanwendungen.kursanmeldung.dataaccess.BenutzerEntity;
import de.verteilteanwendungen.kursanmeldung.dataaccess.KursEntity;
import de.verteilteanwendungen.kursanmeldung.facade.to.BenutzerTO;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author christophkrol
 */
@Singleton
public class KursDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    @EJB
    private BenutzerDAO bdao;
    
    
    public void anlegen(KursEntity ke){
        em.persist(ke);
    }
    
    public void loeschen(KursEntity ke){
        em.remove(ke);
    }
    
    public KursEntity suchen(int id){
       return em.find(KursEntity.class, id);
       
    }
    
    public boolean aendern(KursEntity ke){
        KursEntity updateKurs = em.find(KursEntity.class, ke.getKursID());
        if(updateKurs == null){
            return false;
        }
        else{
            updateKurs.setKursname(ke.getKursname()) ;
            updateKurs.setRhythmus(ke.getRhythmus());
            updateKurs.setStartdatum(ke.getStartdatum());
            updateKurs.setAnzahlTermine(ke.getAnzahlTermine());
            em.persist(updateKurs);
            return true;
        }
          
        
    }
    
    
    public void kursAnmelden(int kursID, int benutzerID){
        KursEntity anmeldungKurs = em.find(KursEntity.class, kursID);
        BenutzerEntity anmelder = bdao.suchen(benutzerID);
        anmeldungKurs.getTeilnehmer().add(anmelder);
        em.persist(anmeldungKurs);
        
    }
    
        public void kursAbmelden(int kursID, int benutzerID){
        KursEntity anmeldungKurs = em.find(KursEntity.class, kursID);
        BenutzerEntity anmelder = bdao.suchen(benutzerID);
        anmeldungKurs.getTeilnehmer().remove(anmelder);
        em.persist(anmeldungKurs);
        
    }
    
    public List<KursEntity> listKurse(){
        Query query = em.createNativeQuery("SELECT  * FROM KURSENTITY", KursEntity.class);
        return query.getResultList();
    }
    
    public List<BenutzerEntity> listTeilnehmer(int kursID){
        KursEntity kurs = em.find(KursEntity.class, kursID);
        return kurs.getTeilnehmer().stream().collect(Collectors.toList());
    }
    
    
    
}
