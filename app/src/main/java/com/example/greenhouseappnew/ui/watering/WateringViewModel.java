package com.example.greenhouseappnew.ui.watering;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.example.greenhouseappnew.network.GreenhouseRepository;

import org.jetbrains.annotations.NotNull;

public class WateringViewModel extends AndroidViewModel {

    private GreenhouseRepository repository;

    public WateringViewModel(@NotNull Application application) {
        super(application);
        repository = new GreenhouseRepository();
    }

    public void activateWatering(int id) {
        // repository.activateWatering(id);
    }

}
