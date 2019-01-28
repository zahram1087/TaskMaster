package com.zhmohamed.taskmaster.Task;

import android.arch.persistence.room.TypeConverter;

import static com.zhmohamed.taskmaster.Task.Task.Status.ACCEPTED;
import static com.zhmohamed.taskmaster.Task.Task.Status.ASSIGNED;
import static com.zhmohamed.taskmaster.Task.Task.Status.AVAILABLE;
import static com.zhmohamed.taskmaster.Task.Task.Status.FINISHED;

public class StatusConverter {
    @TypeConverter
    public static Task.Status toStatus(int status) {
        if (status == AVAILABLE.getCode()) {
            return AVAILABLE;
        } else if (status == ASSIGNED.getCode()) {
            return ASSIGNED;
        } else if (status == ACCEPTED.getCode()) {
            return ACCEPTED;
        }else if(status == FINISHED.getCode()){
            return FINISHED;
        }
        else {
            throw new IllegalArgumentException("Could not recognize status");
        }
    }

    @TypeConverter
    public static Integer toInteger(Task.Status status) {
        return status.getCode();
    }
}
