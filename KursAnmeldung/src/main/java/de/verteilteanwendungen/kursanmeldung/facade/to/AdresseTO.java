/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.verteilteanwendungen.kursanmeldung.facade.to;

/**
 *
 * @author christophkrol
 */
public record AdresseTO(
    int id,
    String strasse,
    String hausnummer,
    String plz,
    String ort
        ) 
{
    
}
