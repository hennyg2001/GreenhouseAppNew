package com.example.greenhouseappnew.ui.plant_profile;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.greenhouseappnew.model.Routine;
import com.example.greenhouseappnew.network.GreenhouseRepository;

import java.util.List;

public class PlantProfileViewModel extends AndroidViewModel {

    private GreenhouseRepository repository;
    private LiveData<List<Routine>> allRoutines;

    public PlantProfileViewModel(@NonNull Application application) {
        super(application);
        repository = new GreenhouseRepository();
        allRoutines = repository.getRoutineList();
    }

    public LiveData<List<Routine>> getRoutinesByPlant(int id) {
        repository.searchForRoutinesById(id);
        return repository.getRoutineList();
    }

    public LiveData<List<Routine>> getAll() {
        return allRoutines;
    }

    public void delete(Routine routine) {
        repository.deleteRoutine(routine.getId());
    }

}
