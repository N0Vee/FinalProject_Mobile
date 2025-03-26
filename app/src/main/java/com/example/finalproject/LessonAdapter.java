package com.example.finalproject;

import android.app.Activity;
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

import java.lang.reflect.Array;
import java.util.List;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.LessonViewHolder> {

    private List<Lesson> lessonList;

    private Context context; // Store context
    private Activity activity;

    private static String[] LESSON = {
            "1. ชนิดข้อมูล (Data Types)",
            "2. ตัวแปร (Variables)",
            "3. ตัวดำเนินการ (Operators)",
            "4. คำสั่งควบคุม (Control Statements)",
            "5. ฟังก์ชัน (Function)"
    };
    private boolean[] isCompleted;
    private boolean[] isUnlocked;

    public LessonAdapter(List<Lesson> lessonList, Context context,Activity activity ,boolean[] isCompleted,boolean[] isUnlocked) {
        this.lessonList = lessonList;
        this.context = context;
        this.activity = activity;
        this.isCompleted = isCompleted;
        this.isUnlocked = isUnlocked;
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
        return new LessonViewHolder(view,this.context,this.activity,this.isCompleted,this.isUnlocked);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonViewHolder holder, int position) {
        Lesson lesson = lessonList.get(position);
        holder.bind(lesson, activity);
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
        private boolean[] isCompleted;

        private boolean[] isUnlocked;

        public LessonViewHolder(@NonNull View itemView, Context context, Activity activity,boolean[] isCompleted,boolean[] isUnlocked) {
            super(itemView);
            lessonTitle = itemView.findViewById(R.id.lessonTitle);
            lessonDescription = itemView.findViewById(R.id.lessonDescription);
            lessonStatus = itemView.findViewById(R.id.lessonStatus);
            this.context = context;
            this.isCompleted = isCompleted;
            this.isUnlocked = isUnlocked;
        }

        public int index(String lessonTitle) {
            for (int i = 0; i < LESSON.length; i++) {
                if (LESSON[i].equals(lessonTitle)) {
                    return i;
                }
            }
            return -1;
        }


        public void bind(Lesson lesson,Activity activity) {
            lessonTitle.setText(lesson.getTitle());
            lessonDescription.setText(lesson.getDescription());

            int i = index(lesson.getTitle());
            // Set status icon
            if (this.isCompleted[i]) {
                lessonStatus.setImageResource(R.drawable.ic_check_circle);
            } else if (this.isUnlocked[i]) {
                lessonStatus.setImageResource(R.drawable.ic_play_circle);
            } else {
                lessonStatus.setImageResource(R.drawable.ic_lock);
            }

            // Set alpha
            float alpha = this.isUnlocked[i] ? 1.0f : 0.5f;
            itemView.setAlpha(alpha);


            if (this.isUnlocked[i]) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, LessonCanva.class);
                        intent.putExtra("LESSON_TITLE", lesson.getTitle());
                        context.startActivity(intent);
                        activity.finish();
                    }

                });
            } else {
                itemView.setOnClickListener(null);
            }
        }
    }
}