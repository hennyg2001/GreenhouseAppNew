package com.example.greenhouseappnew.Persistence;

import android.app.Application;

import com.example.greenhouseappnew.data.GreenhouseDAO;
import com.example.greenhouseappnew.data.LogDAO;
import com.example.greenhouseappnew.data.PlantDAO;
import com.example.greenhouseappnew.data.RoutineDAO;
import com.example.greenhouseappnew.model.Greenhouse;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RoomRepository {
    private static RoomRepository instance;
    private final GreenhouseDAO greenhouseDAO;
    private final PlantDAO plantDAO;
    private final LogDAO logDAO;
    private final RoutineDAO routineDAO;
    private final ExecutorService  executorService;

    private RoomRepository(Application application)
    {
        GreenhouseDB database = GreenhouseDB.getInstance(application);
        greenhouseDAO = database.greenhouseDAO();
        plantDAO = database.plantDAO();
        logDAO = database.logDAO();
        routineDAO = database.routineDAO();
        executorService = Executors.newFixedThreadPool(8);
    }

    public List<Greenhouse> getAllGreenhouses()
    {
        return greenhouseDAO.getAllGreenhouses();
    }



}
