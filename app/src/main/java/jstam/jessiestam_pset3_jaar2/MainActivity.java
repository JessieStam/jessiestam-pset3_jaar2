package jstam.jessiestam_pset3_jaar2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    RecyclerView moviesList;
    // adapter object
    // layoutmanager object
    EditText title_input;
    String title_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moviesList = (RecyclerView) findViewById(R.id.movies_list);
        title_input = (EditText) findViewById(R.id.user_search_input);
        title_string = title_input.getText().toString();
    }

    public void searchFilm(View viewSearchFilm) {

        // move to second Activity
        Intent searchTitle = new Intent(this, SecondActivity.class);

        // move extras to SecondActivity
        searchTitle.putExtra("title", title_string);

        Log.d("findproblem8", title_string);

        // clear the EditText
        title_input.getText().clear();

        startActivity(searchTitle);
    }

    // maak nog een ding om die items aan te klikken en van kleur te veranderen ohnee dit gebeurt
    // in de adapter maar je moet die dan wel aanroepen
}
