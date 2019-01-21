package nantes.iut.org.android_miar.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import nantes.iut.org.android_miar.R;
import nantes.iut.org.android_miar.adapters.PiscineArrayAdapter;
import nantes.iut.org.android_miar.download.DownloadPiscine;
import nantes.iut.org.android_miar.entities.Piscine;

public class MainActivity extends AppCompatActivity {

    List<Piscine> listePiscines = new ArrayList<>();
    ArrayAdapter<Piscine> arrayAdapterPiscine;
    ListView listeViewPiscine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listeViewPiscine = (ListView) findViewById(R.id.listViewPicine);
        arrayAdapterPiscine = new PiscineArrayAdapter(this, R.layout.item_piscine, listePiscines);

        listeViewPiscine.setAdapter(arrayAdapterPiscine);
    }

    @Override
    protected void onStart() {
        super.onStart();
        new DownloadPiscine(this).execute();
    }

    public void populate(ArrayList<Piscine> listePiscines){
        this.arrayAdapterPiscine.clear();
        this.arrayAdapterPiscine.addAll(listePiscines);
        this.arrayAdapterPiscine.notifyDataSetChanged();
    }
}
