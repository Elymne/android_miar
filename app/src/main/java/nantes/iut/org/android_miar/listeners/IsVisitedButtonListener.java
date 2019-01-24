package nantes.iut.org.android_miar.listeners;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.ToggleButton;

import nantes.iut.org.android_miar.activities.PiscineDetailsActivity;
import nantes.iut.org.android_miar.entities.Piscine;

import static android.content.Context.MODE_PRIVATE;

public class IsVisitedButtonListener implements View.OnClickListener {

    private ToggleButton isVisited;
    private Piscine piscine;
    SharedPreferences.Editor editor;

    public IsVisitedButtonListener(ToggleButton isVisited, Piscine piscine ,SharedPreferences.Editor editor) {
        this.isVisited = isVisited;
        this.piscine = piscine;
        this.editor = editor;
    }

    @Override
    public void onClick(View v) {
        boolean checked = isVisited.isChecked();
        this.editor.putBoolean(piscine.getIdobj() + "tgpref", checked); // value to store
        this.editor.commit();
    }
}
