package com.zhmohamed.taskmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.zhmohamed.taskmaster.models.Project;

public class AddProjectActivity extends AppCompatActivity {

//    ProjectDataBase db;
    FirebaseFirestore db;
    private String TAG = "ProjectDatabase";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        db = FirebaseFirestore.getInstance();

    }



    public void onCreateProject(View v) {

        // Get the inputs
        TextView titleView = findViewById(R.id.project_name_input);
        TextView descriptionView = findViewById(R.id.description_input);
        String title = titleView.getText().toString();
        String description = descriptionView.getText().toString();

        // Make the project
        Project theProject = new Project(title, description);

        // add to firebase cloud
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("projects")
                .add(theProject)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });

        // redirect to the main page
        finish();
    }

}
