package com.example.greenhouseappnew.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greenhouseappnew.R;
import com.example.greenhouseappnew.model.LogClass;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class LogAdapter extends RecyclerView.Adapter<LogAdapter.ViewHolder> {

    ArrayList<LogClass> logClasses;
    LogAdapter.OnListItemClicker listener;

    LogAdapter(ArrayList<LogClass> logClasses, LogAdapter.OnListItemClicker listener) {
        this.logClasses = logClasses;
        this.listener = listener;
    }

    @NotNull
    @Override
    public LogAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.plant_item, parent, false);
        return new LogAdapter.ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull LogAdapter.ViewHolder viewHolder, int position) {
        viewHolder.name.setText(logClasses.get(position).getName());
    }

    public int getItemCount() {
        return logClasses.size();
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
