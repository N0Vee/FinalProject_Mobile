package com.example.finalproject;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
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

    private Context context; // Store context

    public LessonAdapter(List<Lesson> lessonList, Context context) {
        this.lessonList = lessonList;
        this.context = context;
    }
//    public LessonAdapter(Context context, List<Lesson> lessons) {
//        this.context = context;
//        this.lessonList = lessonList;
//    }

    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lesson, parent, false);
        return new LessonViewHolder(view,context);
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

        private Context context;

        public LessonViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            lessonTitle = itemView.findViewById(R.id.lessonTitle);
            lessonDescription = itemView.findViewById(R.id.lessonDescription);
            lessonStatus = itemView.findViewById(R.id.lessonStatus);
            this.context = context;
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
                        Intent intent = new Intent(context, LessonCanva.class);
                        intent.putExtra("LESSON_TITLE", lesson.getTitle());
                        context.startActivity(intent);
                    }

                });
            } else {
                itemView.setOnClickListener(null);
            }
        }
    }
}