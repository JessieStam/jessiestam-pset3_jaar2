package jstam.jessiestam_pset3_jaar2;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Jessie on 22/09/2016.
 */

public class LayoutManager {

    MainActivity mainActivity;

    // define RecyclerView
    private RecyclerView movies_list = new RecyclerView(mainActivity);

    // define adapter
    private FilmAdapter adapter = new FilmAdapter(movies_list);

    public static LayoutManager ourInstance = null;

    // constructor
    public static LayoutManager getourInstance() {
        if (ourInstance == null) {
            ourInstance = new LayoutManager();
        }
        return ourInstance;
    }

    public FilmAdapter make_movie_list(String title) {



    }

}


