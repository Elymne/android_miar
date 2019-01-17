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

    public Horaire getHoraireToday(){
        for(Horaire unHoraire : this.horaires){

        }
        return null;
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
}
