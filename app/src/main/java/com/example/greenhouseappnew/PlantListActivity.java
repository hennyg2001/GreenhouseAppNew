package com.example.greenhouseappnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greenhouseappnew.model.Plant;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class PlantListActivity extends AppCompatActivity implements PlantAdapter.OnListItemClicker {

    RecyclerView recyclerView;
    FloatingActionButton myFab;
    static ArrayList<Plant> plants = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plants_list);
        recyclerView = findViewById(R.id.rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();

        plants.add(new Plant("Sunflower", "Flower", "gg1"));
        plants.add(new Plant("Rose", "Flower", "gg2"));
        plants.add(new Plant("Fern", "Bush", "gg3"));

        PlantAdapter adapter = new PlantAdapter(plants, this);
        recyclerView.setAdapter(adapter);

        myFab = findViewById(R.id.fab);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(PlantListActivity.this, CreatePlantActivity.class));            }
        });
    }

    public static ArrayList<Plant> getPlants() {
        return plants;
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    @Override
    public void onClick(int position) {
        startActivity(new Intent(PlantListActivity.this, PlantActivity.class));
    }

}
