package com.example.greenhouseappnew.ui.graphs;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.greenhouseappnew.model.LogClass;
import com.example.greenhouseappnew.network.GreenhouseRepository;

import java.util.List;

public class GraphViewModel extends AndroidViewModel
{
    private GreenhouseRepository repository;

    public GraphViewModel(@NonNull Application application) {
        super(application);

        repository = GreenhouseRepository.getInstance();
    }

    public LiveData<List<LogClass>> getLogList() {
        return repository.getLogList();
    }

    public void serachForLogsByGreenhouseId(int id) {
        repository.searchForLogsByGreenhouseId(id);

    }




}
