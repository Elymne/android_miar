package nantes.iut.org.android_miar.entities;

public class Horaire {

    private String recordid;
    private String jour;
    private String heure_debut;
    private String heure_fin;
    private String date_debut;
    private String date_fin;

    public Horaire(String recordid, String jour, String heure_debut, String heure_fin, String date_debut, String date_fin) {
        this.recordid = recordid;
        this.jour = jour;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public String getRecordid() {
        return recordid;
    }

    public String getJour() {
        return jour;
    }

    public String getHeure_debut() {
        return heure_debut;
    }

    public String getHeure_fin() {
        return heure_fin;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }
}
