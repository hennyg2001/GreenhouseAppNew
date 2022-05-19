package com.example.greenhouseappnew;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.greenhouseappnew.model.Greenhouse;
import com.example.greenhouseappnew.network.GreenhouseRepository;

import java.util.List;

public class GreenhousesViewModel extends AndroidViewModel {

    private GreenhouseRepository repository;
    private MutableLiveData<List<Greenhouse>> allGreenhouses;

    public GreenhousesViewModel(@NonNull Application application) {
        super(application);
        repository = new GreenhouseRepository();
        allGreenhouses = repository.getGreenhouseList();
    }

    public MutableLiveData<Greenhouse> get(int id) {
        return repository.getGreenhouse();
    }

    public MutableLiveData<List<Greenhouse>> getAll() {
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
