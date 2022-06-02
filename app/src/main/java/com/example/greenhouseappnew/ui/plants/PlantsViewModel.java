package com.example.greenhouseappnew.ui.plants;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.greenhouseappnew.Persistence.RoomRepository;
import com.example.greenhouseappnew.model.Plant;
import com.example.greenhouseappnew.network.GreenhouseRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PlantsViewModel extends AndroidViewModel {

    private RoomRepository repository;
    private GreenhouseRepository greenhouseRepository;
    private LiveData<List<Plant>> allPlants;

    public PlantsViewModel(@NotNull Application application) {
        super(application);
        repository = new RoomRepository(application);
        greenhouseRepository = new GreenhouseRepository();
        allPlants = greenhouseRepository.getPlantList();
    }

    public LiveData<Plant> get(int id) {
        return repository.getPlantById(id);
    }

    public LiveData<List<Plant>> getAllPlantsByGreenhouse(int id) {
        greenhouseRepository.searchForPlantsByGreenhouseId(id);
        return greenhouseRepository.getPlantList();
    }

    public LiveData<List<Plant>> getAllPlants() {
        return allPlants;
    }

    public void insert(Plant plant) {
        greenhouseRepository.addPlant(plant);
    }

    public void update(Plant plant) {
        greenhouseRepository.updatePlant(plant);
    }

    public void delete(Plant plant) {
        greenhouseRepository.deletePlant(plant.getId());
    }

}
