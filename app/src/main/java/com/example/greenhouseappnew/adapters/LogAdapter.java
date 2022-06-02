package com.example.greenhouseappnew.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greenhouseappnew.R;
import com.example.greenhouseappnew.model.Greenhouse;
import com.example.greenhouseappnew.model.LogClass;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class LogAdapter extends RecyclerView.Adapter<LogAdapter.ViewHolder> {

    List<LogClass> logClasses = new ArrayList<>();
    LogAdapter.OnListItemClicker listener;

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.table_item, parent, false);
        return new LogAdapter.ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull LogAdapter.ViewHolder viewHolder, int position) {
        viewHolder.name.setText("test");
    }

    public void setLogs(List<LogClass> logs) {
        this.logClasses = logs;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return logClasses.size();
    }

    public LogClass getLogAt(int position) {
        return logClasses.get(position);
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
