package nantes.iut.org.android_miar.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Horaire {

    private String recordid;
    private String jour;
    private String heure_debut;
    private String heure_fin;
    private Date date_debut;
    private Date date_fin;

    public Horaire(String recordid, String jour, String heure_debut, String heure_fin, String date_debut, String date_fin) throws ParseException {
        this.recordid = recordid;
        this.jour = jour;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.date_debut = new SimpleDateFormat("yyyy/MM/dd").parse(date_debut);
        this.date_fin = new SimpleDateFormat("yyyy/MM/dd").parse(date_fin);
    }

    public String getRecordid() {
        return recordid;
    }

    public String getJour() {
        return jour;
    }

    public int getJourInt(){
        int result = 0;
        if(this.jour == "dimanche")
            result = 1;
        if(this.jour == "lundi")
            result = 2;
        if(this.jour == "mardi")
            result = 3;
        if(this.jour == "mercredi")
            result = 4;
        if(this.jour == "jeudi")
            result = 5;
        if(this.jour == "vendredi")
            result = 6;
        if(this.jour == "samedi")
            result = 7;
        return result;
    }

    public String getHeure_debut() {
        return heure_debut;
    }

    public String getHeure_fin() {
        return heure_fin;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }
}
