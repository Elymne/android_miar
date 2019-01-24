package nantes.iut.org.android_miar.listeners;

import android.content.Intent;
import android.view.View;

import nantes.iut.org.android_miar.activities.PiscineDetailsActivity;
import nantes.iut.org.android_miar.activities.PiscineHoraireActivity;

public class HoraireButtonListener implements View.OnClickListener{

    private int ACCES_HORAIRE_RESQUEST_CODE;
    private PiscineDetailsActivity piscineDetailsActivity;
    private String PiscineId;

    public HoraireButtonListener(int ACCES_HORAIRE_RESQUEST_CODE, PiscineDetailsActivity piscineDetailsActivity, String PiscineId){
        this.ACCES_HORAIRE_RESQUEST_CODE = ACCES_HORAIRE_RESQUEST_CODE;
        this.piscineDetailsActivity = piscineDetailsActivity;
        this.PiscineId = PiscineId;
    }

    @Override
    public void onClick(View v) {
        Intent request = new Intent(this.piscineDetailsActivity, PiscineHoraireActivity.class);
        request.putExtra("ID_PISCINE", this.PiscineId);
        this.piscineDetailsActivity.startActivityForResult(request, ACCES_HORAIRE_RESQUEST_CODE);
    }
}
