package nantes.iut.org.android_miar.listeners;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.RatingBar;

import nantes.iut.org.android_miar.activities.PiscineDetailsActivity;
import nantes.iut.org.android_miar.entities.Piscine;

import static android.content.Context.MODE_PRIVATE;

public class RatingBarListener implements RatingBar.OnRatingBarChangeListener {

    private PiscineDetailsActivity piscineDetailsActivity;
    private Piscine piscine;
    private SharedPreferences.Editor editor;

    public RatingBarListener(PiscineDetailsActivity piscineDetailsActivity, Piscine piscine, SharedPreferences.Editor editor) {
        this.piscineDetailsActivity = piscineDetailsActivity;
        this.piscine = piscine;
        this.editor = editor;
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        float note = ratingBar.getRating();
        this.editor.putFloat(piscine.getIdobj() + "stars_note", note); // value to store
        this.editor.commit();
    }
}
