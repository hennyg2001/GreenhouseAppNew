package com.example.greenhouseappnew.ui.plant_profile;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.greenhouseappnew.model.Plant;
import com.example.greenhouseappnew.network.GreenhouseService;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PlantProfileViewModel extends AndroidViewModel {

    public PlantProfileViewModel(@NonNull Application application) {
        super(application);
    }

    private GreenhouseService service;
    private LiveData<List<Routines>> routines;

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
