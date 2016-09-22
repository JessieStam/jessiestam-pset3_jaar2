package jstam.jessiestam_pset3_jaar2;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jessie on 22/09/2016.
 */

public class TitleAsyncTask extends AsyncTask<String, Integer, String> {

    Context context;
    SecondActivity secondActivity;

    // let user know data is being downloaded
    @Override
    protected void onPreExecute() {
        // inform user
        Toast.makeText(context, "Getting data from server", Toast.LENGTH_SHORT).show();
    }

    // download the data
    @Override
    protected String doInBackground(String... params) {
        return HttpRequestHelper.downloadFromServer(params);
    }

    // read the data and put in list
    @Override
    protected void onPostExecute(String readFilmInfo) {
        super.onPostExecute(readFilmInfo);

        // if nothing was found, inform user
        if (readFilmInfo.length() == 0) {
            Toast.makeText(context, "No data was found", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Data was found", Toast.LENGTH_SHORT).show();

            ArrayList<String> data_list = new ArrayList<>();

            try {
                // create new JSONObject
                JSONObject response_object = new JSONObject(readFilmInfo);
                JSONObject title_object = response_object.getJSONObject("Title");
                JSONObject year_object = response_object.getJSONObject("Year");
                JSONObject director_object = response_object.getJSONObject("Director");
                JSONObject actors_object = response_object.getJSONObject("Actors");
                JSONObject summary_object = response_object.getJSONObject("Summary");

                // add to list as String
                data_list.add(title_object.getString("Title"));
                data_list.add(year_object.getString("Year"));
                data_list.add(director_object.getString("Director"));
                data_list.add(actors_object.getString("Actors"));
                data_list.add(summary_object.getString("Summary"));

            }
            catch (Exception e) {
                e.printStackTrace();
            }

            this.secondActivity.setData(data_list);
        }
    }
}
