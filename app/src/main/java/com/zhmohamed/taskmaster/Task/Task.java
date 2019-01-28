package com.zhmohamed.taskmaster.Task;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.os.AsyncTask;

import com.zhmohamed.taskmaster.Project.Project;

import static android.arch.persistence.room.ForeignKey.CASCADE;

//source:https://stackoverflow.com/questions/44498616/android-architecture-components-using-enums

//source:https://android.jlelse.eu/android-architecture-components-room-relationships-bf473510c14a
//creating MANY-TO-ONE relationship
//
//@Entity(foreignKeys = @ForeignKey(entity = Project.class,
//        parentColumns = "id",
//        childColumns = "projectId",
//        onDelete = CASCADE))
@Entity
public class Task {

    @PrimaryKey(autoGenerate = true)

    public long id; // Task id

    public long projectId; //// Project id

    public String title;
    public String description;

    /** Status of the given task.
     * Enumerated Values: 0 (AVAILABLE), 1 (ASSIGNED), 2 (ACCEPTED), 3(FINISHED)
     */
    @Embedded
    AsyncTask.Status status;


    @TypeConverters(StatusConverter.class)
    public enum Status {
        AVAILABLE(0),
        ASSIGNED(1),
        ACCEPTED(2),
        FINISHED(3);

        private int code;
        Status(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    // empty constructor
    public Task(){}

    public Task(String title, String description){
        this. title = title;
        this.description = description;


    }

    public String toString() {
        return this.title + ": " + this.description;
    }
}
