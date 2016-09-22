package jstam.jessiestam_pset3_jaar2;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jessie on 22/09/2016.
 */

public class SecondActivity extends MainActivity{

    // voor het laden van het plaatje:
    // haal inputstream string uit httprequest gebeuren en :
    // Bitmap mIcon1 = BitmapFactory.decodeStream(img_value.openConnection().getInputStream());
    // userpicture.setImageBitmap(mIcon1).toBitmap;

    String title;
    String film_title;
    String film_year;
    String film_director;
    String film_actors;
    String film_summary;

    TextView print_title;
    TextView print_year;
    TextView print_director;
    TextView print_actors;
    TextView print_summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // get extras from MainActivity
        Bundle extras = getIntent().getExtras();
        title = extras.getString("title");

        print_title = (TextView) findViewById(R.id.my_watchlist_title);
        print_year = (TextView) findViewById(R.id.year_string);
        print_director = (TextView) findViewById(R.id.director_string);
        print_actors = (TextView) findViewById(R.id.actors_string);
        print_summary = (TextView) findViewById(R.id.summary_string);
    }


    public void setData(ArrayList<String> data_list) {

        // get title and print to screen
        film_title = data_list.get(0);
        print_title.setText(film_title);

        // get year and print to screen
        film_year = data_list.get(1);
        print_year.setText(film_year);

        // get director and print to screen
        film_director = data_list.get(2);
        print_director.setText(film_director);

        // get actors and print to screen
        film_actors = data_list.get(3);
        print_actors.setText(film_actors);

        // get summary and print to screen
        film_summary = data_list.get(4);
        print_summary.setText(film_summary);

    }
}
