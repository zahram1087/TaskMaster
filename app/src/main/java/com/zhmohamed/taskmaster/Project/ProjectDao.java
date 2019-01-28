package com.zhmohamed.taskmaster.Project;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.zhmohamed.taskmaster.Project.Project;

import java.util.List;

@Dao
public interface ProjectDao {
    // Gets all projects in the database
    @Query("SELECT * FROM project")
    List<Project> getAllproject();


    @Query("SELECT * FROM project WHERE id=:id")
    Project getById(long id);

    @Insert
    void insertAll(Project project);

    @Delete
    void delete(Project project);

    //source: https://stackoverflow.com/questions/14018394/android-sqlite-query-getting-latest-10-records
    @Query("SELECT * FROM project order by id DESC limit 1")
    Project getLast();

}
