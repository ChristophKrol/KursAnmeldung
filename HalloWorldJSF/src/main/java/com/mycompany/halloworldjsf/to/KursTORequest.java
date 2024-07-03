/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.halloworldjsf.to;

import com.mycompany.halloworldjsf.enumeration.Rhythmus;
import java.util.List;

/**
 *
 * @author christophkrol
 */
public record KursTORequest(
    int kursID,
    String kursname,
    String startdatum,
    int anzahlTermine,
    String rhythmus
){}
