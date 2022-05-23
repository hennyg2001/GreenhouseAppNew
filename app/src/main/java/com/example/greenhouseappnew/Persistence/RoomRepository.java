package com.example.greenhouseappnew.Persistence;

import android.app.Application;

import com.example.greenhouseappnew.data.GreenhouseDAO;
import com.example.greenhouseappnew.data.LogDAO;
import com.example.greenhouseappnew.data.PlantDAO;
import com.example.greenhouseappnew.data.RoutineDAO;
import com.example.greenhouseappnew.model.Greenhouse;
import com.example.greenhouseappnew.model.LogClass;
import com.example.greenhouseappnew.model.Plant;
import com.example.greenhouseappnew.model.Routine;

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

    public static synchronized RoomRepository getInstance(Application application)
    {
       if(instance == null)
       {
           instance = new RoomRepository(application);
       }
       return instance;
    }

    public List<Greenhouse> getAllGreenhouses()
    {
        return greenhouseDAO.getAllGreenhouses();
    }

    public List<Greenhouse> getGreenhousesByEmail(String email){return greenhouseDAO.getGreenhouseByEmail(email);}

    public Greenhouse getGreenhouseById(int id){return greenhouseDAO.getGreenhouseById(id);}

    public void deleteGreenhouse(Greenhouse greenhouse){executorService.execute(() -> greenhouseDAO.delete(greenhouse));}

    public void insertGreenhouse(Greenhouse greenhouse){executorService.execute(() -> greenhouseDAO.insert(greenhouse));}

    public void updateGreenhouse(Greenhouse greenhouse){executorService.execute(() -> greenhouseDAO.updateGreenhouse(greenhouse));}

    public List<LogClass> getLogsByGreenhouseId(int id){return logDAO.getLogsByGreenhouseId(id);}

    public LogClass getLogById(int id) {return  logDAO.getLogById(id);}

    public void deleteLog(LogClass log){executorService.execute(() -> logDAO.delete(log));}

    public void insertLog(LogClass log){executorService.execute(() -> logDAO.insert(log));}

    public Plant getPlantById(int id){ return plantDAO.getPlantById(id);}

    public void updatePlant(Plant plant){executorService.execute(() -> plantDAO.insert(plant));}

    public void deletePlant(Plant plant){executorService.execute(() -> plantDAO.delete(plant));}

    public void insertPlant(Plant plant){executorService.execute(() -> plantDAO.insert(plant));}

    public List<Routine> getRoutinesByPlantId(int id){return routineDAO.getRoutinesByPlantId(id);}

    public void deleteRoutine(Routine routine){executorService.execute(() -> routineDAO.delete(routine));}

    public void insertRoutine(Routine routine){executorService.execute(() -> routineDAO.insert(routine));}









}
