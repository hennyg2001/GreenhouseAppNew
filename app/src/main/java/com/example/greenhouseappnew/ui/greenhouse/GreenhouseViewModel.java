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
    }

    public LiveData<Greenhouse> get(int id) {

    }

    public LiveData<List<Greenhouse>> getAll() {

    }

    public void insert(Greenhouse greenhouse) {

    }

    public void update(Greenhouse greenhouse) {

    }

    public void delete(Greenhouse greenhouse) {

    }

}
