package com.zhmohamed.taskmaster.Adapters;


import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhmohamed.taskmaster.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>{
    private List<String> projectDataset;

    public static class ProjectViewHolder extends RecyclerView.ViewHolder {


        public LinearLayout projectTextView;
        public ProjectViewHolder(LinearLayout v) {
            super(v);
            projectTextView = v;
        }
    }


    public ProjectAdapter(List<String> eData){
        projectDataset = eData;
    }


    @NonNull
    @Override
    public ProjectAdapter.ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LinearLayout exerciseTextView = (LinearLayout)LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.project_text_view, viewGroup, false);

        ProjectViewHolder projectViewHolder = new ProjectViewHolder(exerciseTextView);
        return projectViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder exerciseViewHolder, int i) {
        ((TextView)exerciseViewHolder.projectTextView.findViewById(R.id.project_text_view)).setText(projectDataset.get(i));
    }

    @Override
    public int getItemCount() {
        return projectDataset.size();
    }
}
