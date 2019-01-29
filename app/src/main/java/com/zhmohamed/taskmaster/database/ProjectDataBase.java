package com.zhmohamed.taskmaster.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.zhmohamed.taskmaster.entities.Project;
import com.zhmohamed.taskmaster.Doas.ProjectDao;


@Database(entities = {Project.class}, version = 1)
public abstract class ProjectDataBase extends RoomDatabase {
    public abstract ProjectDao getProjectDao();
}
