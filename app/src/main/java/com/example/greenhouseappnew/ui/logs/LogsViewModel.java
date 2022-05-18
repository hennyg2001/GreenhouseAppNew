package com.example.greenhouseappnew.ui.logs;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.greenhouseappnew.model.Log;
import com.example.greenhouseappnew.model.Plant;
import com.example.greenhouseappnew.network.GreenhouseService;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LogsViewModel extends AndroidViewModel {

    public LogsViewModel(@NonNull Application application) {
        super(application);
    }

    private GreenhouseService service;
    private LiveData<List<Log>> allLogs;

    public LiveData<Log> get(int id) {

    }

    public LiveData<List<Log>> getAll() {

    }

    public void insert(Log log) {

    }

    public void update(Log log) {

    }

    public void delete(Log log) {

    }

}
