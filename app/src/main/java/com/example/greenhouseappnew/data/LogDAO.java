package com.example.greenhouseappnew.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.greenhouseappnew.model.LogClass;

import java.util.List;

@Dao
public interface LogDAO {

    @Query("SELECT * FROM Logs WHERE id_Greenhouse = :id")
    LiveData<List<LogClass>> getLogsByGreenhouseId(int id);

    @Query("SELECT * FROM Logs WHERE id = :id")
    LiveData<LogClass> getLogById(int id);


    @Insert
    void insert(LogClass logClass);

    @Delete
    void delete(LogClass logClass);

}
