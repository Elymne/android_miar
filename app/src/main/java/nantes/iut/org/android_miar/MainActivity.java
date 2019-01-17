package nantes.iut.org.android_miar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import nantes.iut.org.android_miar.adapters.PiscineArrayAdapter;
import nantes.iut.org.android_miar.download.DownloadPiscine;
import nantes.iut.org.android_miar.entities.Piscine;

public class MainActivity extends AppCompatActivity {

    List<Piscine> listePiscines = new ArrayList<>();
    ArrayAdapter<Piscine> arrayAdapterPicine;
    ListView listeViewPicine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listeViewPicine = (ListView) findViewById(R.id.listViewPicine);
        arrayAdapterPicine = new PiscineArrayAdapter(this, R.layout.item_piscine, listePiscines);

        listeViewPicine.setAdapter(arrayAdapterPicine);
    }

    @Override
    protected void onStart() {
        super.onStart();
        new DownloadPiscine(this).execute();
    }

    public void populate(ArrayList<Piscine> listePiscines){
        this.arrayAdapterPicine.clear();
        this.arrayAdapterPicine.addAll(listePiscines);
        this.arrayAdapterPicine.notifyDataSetChanged();
    }
}
