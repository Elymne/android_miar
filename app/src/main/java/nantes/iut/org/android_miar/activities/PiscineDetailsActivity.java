package nantes.iut.org.android_miar.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import nantes.iut.org.android_miar.R;
import nantes.iut.org.android_miar.entities.Piscine;
import nantes.iut.org.android_miar.listeners.HoraireButtonListener;
import nantes.iut.org.android_miar.listeners.IsVisitedButtonListener;
import nantes.iut.org.android_miar.listeners.RatingBarListener;

public class PiscineDetailsActivity extends AppCompatActivity {

    private final int ACCES_HORAIRE_RESQUEST_CODE = 201;
    private final String PREF_NAME = "filePref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.piscine_details);
        Intent intent = getIntent();
        Piscine piscine = intent.getParcelableExtra("piscine");

        SharedPreferences preferences = getSharedPreferences(PREF_NAME, 0);
        SharedPreferences.Editor editor = preferences.edit();

        this.setTextView(piscine);
        this.setSharedPreferences(preferences, piscine, editor);

        Button bouttonHoraire = findViewById(R.id.buttonAccesHoraire);
        bouttonHoraire.setOnClickListener(new HoraireButtonListener(this.ACCES_HORAIRE_RESQUEST_CODE, this, piscine.getIdobj()));

    }

    private static void definirInfo(TextView textView, boolean bool){
        if(bool){
            textView.setText("OUI");
            textView.setTextColor(Color.BLUE);
        }else{
            textView.setText("NON");
            textView.setTextColor(Color.RED);
        }
    }

    private void setTextView(Piscine piscine){
        TextView textViewNomUsuel = findViewById(R.id.textViewNomUsuel_2);
        TextView textViewNomComplet = findViewById(R.id.textViewNomComplet_2);
        TextView textViewAdresse = findViewById(R.id.textViewAdresse_2);
        TextView textViewCommune = findViewById(R.id.textViewCommune_2);
        TextView textViewBassinLoisir = findViewById(R.id.textViewBassinLoisir_2);
        TextView textViewLibreService = findViewById(R.id.textViewLibreService_2);
        TextView textViewSolarium = findViewById(R.id.textViewSolarium_2);
        TextView textViewBassinSportif = findViewById(R.id.textViewBassinSportif_2);
        TextView textViewPlongeoir = findViewById(R.id.textViewPlongeoir_2);
        TextView textViewToboggan = findViewById(R.id.textViewTobbogan_2);
        TextView textViewPataugeoir = findViewById(R.id.textViewPataugeoir_2);
        TextView textViewAccesHandicap = findViewById(R.id.textViewAccesHandicap_2);
        TextView textViewInfoComplementaire = findViewById(R.id.textViewInfoComplementaire_2);
        TextView textViewSiteWeb = findViewById(R.id.textViewSiteWeb_2);
        TextView textViewNumTel = findViewById(R.id.textViewNumTel_2);

        textViewNomUsuel.setText(piscine.getNom_usuel());
        textViewNomComplet.setText(piscine.getNom_complet());
        textViewAdresse.setText(piscine.getAdresse());
        textViewCommune.setText(piscine.getCommune());
        textViewInfoComplementaire.setText(piscine.getInfo_complementaires());
        textViewSiteWeb.setText(piscine.getWeb());
        textViewNumTel.setText(piscine.getTel());
        definirInfo(textViewBassinLoisir, piscine.isBassin_loisir());
        definirInfo(textViewLibreService, piscine.isLibre_service());
        definirInfo(textViewSolarium, piscine.isSolarium());
        definirInfo(textViewBassinSportif, piscine.isBassin_sportif());
        definirInfo(textViewPlongeoir, piscine.isPlongeoir());
        definirInfo(textViewToboggan, piscine.isToboggan());
        definirInfo(textViewPataugeoir, piscine.isPataugeoire());
        definirInfo(textViewAccesHandicap, piscine.isAccessibilite_handicap());
    }

    private void setSharedPreferences(SharedPreferences preferences, Piscine piscine, SharedPreferences.Editor editor){
        ToggleButton toggleButtonVisite = findViewById(R.id.toggleButtonVisite);
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        toggleButtonVisite.setChecked(preferences.getBoolean(piscine.getIdobj() + "tgpref", false));
        ratingBar.setRating(preferences.getFloat(piscine.getIdobj() + "stars_note", 0));

        toggleButtonVisite.setOnClickListener(new IsVisitedButtonListener(toggleButtonVisite, piscine, editor));
        ratingBar.setOnRatingBarChangeListener(new RatingBarListener(this, piscine, editor));

    }
}
