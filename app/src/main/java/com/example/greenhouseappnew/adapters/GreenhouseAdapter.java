package com.example.greenhouseappnew.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greenhouseappnew.R;
import com.example.greenhouseappnew.model.Greenhouse;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GreenhouseAdapter extends RecyclerView.Adapter<GreenhouseAdapter.ViewHolder> {

    private OnItemListClicker listener;
    private List<Greenhouse> greenhouses = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.greenhouse_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Greenhouse currentGreenhouse = greenhouses.get(position);
        holder.name.setText(currentGreenhouse.getName());
    }

    @Override
    public int getItemCount() {
        return greenhouses.size();
    }

    public void setGreenhouses(List<Greenhouse> greenhouses) {
        this.greenhouses = greenhouses;
        notifyDataSetChanged();
    }

    public Greenhouse getGreenhouseAt(int position) {
        return greenhouses.get(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;

        private ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(greenhouses.get(position));
                    }
                }
            });
        }

    }

    public interface OnItemListClicker {
        void onItemClick(Greenhouse greenhouse);
    }

    public void setOnItemClickListener(OnItemListClicker listener) {
        this.listener = listener;
    }
}
