package com.example.finalproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.LessonViewHolder> {

    private List<Lesson> lessonList;

    public LessonAdapter(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lesson, parent, false);
        return new LessonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonViewHolder holder, int position) {
        Lesson lesson = lessonList.get(position);
        holder.bind(lesson);
    }

    @Override
    public int getItemCount() {
        return lessonList.size();
    }

    static class LessonViewHolder extends RecyclerView.ViewHolder {
        private TextView lessonTitle;
        private TextView lessonDescription;
        private ImageView lessonStatus;

        public LessonViewHolder(@NonNull View itemView) {
            super(itemView);
            lessonTitle = itemView.findViewById(R.id.lessonTitle);
            lessonDescription = itemView.findViewById(R.id.lessonDescription);
            lessonStatus = itemView.findViewById(R.id.lessonStatus);
        }

        public void bind(Lesson lesson) {
            lessonTitle.setText(lesson.getTitle());
            lessonDescription.setText(lesson.getDescription());

            // Set status icon based on lesson status
            if (lesson.isCompleted()) {
                lessonStatus.setImageResource(R.drawable.ic_check_circle);
            } else if (lesson.isUnlocked()) {
                lessonStatus.setImageResource(R.drawable.ic_play_circle);
            } else {
                lessonStatus.setImageResource(R.drawable.ic_lock);
            }

            // Set appropriate alpha for locked lessons
            float alpha = lesson.isUnlocked() ? 1.0f : 0.5f;
            itemView.setAlpha(alpha);

            // Set click listener for unlocked lessons
            if (lesson.isUnlocked()) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Here you would start the lesson activity
                    }
                });
            } else {
                itemView.setOnClickListener(null);
            }
        }
    }
}