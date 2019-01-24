package nantes.iut.org.android_miar.activities;

import android.content.SharedPreferences;
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
import nantes.iut.org.android_miar.listeners.ListViewListener;

public class MainActivity extends AppCompatActivity {

    private final int ACCES_DETAIL_RESQUEST_CODE = 200;

    private final String PREF_NAME = "filePref";
    List<Piscine> listePiscines = new ArrayList<>();
    ArrayAdapter<Piscine> arrayAdapterPiscine;
    ListView listeViewPiscine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listeViewPiscine = findViewById(R.id.listViewPicine);
        SharedPreferences preferences = getSharedPreferences(PREF_NAME, 0);

        arrayAdapterPiscine = new PiscineArrayAdapter(this, R.layout.item_piscine, listePiscines, preferences);
        listeViewPiscine.setAdapter(arrayAdapterPiscine);
        listeViewPiscine.setOnItemClickListener(new ListViewListener(ACCES_DETAIL_RESQUEST_CODE, this));
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
