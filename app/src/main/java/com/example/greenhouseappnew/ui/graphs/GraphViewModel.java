package com.example.greenhouseappnew.ui.graphs;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.greenhouseappnew.model.Greenhouse;
import com.example.greenhouseappnew.model.LogClass;
import com.example.greenhouseappnew.model.LogListResponse;
import com.example.greenhouseappnew.network.GreenhouseRepository;

import java.util.List;

public class GraphViewModel extends AndroidViewModel
{
    private GreenhouseRepository repository;
    private MutableLiveData<List<LogClass>> allLogs;

    public GraphViewModel(@NonNull Application application) {
        super(application);
        repository = GreenhouseRepository.getInstance();
        allLogs = repository.getLogList();
    }

    public LiveData<List<LogClass>> getLogList() {
        return allLogs;
    }

    public LiveData<List<LogClass>> getAllLogsById(int id) {
        repository.searchForLogsByGreenhouseId(id);
        return repository.getLogList();
    }

}
