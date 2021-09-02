package com.smkrevit.catalogmovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.smkrevit.catalogmovie.R;
import com.smkrevit.catalogmovie.activity.DetailMainActivity;
import com.smkrevit.catalogmovie.model.Result;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.myViewHolder> {
    private Context context;
    private List<Result> resultList;

    public MovieAdapter(Context context, List<Result> resultList) {
        this.context = context;
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public MovieAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_movie, parent, false);

        MovieAdapter.myViewHolder viewHolder = new MovieAdapter.myViewHolder(view);
        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent.getContext(), DetailMainActivity.class);
                Result result = new Result();
                result.setOriginalTitle(resultList.get(viewHolder.getAdapterPosition()).getOriginalTitle());
                result.setOverview(resultList.get(viewHolder.getAdapterPosition()).getOverview());
                result.setPosterPath(resultList.get(viewHolder.getAdapterPosition()).getPosterPath());
                intent.putExtra(DetailMainActivity.EXTRA_MOVIE, result);
                parent.getContext().startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.myViewHolder holder, int position) {
        holder.tvTitle.setText(resultList.get(position).getTitle());
        holder.tvDescription.setText(resultList.get(position).getOverview());
        Glide.with(context).load("https://image.tmdb.org/t/p/w185" +
                resultList.get(position).getPosterPath()).into(holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvTitle, tvDescription;
        RelativeLayout relativeLayout;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPoster = itemView.findViewById(R.id.imgMovie);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            relativeLayout = itemView.findViewById(R.id.layoutMovie);
        }
    }
}
