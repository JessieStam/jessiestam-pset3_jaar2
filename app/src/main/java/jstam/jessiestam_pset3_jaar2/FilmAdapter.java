package jstam.jessiestam_pset3_jaar2;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jessie on 22/09/2016.
 */

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {

    //krijgt data mee (title, poster)

    private String currentColor;
    private String unfinished = "White";
    private String finished = "Gray";

    View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {

            // if item is selected, change color to gray
            if (currentColor.equals(unfinished) || currentColor == null) {
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int[] posters;
        private String[] titles;

        public TextView myTextView;  //voor namen
        ImageView myImageView; //voor plaatjes

        public ViewHolder(View itemView) { //krijgt mee wat je erin wilt stoppen
            super(itemView);
            myTextView = (TextView) itemView.findViewById(R.id.titles);
            myImageView = (ImageView) itemView.findViewById(R.id.posters);

        }
    }

    @Override
    public FilmAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FilmAdapter.ViewHolder viewHolder, int position) {

        viewHolder.myTextView.setText(titles[i]);
        viewHolder.myImageView.setImageResource(posters[i]);
        viewHolder.itemView.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return titles.length();
    }

}
