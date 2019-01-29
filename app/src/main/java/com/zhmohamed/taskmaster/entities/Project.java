package com.zhmohamed.taskmaster.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Project {
    ////source: https://developer.android.com/training/data-storage/room/defining-data

    @PrimaryKey(autoGenerate = true)
    public long projectId;

    public String title;
    public String description;
//    public List<Task> task;

    // empty constructor
    public Project(){}

    //constructor
    public Project(String title, String description){
        this.title = title;
        this.description = description;
    }

    public String toString() {
        return this.title + ": " + this.description;
    }


}
