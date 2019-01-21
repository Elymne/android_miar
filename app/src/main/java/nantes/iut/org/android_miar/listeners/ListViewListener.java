package nantes.iut.org.android_miar.listeners;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import nantes.iut.org.android_miar.activities.MainActivity;
import nantes.iut.org.android_miar.activities.PiscineDetailsActivity;
import nantes.iut.org.android_miar.entities.Piscine;

public class ListViewListener implements AdapterView.OnItemClickListener {

    private int ACCES_DETAIL_RESQUEST_CODE = 200;
    private MainActivity mainActivity;

    public ListViewListener(int ACCES_DETAIL_RESQUEST_CODE, MainActivity mainActivity){
        this.ACCES_DETAIL_RESQUEST_CODE = ACCES_DETAIL_RESQUEST_CODE;
        this.mainActivity = mainActivity;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent requestDetail = new Intent(mainActivity, PiscineDetailsActivity.class);
        Piscine piscine = (Piscine) parent.getItemAtPosition(position);
        // passing item - Piscine object in extras
        requestDetail.putExtra("piscine", piscine);
        mainActivity.startActivityForResult(requestDetail, ACCES_DETAIL_RESQUEST_CODE);
    }
}
