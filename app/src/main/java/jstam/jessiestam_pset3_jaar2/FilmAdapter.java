package jstam.jessiestam_pset3_jaar2;

import android.graphics.Color;
import android.net.sip.SipAudioCall;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jessie on 22/09/2016.
 */

public class FilmAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //krijgt data mee (title, poster)

    private String currentColor;
    private String unfinished = "White";
    private String finished = "Gray";

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            // if item is selected, change color to gray
            if (currentColor.equals(unfinished) || currentColor.equals(null)) {
                view.setBackgroundColor(Color.GRAY);
                currentColor = finished;
            }
            // if item is not selected, change color back to white
            else if (currentColor.equals(finished)) {
                view.setBackgroundColor(Color.WHITE);
                currentColor = unfinished;
            }
        }
    }


    @Override
    public FilmAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
        ViewHolder vH = new RecyclerView.ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class ViewHolder {
    }
}