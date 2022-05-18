package com.example.sep4_greenhouseapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sep4_greenhouseapp.model.Plant;
import com.google.firebase.database.annotations.NotNull;

import java.util.ArrayList;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.ViewHolder> {

    ArrayList<Plant> plants;
    OnListItemClicker listener;

    PlantAdapter(ArrayList<Plant> plants, OnListItemClicker listener) {
        this.plants = plants;
        this.listener = listener;
    }

    @NotNull
    @Override
    public PlantAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.plant_list_item, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.name.setText(plants.get(position).getName());
    }

    public int getItemCount() {
        return plants.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;

        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(getBindingAdapterPosition());
                }
            });
            name = itemView.findViewById(R.id.tv_name);
        }

    }

    public interface OnListItemClicker {
        void onClick(int position);
    }

}
