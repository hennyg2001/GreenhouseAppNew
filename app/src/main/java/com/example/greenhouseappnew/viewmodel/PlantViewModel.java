package com.example.greenhouseappnew.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.sep4_greenhouseapp.model.Plant;
import com.example.sep4_greenhouseapp.network.GreenhouseService;
import com.google.firebase.database.annotations.NotNull;

import java.util.List;

public class PlantViewModel extends AndroidViewModel {

    private GreenhouseService service;
    private LiveData<List<Plant>> allPlants;

    public PlantViewModel(@NotNull Application app) {
        super(app);
        service = new GreenhouseService(app);
    }

    public LiveData<Plant> get(int id) {
        return service.get(id);
    }

    public LiveData<List<Plant>> getAll() {
        return allPlants;
    }

    public void insert(Plant plant) {
        service.insert(plant);
    }

    public void update(Plant plant) {
        service.update(plant);
    }

    public void delete(Plant plant) {
        service.delete(plant);
    }

}
