package com.example.greenhouseappnew.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greenhouseappnew.R;
import com.example.greenhouseappnew.model.Greenhouse;
import com.example.greenhouseappnew.model.Log;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class GreenhouseAdapter extends RecyclerView.Adapter<GreenhouseAdapter.ViewHolder> {

    ArrayList<Greenhouse> greenhouses;
    GreenhouseAdapter.OnListItemClicker listener;

    GreenhouseAdapter(ArrayList<Greenhouse> greenhouses, GreenhouseAdapter.OnListItemClicker listener) {
        this.greenhouses = greenhouses;
        this.listener = listener;
    }

    @NotNull
    @Override
    public GreenhouseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.greenhouse_item, parent, false);
        return new GreenhouseAdapter.ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull GreenhouseAdapter.ViewHolder viewHolder, int position) {
        viewHolder.name.setText(greenhouses.get(position).getName());
    }

    public int getItemCount() {
        return greenhouses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;

        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(getAdapterPosition());
                }
            });
            name = itemView.findViewById(R.id.tv_name);
        }

    }

    public interface OnListItemClicker {
        void onClick(int position);
    }

}
