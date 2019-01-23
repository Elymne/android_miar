package nantes.iut.org.android_miar.listeners;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.ToggleButton;

import nantes.iut.org.android_miar.activities.PiscineDetailsActivity;
import nantes.iut.org.android_miar.entities.Piscine;

import static android.content.Context.MODE_PRIVATE;

public class IsVisitedButtonListener implements View.OnClickListener {
    private ToggleButton isVisited;
    private PiscineDetailsActivity piscineDetailsActivity;
    private Piscine piscine;

    public IsVisitedButtonListener(ToggleButton isVisited, PiscineDetailsActivity piscineDetailsActivity, Piscine piscine) {
        this.isVisited = isVisited;
        this.piscineDetailsActivity = piscineDetailsActivity;
        this.piscine = piscine;
    }

    @Override
    public void onClick(View v) {
        boolean checked = isVisited.isChecked();
        SharedPreferences pref = piscineDetailsActivity.getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(piscine.getRecordid() + "tgpref", checked); // value to store
        editor.commit();
    }
}
