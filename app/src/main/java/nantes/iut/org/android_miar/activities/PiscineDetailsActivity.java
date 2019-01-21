package nantes.iut.org.android_miar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import nantes.iut.org.android_miar.R;
import nantes.iut.org.android_miar.entities.Piscine;

public class PiscineDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.piscine_details);
        //Bundle data = getIntent().getExtras();// get extras from MainActivity
        Intent intent = getIntent();
        Piscine piscine = (Piscine) intent.getParcelableExtra("piscine");  // get Piscine object;

        TextView textNom = (TextView) findViewById(R.id.nom_piscine);
        textNom.setText(piscine.getNom_complet());

        // set listener on stars evaluation
        // set listener on "visited" button
    }
}
