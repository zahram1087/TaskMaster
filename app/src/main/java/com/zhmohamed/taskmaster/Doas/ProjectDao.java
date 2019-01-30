package com.zhmohamed.taskmaster.Doas;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.zhmohamed.taskmaster.entities.Project;

import java.util.List;

@Dao
public interface ProjectDao {
    // Gets all projects in the database
    @Query("SELECT * FROM project")
    List<Project> getAllproject();


    @Query("SELECT * FROM project WHERE id=:projectId")
    Project getById(long projectId);

    @Insert
    void insertProject(Project project);

    @Insert
    void insertMultipleProjects (List<Project> projectList);

    @Update
    void updateProject (Project project);

    @Delete
    void delete(Project project);

    //source: https://stackoverflow.com/questions/14018394/android-sqlite-query-getting-latest-10-records
    @Query("SELECT * FROM project order by id DESC limit 1")
    Project getLast();

}
