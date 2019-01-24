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

    private String idobj;
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

    public Piscine(String idobj, String bassin_loisir, String commune,
                   String tel, String info_complementaires, String nom_usuel, String nom_complet,
                   String libre_service, String adresse, String solarium,
                   String bassin_sportif, String web, String plongeoir,
                   String toboggan, String pataugeoire, String accessibilite_handicap,
                   String cp) {
        this.idobj = idobj;
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

    public String getIdobj() {
        return idobj;
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
        boolean result = false;
        if(this.libre_service.equals("OUI"))
            result = true;
        return result;
    }

    public String getAdresse() {
        return adresse;
    }

    public boolean isSolarium() {
        boolean result = false;
        if(this.solarium.equals("OUI"))
            result = true;
        return result;
    }

    public boolean isBassin_sportif() {
        boolean result = false;
        if(this.bassin_sportif.equals("OUI"))
            result = true;
        return result;
    }

    public String getWeb() {
        return web;
    }

    public boolean isPlongeoir() {
        boolean result = false;
        if(this.plongeoir.equals("OUI"))
            result = true;
        return result;
    }

    public boolean isToboggan() {
        boolean result = false;
        if(this.toboggan.equals("OUI"))
            result = true;
        return result;
    }

    public boolean isPataugeoire() {
        boolean result = false;
        if(this.pataugeoire.equals("OUI"))
            result = true;
        return result;
    }

    public boolean isAccessibilite_handicap(){
        boolean result = false;
        if(this.accessibilite_handicap.equals("OUI"))
            result = true;
        return result;
    }

    public boolean isBassin_loisir() {
        boolean result = false;
        if(this.bassin_loisir.equals("OUI"))
            result = true;
        return result;
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

    @Override
    public String toString() {
        return "Piscine{" +
                "idobj='" + idobj + '\'' +
                ", bassin_loisir='" + bassin_loisir + '\'' +
                ", commune='" + commune + '\'' +
                ", tel='" + tel + '\'' +
                ", info_complementaires='" + info_complementaires + '\'' +
                ", nom_usuel='" + nom_usuel + '\'' +
                ", nom_complet='" + nom_complet + '\'' +
                ", libre_service='" + libre_service + '\'' +
                ", adresse='" + adresse + '\'' +
                ", solarium='" + solarium + '\'' +
                ", bassin_sportif='" + bassin_sportif + '\'' +
                ", web='" + web + '\'' +
                ", plongeoir='" + plongeoir + '\'' +
                ", toboggan='" + toboggan + '\'' +
                ", pataugeoire='" + pataugeoire + '\'' +
                ", accessibilite_handicap='" + accessibilite_handicap + '\'' +
                ", cp='" + cp + '\'' +
                '}';
    }

    // Parcelling part
    public Piscine(Parcel in){
        this.idobj = in.readString();
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
        dest.writeString(this.idobj);
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
