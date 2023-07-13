package com.example.baijson;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private final List<Contact> list;

    public ContactAdapter(List<Contact> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact album = list.get(position);
        if(album == null){
            return;
        }
        holder.tvId.setText(String.valueOf(album.getId()));
        holder.tvTitle.setText(album.getTitle());
        Picasso.get().load(album.getUrl()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list==null?0: list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView  tvId,tvTitle;
        private ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvIDAlbum);
            tvTitle = itemView.findViewById(R.id.tvTitleAlbum);
            img = itemView.findViewById(R.id.imgAlbum);
        }
    }
}
