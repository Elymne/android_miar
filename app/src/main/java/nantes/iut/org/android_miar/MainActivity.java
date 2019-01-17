package nantes.iut.org.android_miar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import nantes.iut.org.android_miar.adapters.PicineArrayAdapter;
import nantes.iut.org.android_miar.download.DownloadPicine;
import nantes.iut.org.android_miar.entities.Picine;

public class MainActivity extends AppCompatActivity {

    List<Picine> listePicines = new ArrayList<>();
    ArrayAdapter<Picine> arrayAdapterPicine;
    ListView listeViewPicine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listeViewPicine = (ListView) findViewById(R.id.listViewPicine);
        arrayAdapterPicine = new PicineArrayAdapter(this, R.layout.item_picine,listePicines);

        listeViewPicine.setAdapter(arrayAdapterPicine);
    }

    @Override
    protected void onStart() {
        super.onStart();
        new DownloadPicine(this).execute();
    }

    public void populate(ArrayList<Picine> listePicines){
        this.arrayAdapterPicine.clear();
        this.arrayAdapterPicine.addAll(listePicines);
        this.arrayAdapterPicine.notifyDataSetChanged();
    }
}
