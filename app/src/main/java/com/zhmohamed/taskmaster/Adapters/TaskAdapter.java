package com.zhmohamed.taskmaster.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhmohamed.taskmaster.R;
import com.zhmohamed.taskmaster.models.Task;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> taskDataset;

    public static class TaskViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout taskTextView;
        public TaskViewHolder(LinearLayout v) {
            super(v);
            taskTextView = v;
        }
    }

    public TaskAdapter(List<Task> eData){
        taskDataset = eData;
    }

    @NonNull
    @Override
    public TaskAdapter.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LinearLayout exerciseTextView = (LinearLayout)LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.task_text_view, viewGroup, false);

        TaskViewHolder taskViewHolder = new TaskViewHolder(exerciseTextView);
        return taskViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder exerciseViewHolder, int i) {
        Task task = taskDataset.get(i);
        ((TextView)exerciseViewHolder.taskTextView.findViewById(R.id.task_text_view)).setText(task.getTitle());
    }

    @Override
    public int getItemCount() {
        return taskDataset.size();
    }
}
