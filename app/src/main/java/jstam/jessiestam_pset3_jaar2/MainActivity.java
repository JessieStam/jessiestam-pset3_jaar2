package jstam.jessiestam_pset3_jaar2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    RecyclerView moviesList;
    // adapter object
    // layoutmanager object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moviesList = (RecyclerView) findViewById(R.id.movies_list);

    }

    public void searchFilm(View viewSearchFilm) {

        //get info from HttpRequestHelper
    }
}
