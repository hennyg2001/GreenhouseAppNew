package com.example.sep4_greenhouseapp.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.sep4_greenhouseapp.model.Plant;

import java.util.List;

@Dao
public interface PlantDAO {

    @Query("SELECT * FROM plant")
    List<Plant> getAll();

    @Insert
    void insert(Plant plant);

    @Delete
    void delete(Plant plant);

}
