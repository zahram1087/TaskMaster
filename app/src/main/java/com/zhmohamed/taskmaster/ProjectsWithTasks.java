package com.zhmohamed.taskmaster;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.zhmohamed.taskmaster.entities.Project;
import com.zhmohamed.taskmaster.entities.Task;

import java.util.List;

// Note: No annotation required at this class definition.
//source:https://stackoverflow.com/questions/44330452/android-persistence-room-cannot-figure-out-how-to-read-this-field-from-a-curso/44424148#44424148
public class ProjectsWithTasks {

    @Embedded
    public Project project;

    @Relation(parentColumn = "id", entityColumn = "projectId", entity = Task.class)
    public List<Task> tasks;
}
