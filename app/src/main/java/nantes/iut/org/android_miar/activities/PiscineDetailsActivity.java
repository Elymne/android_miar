package nantes.iut.org.android_miar.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.ToggleButton;

import nantes.iut.org.android_miar.R;
import nantes.iut.org.android_miar.entities.Piscine;
import nantes.iut.org.android_miar.listeners.IsVisitedButtonListener;

public class PiscineDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.piscine_details);
        Intent intent = getIntent();
        Piscine piscine = (Piscine) intent.getParcelableExtra("piscine");  // get Piscine object;

        TextView textNom = (TextView) findViewById(R.id.nom_piscine);
        textNom.setText(piscine.getNom_complet());

        TextView textTelephone = (TextView) findViewById(R.id.num_tel);
        textTelephone.setText(piscine.getTel());

        TextView textBassinSportif = (TextView) findViewById(R.id.textViewBassinSportif);
        textBassinSportif.setText(piscine.getBassin_sportif());
        TextView textViewToboggan= (TextView) findViewById(R.id.textViewToboggan);
        textViewToboggan.setText(piscine.getToboggan());
        TextView textViewAccesHandicap = (TextView) findViewById(R.id.textViewAccesHadicap);
        textViewAccesHandicap.setText(piscine.getAccessibilite_handicap());
        TextView textViewBassinLoisir= (TextView) findViewById(R.id.textViewBassinLoisir);
        textViewBassinLoisir.setText(piscine.getBassin_loisir());


        ToggleButton isVisited_btn = (ToggleButton) findViewById(R.id.isVisited_btn);
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        boolean tgpref = preferences.getBoolean("tgpref", false);  //default is true
        isVisited_btn.setChecked(tgpref);
        // set listener on "visited" button
        isVisited_btn.setOnClickListener(new IsVisitedButtonListener(isVisited_btn, this));

        // set listener on stars evaluation
    }
}
