package com.example.greenhouseappnew.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.greenhouseappnew.model.Plant;
import com.example.greenhouseappnew.model.Routine;

import java.util.List;

@Dao
public interface RoutineDAO {

    @Query("SELECT * FROM Routine WHERE id_Plant = :id")
    LiveData<List<Routine>> getRoutinesByPlantId(int id);

    @Insert
    void insert(Routine routine);

    @Delete
    void delete(Routine routine);

}
