package com.zhmohamed.taskmaster.database;

import androidx.room.Database;


import com.zhmohamed.taskmaster.Doas.TaskDao;
import com.zhmohamed.taskmaster.entities.Project;


@Database(entities = {Project.class}, version = 1)
public abstract class TaskDataBase {
    public abstract TaskDao getTaskDao();


}
