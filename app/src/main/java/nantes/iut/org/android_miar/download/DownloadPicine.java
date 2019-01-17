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

import nantes.iut.org.android_miar.MainActivity;
import nantes.iut.org.android_miar.entities.Picine;

public class DownloadPicine extends AsyncTask<String, Void, ArrayList<Picine>> {

    private static String BASE_URL = "https://data.nantesmetropole.fr/api/records/1.0/search/?dataset=244400404_piscines-nantes-metropole&facet=commune&facet=acces_pmr_equipt&facet=bassin_sportif&facet=pataugeoire&facet=toboggan&facet=bassin_apprentissage&facet=plongeoir&facet=solarium&facet=bassin_loisir&facet=accessibilite_handicap&facet=libre_service";
    private HttpURLConnection httpClient;
    private ProgressDialog progress;
    private volatile MainActivity mainActivity;

    public DownloadPicine(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.progress = new ProgressDialog(this.mainActivity);
    }

    @Override
    protected void onPreExecute(){
        progress.setTitle("Please wait");
        progress.setMessage("working");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.show();
    }

    @Override
    protected ArrayList<Picine> doInBackground(String... values) {

        ArrayList<Picine> result = new ArrayList<>();
        String stream = null;

        try {
            URL url = new URL(BASE_URL);
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
                result.add(new Picine(
                        jsonObjectRecords.getString("recordid"),
                        hasValue("bassin_loisir", jsonObjectRecords.getJSONObject("fields")),
                        hasValue("commune", jsonObjectRecords.getJSONObject("fields")),
                        hasValue("tel", jsonObjectRecords.getJSONObject("fields")),
                        hasValue("infos_complementaires", jsonObjectRecords.getJSONObject("fields")),
                        hasValue("nom_usuel", jsonObjectRecords.getJSONObject("fields")),
                        hasValue("libre_service", jsonObjectRecords.getJSONObject("fields")),
                        hasValue("adresse", jsonObjectRecords.getJSONObject("fields")),
                        hasValue("solarium", jsonObjectRecords.getJSONObject("fields")),
                        hasValue("bassin_sportif", jsonObjectRecords.getJSONObject("fields")),
                        hasValue("web", jsonObjectRecords.getJSONObject("fields")),
                        hasValue("plongeoire", jsonObjectRecords.getJSONObject("fields")),
                        hasValue("toboggan", jsonObjectRecords.getJSONObject("fields")),
                        hasValue("pataugeoire", jsonObjectRecords.getJSONObject("fields")),
                        hasValue("accessibilite_handicap", jsonObjectRecords.getJSONObject("fields")),
                        hasValue("cp", jsonObjectRecords.getJSONObject("fields"))
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
    protected void onPostExecute(ArrayList<Picine> result){
        if(progress.isShowing())
            progress.dismiss();
        this.mainActivity.populate(result);
    }
}
