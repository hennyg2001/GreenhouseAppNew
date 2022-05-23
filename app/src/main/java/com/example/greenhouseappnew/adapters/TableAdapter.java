package com.example.greenhouseappnew.adapters;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.greenhouseappnew.R;
import com.example.greenhouseappnew.model.LogClass;
import com.example.greenhouseappnew.ui.viewmodel.GreenhousesViewModel;

import java.util.List;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder> {

    Context context;
    List<LogClass> logList;

    public TableAdapter(Context context, List<LogClass> logList)
    {
        this.context = context;
        this.logList = logList;
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

    @NonNull
    @Override
    public TableAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.table_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TableAdapter.ViewHolder holder, int position) {
        if(logList != null && logList.size() > 0)
        {
           LogClass logModel = logList.get(position);

           holder.temperature_tv.setText(String.valueOf(logModel.getTemperature()));
           holder.cO2_tv.setText(String.valueOf(logModel.getCo2()));
           holder.humidity_tv.setText(String.valueOf(logModel.getHumidity()));
           holder.date_tv.setText(logModel.getTimeStamp().toString());
        }
    }

    @Override
    public int getItemCount() {
        return logList.size();
    }


}
