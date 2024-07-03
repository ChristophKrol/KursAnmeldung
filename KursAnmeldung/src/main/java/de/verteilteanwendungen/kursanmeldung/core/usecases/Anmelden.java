/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.core.usecases;

import de.verteilteanwendungen.kursanmeldung.dataaccess.dao.BenutzerDAO;
import de.verteilteanwendungen.kursanmeldung.facade.to.AnmeldungTO;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

/**
 *
 * @author christophkrol
 */
@Stateless
public class Anmelden {
    
    @EJB
    private BenutzerDAO bdao;
    
    public AnmeldungTO anmelden(String benutzername, String passwort){
        return bdao.anmelden(benutzername, passwort);
    }
    
}
