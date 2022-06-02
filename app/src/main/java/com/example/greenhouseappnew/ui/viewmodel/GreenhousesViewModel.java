package com.example.greenhouseappnew.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.greenhouseappnew.Persistence.RoomRepository;
import com.example.greenhouseappnew.model.Greenhouse;
import com.example.greenhouseappnew.network.GreenhouseRepository;

import java.util.List;

public class GreenhousesViewModel extends AndroidViewModel {

    private RoomRepository repository;
    private GreenhouseRepository greenhouseRepository;
    private LiveData<List<Greenhouse>> allGreenhouses;

    public GreenhousesViewModel(@NonNull Application application) {
        super(application);
        repository = new RoomRepository(application);
        greenhouseRepository = new GreenhouseRepository();
        allGreenhouses = repository.getAllGreenhouses();
    }

    public LiveData<Greenhouse> get(int id) {
        return repository.getGreenhouseById(id);
    }

    public LiveData<List<Greenhouse>> getAll() {
        return allGreenhouses;
    }

    public LiveData<List<Greenhouse>> getAllByEmail(String email) {
        //greenhouseRepository.searchForGreenhouseByEmail(email);
        return repository.getGreenhousesByEmail(email);
    }

    public void insert(Greenhouse greenhouse) {
        repository.insertGreenhouse(greenhouse);
    }

    public void update(Greenhouse greenhouse) {
        repository.updateGreenhouse(greenhouse);
    }

    public void delete(Greenhouse greenhouse) {
        repository.deleteGreenhouse(greenhouse);
    }

}
