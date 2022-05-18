package com.example.greenhouseappnew.ui.plants;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.greenhouseappnew.model.Plant;
import com.example.greenhouseappnew.network.GreenhouseService;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PlantsViewModel extends AndroidViewModel {

    private GreenhouseService service;
    private LiveData<List<Plant>> allPlants;

    public PlantsViewModel(@NotNull Application application) {
        super(application);
    }

    public LiveData<Plant> get(int id) {

    }

    public LiveData<List<Plant>> getAll() {

    }

    public void insert(Plant plant) {

    }

    public void update(Plant plant) {

    }

    public void delete(Plant plant) {

    }

}
