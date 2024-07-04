/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.halloworldjsf.resources;
import com.mycompany.halloworldjsf.to.BenutzerTO;
import com.mycompany.halloworldjsf.to.KursTO;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author christophkrol
 */
@SessionScoped
@Named
public class KurseTeilnehmerReq implements Serializable{
     private static final long serialVersionUID = -211073631543658808L;
     final Logger log = Logger.getLogger(getClass().getName());
    
    List<KursTO> kursliste;
    
    int chosenkurs;
    
    List<TeilnehmerEintrag> teilnehmerListe;

    public List<KursTO> getKursliste() {
        return kursliste;
    }

    public void setKursliste(List<KursTO> kursliste) {
        this.kursliste = kursliste;
    }

    public int getChosenkurs() {
        return chosenkurs;
    }

    public void setChosenkurs(int chosenkurs) {
        this.chosenkurs = chosenkurs;
    }

    public List<TeilnehmerEintrag> getTeilnehmerListe() {
        return teilnehmerListe;
    }

    public void setTeilnehmerListe(List<TeilnehmerEintrag> teilnehmerListe) {
        this.teilnehmerListe = teilnehmerListe;
    }
    
    
    
    
    
    
    
    
        public KurseTeilnehmerReq(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/KursAnmeldung/webapi/kurs/list");
        kursliste = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<KursTO>>() {});
    }
        
        public String teilnehmerlisteAnfordern(){
            this.setChosenkurs(this.chosenkurs);
        Client client = ClientBuilder.newClient();
        WebTarget link = client.target("http://localhost:8080/KursAnmeldung/webapi/kurs/");
        WebTarget target = link.path("{kursID}/list");
        this.setTeilnehmerListe(
                target.resolveTemplate("kursID", this.getChosenkurs()).request(MediaType.APPLICATION_JSON).get(new GenericType<List<TeilnehmerEintrag>>() {})
        );
        log.info("---TeilnehmerListe: ---");
        log.info(this.getTeilnehmerListe().toString());
        
        return "/TeilnehmerlisteAnzeigen.xhtml";
        
     
    }
    
}
