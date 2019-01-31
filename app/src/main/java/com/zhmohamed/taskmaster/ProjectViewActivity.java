package com.zhmohamed.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zhmohamed.taskmaster.Adapters.TaskAdapter;
import com.zhmohamed.taskmaster.models.Project;
import com.zhmohamed.taskmaster.models.Task;

import java.util.List;

public class ProjectViewActivity extends AppCompatActivity {

    private RecyclerView taskList;
    private TaskAdapter taskAdapter;
    private RecyclerView.LayoutManager taskLayoutManager;
    private List<Task> tasks;
    TaskDataBase taskDB;
    ProjectDataBase projectDB;
    Intent intent;
    Bundle extras;
    long projectId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_view);


        intent = getIntent();
        extras = intent.getExtras();
        projectId = extras.getLong("projectId");


        projectDB = Room.databaseBuilder(getApplicationContext(), ProjectDataBase.class, "projects").allowMainThreadQueries().build();
        taskDB = Room.databaseBuilder(getApplicationContext(), TaskDataBase.class, "tasks").allowMainThreadQueries().build();

        Project theProject = projectDB.getProjectDao().getById(projectId);

        TextView projectTitle = findViewById(R.id.project_view_name_text);

        projectTitle.setText(theProject.getTitle());

        tasks = taskDB.getTaskDao().getTasksByProjectId(projectId);

        taskList = findViewById(R.id.task_recycler_view);

        // recycler view won't resize for content
        taskList.setHasFixedSize(true);

        // linear layout manager
        taskLayoutManager = new LinearLayoutManager(this);
        taskList.setLayoutManager(taskLayoutManager);

        // the adapter for the recycler view
        taskAdapter = new TaskAdapter(tasks);
        taskList.setAdapter(taskAdapter);


    }


    public void onAddTaskClick (View v) {

        Intent taskAddIntent = new Intent(this, TaskCreationActivity.class);
        taskAddIntent.putExtra("projectId", projectId);
        startActivityForResult(taskAddIntent, 1990);

    }
}
