package nantes.iut.org.android_miar.entities;

import java.util.Calendar;

public class Horaire {

    private String recordid;
    private String jour;
    private Calendar heure_debut;
    private Calendar heure_fin;
    private Calendar date_debut;
    private Calendar date_fin;

    public Horaire(String recordid, String jour, String heure_debut, String heure_fin, String date_debut, String date_fin){
        this.recordid = recordid;
        this.jour = jour;
        this.heure_debut = Calendar.getInstance();
        this.heure_debut.set(Calendar.YEAR,Calendar.MONTH,Calendar.DATE, parseHour(heure_debut), parseMinute(heure_debut));
        this.heure_fin = Calendar.getInstance();
        this.heure_fin.set(Calendar.YEAR,Calendar.MONTH,Calendar.DATE, parseHour(heure_debut), parseMinute(heure_debut));
        this.date_debut = Calendar.getInstance();
        this.date_debut.set(parseYear(date_debut), parseMonth(date_debut), parseDay(date_debut));
        this.date_fin = Calendar.getInstance();
        this.date_fin.set(parseYear(date_fin), parseMonth(date_fin), parseDay(date_fin));
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

    private Integer parseYear(String stringDate){
        String timeParse[] = stringDate.split("-");
        Integer result = 0;
        if(stringDate != "PAS DE DONNEES")
            result = Integer.valueOf(timeParse[0]);

        return result;
    }

    private Integer parseMonth(String stringDate){
        String timeParse[] = stringDate.split("-");
        Integer result = 0;
        if(stringDate != "PAS DE DONNEES")
            result = Integer.valueOf(timeParse[0]);

        return result;
    }

    private Integer parseDay(String stringDate){
        String timeParse[] = stringDate.split("-");
        Integer result = 0;
        if(stringDate != "PAS DE DONNEES")
            result = Integer.valueOf(timeParse[0]);

        return result;
    }

    private Integer parseHour(String stringDate){
        String timeParse[] = stringDate.split(":");
        Integer result = 0;
        if(stringDate != "PAS DE DONNEES")
            result = Integer.valueOf(timeParse[0]);

        return result;
    }

    private Integer parseMinute(String stringDate){
        String timeParse[] = stringDate.split(":");
        Integer result = 0;
        if(stringDate != "PAS DE DONNEES")
            result = Integer.valueOf(timeParse[0]);

        return result;
    }

    public Calendar getHeure_debut() {
        return heure_debut;
    }

    public Calendar getHeure_fin() {
        return heure_fin;
    }

    public Calendar getDate_debut() {
        return date_debut;
    }

    public Calendar getDate_fin() {
        return date_fin;
    }
}
