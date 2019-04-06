package com.example.csdproj_1;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class RecyclerAdaptor extends RecyclerView.Adapter<RecyclerAdaptor.ImageViewHolder> {
    private ArrayList<pic_data> img_data;
    Activity context;


    public RecyclerAdaptor(Activity context ,ArrayList<pic_data> img_data) {
        this.img_data = img_data;
        this.context = context;

    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_layout,viewGroup,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder viewHolder, final int i) {

        viewHolder.Album.setImageResource(img_data.get(i).getImg_res());
        viewHolder.AlbumTitle.setText(img_data.get(i).getImg_caption());
        viewHolder.AlbumDesc.setText(img_data.get(i).getDescription());



    }

    @Override
    public int getItemCount() { return img_data.size(); }

    public static class ImageViewHolder extends RecyclerView.ViewHolder{

        ImageView Album;
        TextView AlbumTitle;
        TextView AlbumDesc;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            Album = itemView.findViewById(R.id.album);
            AlbumTitle = itemView.findViewById(R.id.album_title);
            AlbumDesc = itemView.findViewById(R.id.album_description);

        }
    }
}