package com.example.greenhouseappnew.ui.logs;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.greenhouseappnew.model.LogClass;
import com.example.greenhouseappnew.network.GreenhouseRepository;

import java.util.List;

public class LogsViewModel extends AndroidViewModel {

    private GreenhouseRepository repository;
    private LiveData<List<LogClass>> allLogs;

    public LogsViewModel(@NonNull Application application) {
        super(application);
        repository = new GreenhouseRepository();
        allLogs = repository.getLogList();
    }

    public LiveData<LogClass> get(int id) {
        repository.searchForLogsByGreenhouseId(id);
        return repository.getLog();
    }

    public LiveData<List<LogClass>> getAll() {
        return allLogs;
    }

}
