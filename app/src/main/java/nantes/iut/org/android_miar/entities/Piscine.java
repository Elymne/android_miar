package nantes.iut.org.android_miar.entities;

import java.util.List;

public class Piscine {

    private String recordid;
    private String bassin_loisir;
    private String commune;
    private String tel;
    private String info_complementaires;
    private String nom_usuel;
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
                   String tel, String info_complementaires, String nom_usuel,
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

    public String getRecordid() {
        return recordid;
    }

    public boolean isBassin_loisir() {
        boolean result = false;
        if(bassin_loisir == "OUI")
            result = true;
        return result;
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

    public boolean isLibre_service() {
        boolean result = false;
        if(libre_service == "OUI")
            result = true;
        return result;
    }

    public String getAdresse() {
        return adresse;
    }

    public boolean isSolarium() {
        boolean result = false;
        if(solarium == "OUI")
            result = true;
        return result;
    }

    public boolean isBassin_sportif() {
        boolean result = false;
        if(bassin_sportif == "OUI")
            result = true;
        return result;
    }

    public String getWeb() {
        return web;
    }

    public boolean isPlongeoir() {
        boolean result = false;
        if(plongeoir == "OUI")
            result = true;
        return result;
    }

    public boolean isToboggan() {
        boolean result = false;
        if(toboggan == "OUI")
            result = true;
        return result;
    }

    public boolean isPataugeoire() {
        boolean result = false;
        if(pataugeoire == "OUI")
            result = true;
        return result;
    }

    public boolean isAccessibilite_handicap() {
        boolean result = false;
        if(accessibilite_handicap == "OUI")
            result = true;
        return result;
    }

    public String getCp() {
        return cp;
    }
}
