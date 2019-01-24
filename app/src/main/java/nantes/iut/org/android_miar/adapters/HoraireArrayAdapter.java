package nantes.iut.org.android_miar.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import nantes.iut.org.android_miar.R;
import nantes.iut.org.android_miar.entities.Horaire;


public class HoraireArrayAdapter extends ArrayAdapter<Horaire> {

    Context context;
    int ressources;
    List<Horaire> listeHoraire;

    public HoraireArrayAdapter(Context context, int resource,List<Horaire> listeHoraire) {
        super(context, resource, android.R.id.text1, listeHoraire);
        this.context = context;
        this.ressources = resource;
        this.listeHoraire = listeHoraire;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(this.ressources, parent, false);

        view = setTextView(position, view);
        return view;
    }

    public View setTextView(int position, View view){
        TextView textViewDateDebut = view.findViewById(R.id.textViewDateDebut);
        TextView textViewDateFin = view.findViewById(R.id.textViewDateFin);
        TextView textViewJour = view.findViewById(R.id.textViewJour);
        TextView textViewHeureDebut = view.findViewById(R.id.textViewHeureDebut);
        TextView textViewHeureFin = view.findViewById(R.id.textViewHeureFin);



        textViewDateDebut.setText("Du " + TransformDateToString(getItem(position).getDate_debut()));
        textViewDateFin.setText(" au " + TransformDateToString(getItem(position).getDate_fin()));
        textViewJour.setText(getItem(position).getJour());
        textViewHeureDebut.setText("Entre " + TransformTimeToString(getItem(position).getHeure_debut()));
        textViewHeureFin.setText(" et " + TransformTimeToString(getItem(position).getHeure_fin()));

        return view;
    }

    public String TransformDateToString(Calendar calendar){
        String result = null;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

        if (calendar != null) {
            result = sdf.format(calendar.getTime());
        }

        return result;
    }

    public String TransformTimeToString(Calendar calendar){

        int hourOfDay  = calendar.get(Calendar.HOUR_OF_DAY);
        int minute     = calendar.get(Calendar.MINUTE);

        String result = hourOfDay + ":" + minute;

        return result;
    }
}
