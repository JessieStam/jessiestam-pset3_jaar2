package jstam.jessiestam_pset3_jaar2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Jessie on 22/09/2016.
 */

public class FilmAdapter {

    // field for id
    private int id;

    // field for name
    private String film_title;

    // field for recyclerview
    private RecyclerView movies_list;

    //constructor
    public FilmAdapter(String new_string) {film_title = new_string;}

    public FilmAdapter(Integer new_id) {id = new_id}

    public FilmAdapter(RecyclerView new_list) {movies_list = new_list;}

    // methods
    public String getTitle() {return film_title;}

    public void setTitle(String new_title) {film_title = new_title;}

    public Integer getId() {return id;}

    public void setId(Integer new_id) {id = new_id;}

    public RecyclerView getMovies_list() {return movies_list;}

    public void setMovies_list(RecyclerView new_movies_list) {movies_list = new_movies_list;}

}