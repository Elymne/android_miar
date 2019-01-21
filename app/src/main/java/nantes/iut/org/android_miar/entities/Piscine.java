package nantes.iut.org.android_miar.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Piscine implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Piscine createFromParcel(Parcel in) {
            return new Piscine(in);
        }

        public Piscine[] newArray(int size) {
            return new Piscine[size];
        }
    };

    private String recordid;
    private String bassin_loisir;
    private String commune;
    private String tel;
    private String info_complementaires;
    private String nom_usuel;
    private String nom_complet;
    private String libre_service;
    private String adresse;
    private String solarium;
    private String bassin_sportif;
    private String web;
    private String plongeoir;
    private String toboggan;
    private String pataugeoire;
    private String accessibilite_handicap;
    private String cp;
    private List<Horaire> horaires;

    public Piscine(String recordid, String bassin_loisir, String commune,
                   String tel, String info_complementaires, String nom_usuel, String nom_complet,
                   String libre_service, String adresse, String solarium,
                   String bassin_sportif, String web, String plongeoir,
                   String toboggan, String pataugeoire, String accessibilite_handicap,
                   String cp) {
        this.recordid = recordid;
        this.bassin_loisir = bassin_loisir;
        this.commune = commune;
        this.tel = tel;
        this.info_complementaires = info_complementaires;
        this.nom_usuel = nom_usuel;
        this.nom_complet = nom_complet;
        this.libre_service = libre_service;
        this.adresse = adresse;
        this.solarium = solarium;
        this.bassin_sportif = bassin_sportif;
        this.web = web;
        this.plongeoir = plongeoir;
        this.toboggan = toboggan;
        this.pataugeoire = pataugeoire;
        this.accessibilite_handicap = accessibilite_handicap;
        this.cp = cp;
    }

    public List<Horaire> getHoraireOfTheDay() {
        Calendar localDate = Calendar.getInstance();
        List<Horaire> result = null;
        if(this.horaires != null){
            result = new ArrayList<>();
            for (Horaire unHoraire : this.horaires) {
                if (unHoraire.getJourInt() == localDate.getFirstDayOfWeek())
                    result.add(unHoraire);
            }
        }
        return result;
    }

    public boolean isOpen() {
        Calendar localDate = Calendar.getInstance();
        boolean result = false;
        if(this.horaires != null){
            for (Horaire unHoraire : this.horaires) {
                for (Horaire unHoraireFrom : getHoraireOfTheDay()) {
                    if(localDate.after(unHoraire.getHeure_debut()) && localDate.before(unHoraire.getHeure_fin()))
                        result = true;
                }
            }
        }
        return result;
    }

    public String getRecordid() {
        return recordid;
    }

    public boolean isBassin_loisir() {
        return bassin_loisir == "OUI";
    }

    public String getCommune() {
        return commune;
    }

    public String getTel() {
        return tel;
    }

    public String getInfo_complementaires() {
        return info_complementaires;
    }

    public String getNom_usuel() {
        return nom_usuel;
    }

    public String getNom_complet() {return nom_complet;}

    public boolean isLibre_service() {
        return libre_service == "OUI";
    }

    public String getAdresse() {
        return adresse;
    }

    public boolean isSolarium() {
        return solarium == "OUI";
    }

    public boolean isBassin_sportif() {
        return bassin_sportif == "OUI";
    }

    public String getWeb() {
        return web;
    }

    public boolean isPlongeoir() {
        return plongeoir == "OUI";
    }

    public boolean isToboggan() {
        return toboggan == "OUI";
    }

    public boolean isPataugeoire() {
        return pataugeoire == "OUI";
    }

    public boolean isAccessibilite_handicap() {
        return accessibilite_handicap == "OUI";
    }

    public String getCp() {
        return cp;
    }

    public String getBassin_loisir() {
        return bassin_loisir;
    }

    public String getLibre_service() {
        return libre_service;
    }

    public String getSolarium() {
        return solarium;
    }

    public String getBassin_sportif() {
        return bassin_sportif;
    }

    public String getPlongeoir() {
        return plongeoir;
    }

    public String getToboggan() {
        return toboggan;
    }

    public String getPataugeoire() {
        return pataugeoire;
    }

    public String getAccessibilite_handicap() {
        return accessibilite_handicap;
    }

    public List<Horaire> getHoraires() {
        return horaires;
    }

    public void addHoraire(Horaire horaire){
        this.horaires.add(horaire);
    }

    // Parcelling part
    public Piscine(Parcel in){
        this.recordid = in.readString();
        this.bassin_loisir = in.readString();
        this.commune = in.readString();
        this.tel = in.readString();
        this.info_complementaires = in.readString();
        this.nom_usuel = in.readString();
        this.nom_complet = in.readString();
        this.libre_service = in.readString();
        this.adresse = in.readString();
        this.solarium = in.readString();
        this.bassin_sportif = in.readString();
        this.web = in.readString();
        this.plongeoir = in.readString();
        this.toboggan = in.readString();
        this.pataugeoire = in.readString();
        this.accessibilite_handicap = in.readString();
        this.cp = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.recordid);
        dest.writeString(this.bassin_loisir );
        dest.writeString(this.commune);
        dest.writeString(this.tel);
        dest.writeString(this.info_complementaires);
        dest.writeString(this.nom_usuel);
        dest.writeString(this.nom_complet);
        dest.writeString(this.libre_service);
        dest.writeString(this.adresse);
        dest.writeString(this.solarium);
        dest.writeString(this.bassin_sportif);
        dest.writeString(this.web);
        dest.writeString(this.plongeoir);
        dest.writeString(this.toboggan);
        dest.writeString(this.pataugeoire);
        dest.writeString(this.accessibilite_handicap);
        dest.writeString(this.cp);
    }
}
