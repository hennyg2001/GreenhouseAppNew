package com.example.greenhouseappnew.ui.greenhouse;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.greenhouseappnew.model.Greenhouse;
import com.example.greenhouseappnew.network.GreenhouseRepository;

import java.util.List;

public class GreenhouseViewModel extends AndroidViewModel {

    private GreenhouseRepository repository;

    public GreenhouseViewModel(@NonNull Application application) {
        super(application);
        repository = new GreenhouseRepository();
    }

    public LiveData<Greenhouse> get(int id) {
        repository.searchForGreenhouseById(id);
        return repository.getGreenhouse();
    }

    public void update(Greenhouse greenhouse) {
        repository.updateGreenhouse(greenhouse);
    }

}
