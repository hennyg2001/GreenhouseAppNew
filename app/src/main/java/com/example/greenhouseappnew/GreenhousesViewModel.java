package com.example.greenhouseappnew;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.greenhouseappnew.model.Greenhouse;
import com.example.greenhouseappnew.model.Plant;
import com.example.greenhouseappnew.network.GreenhouseService;

import java.util.List;

public class GreenhousesViewModel extends AndroidViewModel {

    private GreenhouseService service;
    private LiveData<List<Greenhouse>> allGreenhouses;

    public GreenhousesViewModel(@NonNull Application application) {
        super(application);
        allGreenhouses = service.getAllGreenhouses();
    }

    public LiveData<Greenhouse> get(int id) {
        return service.get(id);
    }

    public LiveData<List<Greenhouse>> getAll() {
        return allGreenhouses;
    }

    public void insert(Greenhouse greenhouse) {
        service.insert(greenhouse);
    }

    public void update(Greenhouse greenhouse) {
        service.update(greenhouse);
    }

    public void delete(Greenhouse greenhouse) {
        service.delete(greenhouse);
    }

}
