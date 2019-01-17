package nantes.iut.org.android_miar.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;
import java.util.List;

import nantes.iut.org.android_miar.R;
import nantes.iut.org.android_miar.entities.Piscine;

public class PiscineArrayAdapter extends ArrayAdapter<Piscine> {

    List<Piscine> listePiscine;
    Context context;
    int ressource;

    public PiscineArrayAdapter(Context context, int ressource, List<Piscine> listePiscine) {
        super(context, ressource, android.R.id.text1, listePiscine);
        this.context = context;
        this.ressource = ressource;
        this.listePiscine = listePiscine;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(ressource, parent, false);
        TextView textNom = (TextView) view.findViewById(R.id.textViewNom);
        TextView textAdresse = (TextView) view.findViewById(R.id.textViewAdresse);
        TextView textBassinSportif = (TextView) view.findViewById(R.id.textViewBassinSportif);
        TextView textToboggan = (TextView) view.findViewById(R.id.textViewToboggan);
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);

        textNom.setText(getItem(position).getNom_usuel());
        textAdresse.setText(getItem(position).getAdresse());
        if(getItem(position).isBassin_sportif()){
            textBassinSportif.setText("OUI");
        }else{
            textBassinSportif.setText("NON");
        }
        if(getItem(position).isToboggan()){
            textToboggan.setText("OUI");
        }else{
            textToboggan.setText("NON");
        }

        ratingBar.setNumStars(5);
        return view;
    }

}
