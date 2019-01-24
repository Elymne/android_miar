package nantes.iut.org.android_miar.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import nantes.iut.org.android_miar.R;
import nantes.iut.org.android_miar.adapters.HoraireArrayAdapter;
import nantes.iut.org.android_miar.download.DownloadHoraire;
import nantes.iut.org.android_miar.entities.Horaire;

public class PiscineHoraireActivity extends AppCompatActivity {

    ListView listeViewHoraire;
    ArrayAdapter<Horaire> arrayAdapterHoraire;
    List<Horaire> listeHoraire = new ArrayList<>();
    String idPiscine;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.piscine_horaire_list);
        listeViewHoraire = findViewById(R.id.listeViewHoraire);

        updateListeHoraire();
        arrayAdapterHoraire = new HoraireArrayAdapter(this, R.layout.item_horaire, listeHoraire);
        listeViewHoraire.setAdapter(arrayAdapterHoraire);

    }

    @Override
    protected void onStart() {
        super.onStart();
        new DownloadHoraire(this, idPiscine).execute();
    }

    public void populate(ArrayList<Horaire> listeHoraire){
        this.arrayAdapterHoraire.clear();
        this.arrayAdapterHoraire.addAll(listeHoraire);
        this.arrayAdapterHoraire.notifyDataSetChanged();
    }

    private void updateListeHoraire(){

        final Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.idPiscine = extras.getString("ID_PISCINE");
        }
    }

}
