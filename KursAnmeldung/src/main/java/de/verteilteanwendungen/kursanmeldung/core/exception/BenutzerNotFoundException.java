/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.core.exception;

/**
 *
 * @author christophkrol
 */
public class BenutzerNotFoundException extends Exception{
    public BenutzerNotFoundException(int userID){
        super("Benutzer with ID " + userID + " not found");
    }
    
}
