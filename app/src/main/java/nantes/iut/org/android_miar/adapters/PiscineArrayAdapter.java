package nantes.iut.org.android_miar.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

        TextView textNom = view.findViewById(R.id.textViewNom);
        TextView textAdresse = view.findViewById(R.id.textViewAdresse);
        TextView textBassinSportif = view.findViewById(R.id.textViewBassinSportif);
        TextView textBassinLoisir = view.findViewById(R.id.textViewBassinLoisir);
        TextView textAccesHandicap = view.findViewById(R.id.textViewAccesHadicap);

        textNom.setText(getItem(position).getNom_usuel());
        textAdresse.setText(getItem(position).getAdresse());
        textBassinLoisir.setText(getItem(position).getBassin_loisir());
        textBassinSportif.setText(getItem(position).getBassin_sportif());
        textAccesHandicap.setText(getItem(position).getAccessibilite_handicap());
        return view;
    }

    private String boolean_toStringOpen(boolean value){
        String result = "FERME";
        if(value)
            result = "OUVERT";
        return result;
    }

}
