package com.example.greenhouseappnew;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.greenhouseappnew.model.Greenhouse;
import com.example.greenhouseappnew.network.GreenhouseRepository;

import java.util.List;

public class GreenhousesViewModel extends AndroidViewModel {

    private GreenhouseRepository repository;
    private LiveData<List<Greenhouse>> allGreenhouses;

    public GreenhousesViewModel(@NonNull Application application) {
        super(application);
        repository = new GreenhouseRepository(app);
        allGreenhouses = repository.getAllGreenhouses();
    }

    public LiveData<Greenhouse> get(int id) {
        return repository.getAllGreenhouses();
    }

    public LiveData<List<Greenhouse>> getAll() {
        return allGreenhouses;
    }

    public void insert(Greenhouse greenhouse) {
        repository.addGreenhouse(greenhouse);
    }

    public void update(Greenhouse greenhouse) {
        repository.updateGreenhouse(greenhouse);
    }

    public void delete(Greenhouse greenhouse) {
        repository.removeGreenhouse(greenhouse);
    }

}
