package nantes.iut.org.android_miar.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    ArrayAdapter<Piscine> arrayAdapterPicine;
    ListView listeViewPicine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listeViewPicine = (ListView) findViewById(R.id.listViewPicine);
        arrayAdapterPicine = new PiscineArrayAdapter(this, R.layout.item_piscine, listePiscines);

        listeViewPicine.setAdapter(arrayAdapterPicine);


        // listener on piscine item
        listeViewPicine.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent request = new Intent(MainActivity.this, PiscineDetailsActivity.class);
                Piscine piscine = (Piscine) parent.getItemAtPosition(position);
                // passing item - Piscine object in extras
                request.putExtra("piscine", piscine);
                startActivityForResult(request, 200);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        new DownloadPiscine(this).execute();
    }

    public void populatePiscine(ArrayList<Piscine> listePiscines){
        this.arrayAdapterPicine.clear();
        this.arrayAdapterPicine.addAll(listePiscines);
        this.arrayAdapterPicine.notifyDataSetChanged();
    }

    // on result - update stars evaluation in list
    // @Override
    // protected void onActivityResult(int reqCode, int resCode, Intent result){}
}
