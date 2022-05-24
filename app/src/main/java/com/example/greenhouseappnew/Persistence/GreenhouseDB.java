package com.example.greenhouseappnew.Persistence;


import android.content.Context;

import androidx.room.Database;

import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.example.greenhouseappnew.data.GreenhouseDAO;
import com.example.greenhouseappnew.data.LogDAO;
import com.example.greenhouseappnew.data.PlantDAO;
import com.example.greenhouseappnew.data.RoutineDAO;
import com.example.greenhouseappnew.model.Greenhouse;
import com.example.greenhouseappnew.model.LogClass;
import com.example.greenhouseappnew.model.Plant;
import com.example.greenhouseappnew.model.Routine;


@Database(entities = {Greenhouse.class, Plant.class, Routine.class, LogClass.class}, version = 1)
public abstract class GreenhouseDB extends RoomDatabase {

    private static GreenhouseDB instance;

    public abstract GreenhouseDAO greenhouseDAO();
    public abstract LogDAO logDAO();
    public abstract PlantDAO plantDAO();
    public abstract RoutineDAO routineDAO();

    public static synchronized GreenhouseDB getInstance(Context context)
    {
        if(instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    GreenhouseDB.class, "greenhouse_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }



}
