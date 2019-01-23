package nantes.iut.org.android_miar.listeners;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.RatingBar;

import nantes.iut.org.android_miar.activities.PiscineDetailsActivity;

import static android.content.Context.MODE_PRIVATE;

public class RatingBarListener implements RatingBar.OnRatingBarChangeListener {
    private PiscineDetailsActivity piscineDetailsActivity;

    public RatingBarListener(PiscineDetailsActivity piscineDetailsActivity) {
        this.piscineDetailsActivity = piscineDetailsActivity;
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        float note = ratingBar.getRating();
        SharedPreferences pref = piscineDetailsActivity.getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putFloat("stars_note", note); // value to store
        editor.commit();
    }
}
