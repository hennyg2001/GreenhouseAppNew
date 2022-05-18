package com.example.greenhouseappnew.ui.plant_profile;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.greenhouseappnew.model.Plant;
import com.example.greenhouseappnew.model.Routine;
import com.example.greenhouseappnew.network.GreenhouseService;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PlantProfileViewModel extends AndroidViewModel {

    public PlantProfileViewModel(@NonNull Application application) {
        super(application);
    }

    private GreenhouseService service;
    private LiveData<List<Routine>> allRoutines;

    public LiveData<Routine> get(int id) {

    }

    public LiveData<List<Routine>> getAll() {

    }

    public void insert(Routine routine) {

    }

    public void update(Routine routine) {

    }

    public void delete(Routine routine) {

    }

}
