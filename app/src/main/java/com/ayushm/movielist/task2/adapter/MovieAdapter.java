package com.ayushm.movielist.task2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ayushm.movielist.R;
import com.ayushm.movielist.task2.model.MoviesList;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<MoviesList> moviesLists;

    public MovieAdapter(List<MoviesList> moviesLists1){this.moviesLists = moviesLists1;}


    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        String resource = moviesLists.get(position).getStreamIcon();
    String name = moviesLists.get(position).getName();
    Double rating = moviesLists.get(position).getRating();

        if (resource.isEmpty()) {
            holder.imgs.setImageResource(R.drawable.download);
        } else{
            Picasso.get().load(moviesLists.get(position).getStreamIcon()).placeholder(R.drawable.download).into(holder.imgs);
        }

        holder.movieName.setText(name);
  holder.movieRating.setText(rating.toString());


    }

    @Override
    public int getItemCount() {
        return moviesLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView movieName,movieRating;
        ImageView imgs;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            movieName = itemView.findViewById(R.id.movie_name);
            movieRating = itemView.findViewById(R.id.movie_rating);
            imgs = itemView.findViewById(R.id.roundedImageView);

        }
    }

}
