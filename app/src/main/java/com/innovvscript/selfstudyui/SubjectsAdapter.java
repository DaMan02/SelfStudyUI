package com.innovvscript.selfstudyui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SubjectsAdapter extends RecyclerView.Adapter<SubjectsAdapter.MyViewHolder> {

    private List<Subject> subjectList;

    public SubjectsAdapter(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.subjects_list_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Subject sub = subjectList.get(position);
        holder.logo.setImageResource(sub.getResource());
        holder.title.setText(sub.getTitle());
        holder.percent.setText(sub.getPercent() + "%");
    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }

     class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView logo;
        private TextView title, percent;
         MyViewHolder(@NonNull View view) {
            super(view);
            logo = view.findViewById(R.id.sub_image);
            title = view.findViewById(R.id.sub_title);
            percent = view.findViewById(R.id.sub_progress_percent);
        }
    }
}
