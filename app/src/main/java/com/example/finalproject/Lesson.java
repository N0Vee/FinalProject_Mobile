package com.example.finalproject;

public class Lesson {
    private String title;
    private String description;
    private boolean isUnlocked;
    private boolean isCompleted;

    public Lesson(String title, String description, boolean isUnlocked, boolean isCompleted) {
        this.title = title;
        this.description = description;
        this.isUnlocked = isUnlocked;
        this.isCompleted = isCompleted;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isUnlocked() {
        return isUnlocked;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}