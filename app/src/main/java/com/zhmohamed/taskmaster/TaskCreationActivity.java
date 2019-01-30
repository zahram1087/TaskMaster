package com.zhmohamed.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zhmohamed.taskmaster.database.TaskDataBase;
import com.zhmohamed.taskmaster.entities.Task;
import com.zhmohamed.taskmaster.enums.StatusEnum;

public class TaskCreationActivity extends AppCompatActivity {

    TaskDataBase db;
    Intent intent;
    Bundle extras;
    long projectId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_creation);

        intent = getIntent();
        extras = intent.getExtras();
        projectId = extras.getLong("projectId");


        db = Room.databaseBuilder(getApplicationContext(), TaskDataBase.class, "tasks").allowMainThreadQueries().build();
    }

    public void onCreateTask(View v) {

        // Get the inputs
        TextView titleView = findViewById(R.id.task_name_input);
        String title = titleView.getText().toString();

        // Make the project
        Task theTask = new Task(title, projectId, StatusEnum.Available.toString());

        // Save the project
        db.getTaskDao().insertTask(theTask);

        // End activity
        finish();
    }
}
