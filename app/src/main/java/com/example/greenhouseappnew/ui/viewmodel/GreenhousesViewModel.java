package com.example.greenhouseappnew.ui.viewmodel;

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
        repository = new GreenhouseRepository();
        allGreenhouses = repository.getGreenHouseList();
    }

    public LiveData<Greenhouse> get(int id) {
        repository.searchForPlantById(id);
        return repository.getGreenHouse();
    }

    public LiveData<List<Greenhouse>> getAll() {
        return allGreenhouses;
    }

    public LiveData<List<Greenhouse>> getAllByEmail() {
        return allGreenhouses;
    }

    public void insert(Greenhouse greenhouse) {
        repository.addGreenhouse(greenhouse);
    }

    public void update(Greenhouse greenhouse) {
        repository.updateGreenhouse(greenhouse);
    }

    public void delete(Greenhouse greenhouse) {
        repository.deleteGreenhouse(greenhouse.getId());
    }

}
