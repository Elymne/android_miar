package nantes.iut.org.android_miar.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import nantes.iut.org.android_miar.R;
import nantes.iut.org.android_miar.entities.Piscine;

public class PiscineArrayAdapter extends ArrayAdapter<Piscine> {

    private final String PREF_NAME = "filePref";
    List<Piscine> listePiscine;
    Context context;
    int ressources;
    private SharedPreferences preferences;

    public PiscineArrayAdapter(Context context, int ressources, List<Piscine> listePiscine, SharedPreferences preferences) {
        super(context, ressources, android.R.id.text1, listePiscine);
        this.context = context;
        this.ressources = ressources;
        this.listePiscine = listePiscine;
        this.preferences = preferences;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(this.ressources, parent, false);

        view = this.setTextView(position, view);
        return view;
    }

    private View setTextView(int position, View view){
        TextView textNom = view.findViewById(R.id.textViewNom);
        TextView textAdresse = view.findViewById(R.id.textViewAdresse);
        TextView textBassinSportif = view.findViewById(R.id.textViewBassinSportif);
        TextView textBassinLoisir = view.findViewById(R.id.textViewBassinLoisir);
        TextView textAccesHandicap = view.findViewById(R.id.textViewAccesHadicap);
        TextView textViewVisited = view.findViewById(R.id.textViewVisited);

        textNom.setText(getItem(position).getNom_usuel());
        textAdresse.setText(getItem(position).getAdresse());
        textBassinLoisir.setText(getItem(position).getBassin_loisir());
        textBassinSportif.setText(getItem(position).getBassin_sportif());
        textAccesHandicap.setText(getItem(position).getAccessibilite_handicap());



        boolean result = preferences.getBoolean(getItem(position).getIdobj() + "tgpref", false);
        if(result){
            textViewVisited.setText("Déjà visisté");
            textViewVisited.setTextColor(Color.BLUE);
        }else{
            textViewVisited.setText("Non visité");
            textViewVisited.setTextColor(Color.DKGRAY);
        }
        return view;
    }

}
