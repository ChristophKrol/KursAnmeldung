/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.dataaccess.dao;

import de.verteilteanwendungen.kursanmeldung.core.entities.datatypes.Adresse;
import de.verteilteanwendungen.kursanmeldung.dataaccess.BenutzerEntity;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author christophkrol
 */
@Singleton
public class AdresseDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    
     public void anlegen(Adresse adresse){
        em.persist(adresse);
    }
    
    public void loeschen(Adresse adresse){
        em.remove(adresse);
    }
    
    public void suchen(Adresse adresse){
        //em.find(Map<>, be) googlen nach Entitymanager.find()
    }
    
}
