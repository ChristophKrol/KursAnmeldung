/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.dataaccess.dao;

import de.verteilteanwendungen.kursanmeldung.dataaccess.BenutzerEntity;
import de.verteilteanwendungen.kursanmeldung.facade.to.AnmeldungTO;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

/**
 *
 * @author christophkrol
 */
@Singleton
public class BenutzerDAO  {
    
    @PersistenceContext
    private EntityManager em;
    
    
    public void anlegen(BenutzerEntity be){
        em.persist(be);
    }
    
    public void loeschen(BenutzerEntity be){
        em.remove(be);
    }
    
    public BenutzerEntity suchen(int id){
       return em.find(BenutzerEntity.class, id);
       
    }
    
    public List<BenutzerEntity> listBenutzer(){
        Query query = em.createNativeQuery("SELECT  * FROM BENUTZERENTITY", BenutzerEntity.class);
        return query.getResultList();
    }
    
    public AnmeldungTO anmelden(String username, String password){
        TypedQuery<BenutzerEntity> query = em.createQuery(
            "SELECT e FROM BenutzerEntity e WHERE e.benutzername = :username AND e.passwort = :password", 
            BenutzerEntity.class
        );
        query.setParameter("username", username);
        query.setParameter("password", password);
        
        
        if(query.getResultList().isEmpty()){
            return new AnmeldungTO(-1, false);
        }
        else{ 
            return new AnmeldungTO(
                    query.getSingleResult().getId(), 
                    query.getSingleResult().getIstKursleiter()
            ); 
        }
    }
    
}
