package com.example.greenhouseappnew.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataKt;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.greenhouseappnew.model.Greenhouse;
import com.example.greenhouseappnew.model.Plant;

import java.util.List;

@Dao
public interface PlantDAO {

    @Query("SELECT * FROM plant_table WHERE id = :id")
    LiveData<Plant> getPlantById(int id);

    @Query("SELECT * FROM plant_table WHERE greenhouseId = :id")
    LiveData<List<Plant>> getPlantsFromGreenhouse(int id);

    @Update
    void updatePlant(Plant plant);

    @Insert
    void insert(Plant plant);

    @Delete
    void delete(Plant plant);

}
