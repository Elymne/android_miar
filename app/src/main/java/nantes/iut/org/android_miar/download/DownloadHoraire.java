package nantes.iut.org.android_miar.download;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import nantes.iut.org.android_miar.activities.PiscineHoraireActivity;
import nantes.iut.org.android_miar.entities.Horaire;

public class DownloadHoraire extends AsyncTask<String, Void, ArrayList<Horaire>> {

    private static String BASE_URL_HORAIRE = "https://data.nantesmetropole.fr/api/records/1.0/search/?dataset=244400404_piscines-nantes-metropole-horaires&rows=200&facet=nom_periode&facet=jour&facet=type_horaire";
    private HttpURLConnection httpClient;
    private ProgressDialog progress;
    private volatile PiscineHoraireActivity piscineHoraireActivity;
    private String idObject;

    public DownloadHoraire(PiscineHoraireActivity piscineHoraireActivity, String idObject) {
        this.piscineHoraireActivity = piscineHoraireActivity;
        this.idObject = idObject;
        this.progress = new ProgressDialog(this.piscineHoraireActivity);
    }

    @Override
    protected void onPreExecute(){
        progress.setTitle("Please wait");
        progress.setMessage("Chargement des données relatives aux horaires ...");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.show();
    }

    @Override
    protected ArrayList<Horaire> doInBackground(String... values) {

        ArrayList<Horaire> horaireList = this.getHoraireList();
        for(Horaire horaire : this.getHoraireList()){
            if(horaire.getIdobj().equals(this.idObject))
                horaireList.add(horaire);
        }
        return horaireList;
    }

    private ArrayList<Horaire> getHoraireList(){

        ArrayList<Horaire> result = new ArrayList<>();
        String stream = null;

        try {
            URL url = new URL(BASE_URL_HORAIRE);
            this.httpClient = (HttpURLConnection) url.openConnection();
            this.httpClient.setRequestMethod("GET");
            InputStream inputStream = new BufferedInputStream(this.httpClient.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while((line = bufferedReader.readLine()) != null)
                stringBuilder.append((line));
            stream = stringBuilder.toString();

            JSONArray jsonArrayRecords = new JSONObject(stream).getJSONArray("records");
            for(int i = 0; i < jsonArrayRecords.length(); i++){
                JSONObject jsonObjectRecords = jsonArrayRecords.getJSONObject(i);
                result.add(new Horaire(
                        hasValue("idobj", jsonObjectRecords.getJSONObject("fields")),
                        hasValue("jour", jsonObjectRecords.getJSONObject("fields")),
                        hasValue("heure_debut", jsonObjectRecords.getJSONObject("fields")),
                        hasValue("heure_fin", jsonObjectRecords.getJSONObject("fields")),
                        hasValue("date_debut", jsonObjectRecords.getJSONObject("fields")),
                        hasValue("date_fin", jsonObjectRecords.getJSONObject("fields"))
                ));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            this.httpClient.disconnect();
        }
        return result;
    }

    private String hasValue(String jsonValue, JSONObject jsonObject) throws JSONException {
        String result = "PAS DE DONNEES";
        if(jsonObject.has(jsonValue))
            result = jsonObject.getString(jsonValue);
        return result;
    }

    @Override
    protected void onPostExecute(ArrayList<Horaire> result){
        if(progress.isShowing())
            progress.dismiss();
        this.piscineHoraireActivity.populate(result);
    }
}
