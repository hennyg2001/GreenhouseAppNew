package com.example.greenhouseappnew.adapters;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.greenhouseappnew.R;
import com.example.greenhouseappnew.model.Greenhouse;
import com.example.greenhouseappnew.model.LogClass;
import com.example.greenhouseappnew.ui.viewmodel.GreenhousesViewModel;

import java.util.ArrayList;
import java.util.List;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder> {

    Context context;
    List<LogClass> logList = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.table_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TableAdapter.ViewHolder holder, int position) {
        if(logList != null && logList.size() > 0) {
            LogClass currentLog = logList.get(position);
            holder.temperature_tv.setText(String.valueOf(currentLog.getTemperature()));
            holder.cO2_tv.setText(String.valueOf(currentLog.getCo2()));
            holder.humidity_tv.setText(String.valueOf(currentLog.getHumidity()));
            holder.date_tv.setText(currentLog.getTimeStamp().toString());
        }
    }

    @Override
    public int getItemCount() {
        return logList.size();
    }

    public void setLogs(List<LogClass> logs) {
        this.logList = logs;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView humidity_tv, temperature_tv, cO2_tv, date_tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            humidity_tv = itemView.findViewById(R.id.humidity_tv);
            temperature_tv = itemView.findViewById(R.id.temperature_tv);
            cO2_tv = itemView.findViewById(R.id.cO2_tv);
            date_tv = itemView.findViewById(R.id.date_tv);
        }
    }

}
