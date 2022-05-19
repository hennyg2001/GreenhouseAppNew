package com.example.greenhouseappnew.ui.plant_profile;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.greenhouseappnew.model.Routine;
import com.example.greenhouseappnew.network.GreenhouseRepository;

import java.util.List;

public class PlantProfileViewModel extends AndroidViewModel {

    public PlantProfileViewModel(@NonNull Application application) {
        super(application);
    }

    private GreenhouseRepository repository;
    private LiveData<List<Routine>> allRoutines;

    public LiveData<Routine> get(int id) {
        return repository.getRoutine(id);
    }

    public LiveData<List<Routine>> getAll() {
        return allRoutines;
    }

    public void insert(Routine routine) {
        repository.addRoutine(routine);
    }

    public void update(Routine routine) {
        repository.updateRoutine(routine);
    }

    public void delete(Routine routine) {
        repository.deletRoutine(routine.getId());
    }

}
