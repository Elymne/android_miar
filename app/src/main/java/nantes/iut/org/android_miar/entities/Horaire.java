package nantes.iut.org.android_miar.entities;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Horaire {

    private String recordid;
    private String jour;
    private LocalTime heure_debut;
    private LocalTime heure_fin;
    private LocalDate date_debut;
    private LocalDate date_fin;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Horaire(String recordid, String jour, String heure_debut, String heure_fin, String date_debut, String date_fin) throws ParseException {
        this.recordid = recordid;
        this.jour = jour;
        this.heure_debut = LocalTime.parse(heure_debut);
        this.heure_fin = LocalTime.parse(heure_fin);
        this.date_debut = LocalDate.parse(date_debut);
        this.date_fin = LocalDate.parse(date_fin);
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

    public LocalTime getHeure_debut() {
        return heure_debut;
    }

    public LocalTime getHeure_fin() {
        return heure_fin;
    }

    public LocalDate getDate_debut() {
        return date_debut;
    }

    public LocalDate getDate_fin() {
        return date_fin;
    }
}
