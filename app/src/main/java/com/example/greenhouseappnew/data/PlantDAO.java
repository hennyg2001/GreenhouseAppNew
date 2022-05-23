package com.example.greenhouseappnew.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataKt;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.greenhouseappnew.model.Greenhouse;
import com.example.greenhouseappnew.model.Plant;

import java.util.List;

@Dao
public interface PlantDAO {

    @Query("SELECT * FROM Plant WHERE id = :id")
    LiveData<Plant> getPlantById(int id);

    @Query("SELECT * FROM Plant WHERE id_Greenhouse = :id")
    LiveData<List<Plant>> getPlantsFromGreenhouse(int id);

    @Query("UPDATE Plant SET name = :Name, description = :Description, scientificName = :ScientificName,  id_Greenhouse = :Id_Greenhouse  WHERE id = :id")
    LiveData<Plant> updatePlant(int id, String Name, String ScientificName, String Description, int Id_Greenhouse);

    @Insert
    void insert(Plant plant);

    @Delete
    void delete(Plant plant);

}
