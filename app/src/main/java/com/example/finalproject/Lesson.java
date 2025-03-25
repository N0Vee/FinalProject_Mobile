package com.example.finalproject;

import android.content.Context;

import java.util.HashMap;

public class Lesson {

    private String title;
    private String description;
    private boolean isUnlocked;
    private boolean isCompleted;
    private HashMap<Integer, HashMap<String, String>> pages; // Page storage

    public Lesson(String title, String description) {
        this.title = title;
        this.description = description;
        this.isUnlocked = true;
        this.isCompleted = true;
        this.pages = new HashMap<>();
    }

    // Add content to a specific page
    public void addPageContent(int page, String parameter, String content) {
        pages.putIfAbsent(page, new HashMap<>());
        pages.get(page).put(parameter, content);
    }

    // Get content of a page based on parameter (e.g., "title", "content")
    public String getPageContent(int page, String parameter) {
        if (pages.containsKey(page) && pages.get(page).containsKey(parameter)) {
            return pages.get(page).get(parameter);
        }
        return "Page not found";
    }

    // Get maximum page number
    public int getMaxPage() {
        return pages.isEmpty() ? 0 : pages.keySet().stream().max(Integer::compare).orElse(0);
    }

    public void setUnlocked(boolean Boolean){
        this.isUnlocked = Boolean;
    }

    public void setCompleted(boolean Boolean){
        this.isCompleted = Boolean;
    }

    // Getters for basic lesson info
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public boolean isUnlocked() { return isUnlocked; }
    public boolean isCompleted() { return isCompleted; }
}
