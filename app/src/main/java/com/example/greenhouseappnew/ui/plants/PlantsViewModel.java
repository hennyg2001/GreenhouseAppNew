package com.example.greenhouseappnew.ui.plants;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.greenhouseappnew.model.Plant;
import com.example.greenhouseappnew.network.GreenhouseRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PlantsViewModel extends AndroidViewModel {

    private GreenhouseRepository repository;
    private LiveData<List<Plant>> allPlants;

    public PlantsViewModel(@NotNull Application application) {
        super(application);
        repository = new GreenhouseRepository();
        allPlants = repository.getPlantList();
    }

    public LiveData<Plant> get(int id) {
        repository.searchForPlantById(id);
        return repository.getPlant();
    }

    public LiveData<List<Plant>> getAll() {
        return allPlants;
    }

    public void insert(Plant plant) {
        repository.addPlant(plant);
    }

    public void update(Plant plant) {
        repository.updatePlant(plant);
    }

    public void delete(Plant plant) {
        repository.deletePlant(plant.getIdGreenhouse());
    }

}
