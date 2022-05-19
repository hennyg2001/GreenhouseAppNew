package com.example.greenhouseappnew.ui.plants;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.greenhouseappnew.model.Greenhouse;
import com.example.greenhouseappnew.model.Plant;
import com.example.greenhouseappnew.network.GreenhouseRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PlantsViewModel extends AndroidViewModel {

    private GreenhouseRepository repository;
    private MutableLiveData<List<Plant>> allPlants;

    public PlantsViewModel(@NotNull Application application) {
        super(application);
        repository = new GreenhouseRepository();
        allPlants = repository.getPlantList();
    }

    public MutableLiveData<Plant> get(int id) {

    }

    public MutableLiveData<List<Plant>> getAll() {
        return allPlants;
    }

    public void insert(Plant plant) {
        repository.addPlant(plant);
    }

    public void update(Plant plant) {
        repository.updatePlant(plant);
    }

    public void delete(Plant plant) {
        repository.deletePlant(plant.getId());
    }

}
