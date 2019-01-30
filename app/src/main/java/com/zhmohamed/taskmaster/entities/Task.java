package com.zhmohamed.taskmaster.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

//source:https://stackoverflow.com/questions/44498616/android-architecture-components-using-enums
//source:https://android.jlelse.eu/android-architecture-components-room-relationships-bf473510c14a

//creating MANY-TO-ONE relationship

@Entity(foreignKeys = @ForeignKey(entity = Project.class,
        parentColumns = "id",
        childColumns = "projectId",
        onDelete = CASCADE))

public class Task {
    @NonNull
    @PrimaryKey(autoGenerate = true)

    private long taskId; // Task id


    //associating parent project
    private long projectId; // Project id
    private String title;
    private String status;


    // empty constructor
    public Task() {
    }

    public Task(String title, long projectId, String status) {
        this.title = title;
        this.projectId = projectId;
        this.status = status;

    }


    public String toString() {
        return this.title + ": " ;
    }


    //getters and setters
    public long getTaskId() {
        return this.taskId;
    }

    public long getProjectId() {
        return this.projectId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getStatus() {
        return this.status;
    }

    public void setTaskId(long id) {
        this.taskId = id;
    }

    public void setProjectId(long id) {
        this.projectId = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}



