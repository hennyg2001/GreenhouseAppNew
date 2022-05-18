package com.example.greenhouseappnew.data;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.greenhouseappnew.model.Plant;
import com.example.greenhouseappnew.model.Routine;

import java.util.List;

public interface RoutineDAO {

    @Query("SELECT * FROM routines")
    List<Routine> getAll();

    @Insert
    void insert(Routine routine);

    @Delete
    void delete(Routine routine);

}
