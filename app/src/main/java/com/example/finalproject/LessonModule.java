package com.example.finalproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LessonModule {
    private static final HashMap<String, Lesson> lessons = new HashMap<>();

    static {
        Lesson lesson1 = new Lesson("1. ชนิดข้อมูล (Data Types)", "JavaScript data types & usage", true, false);
        lesson1.addPageContent(1, "title", "Introduction to Data Types!");
        lesson1.addPageContent(1, "content", "This Content's About Data Types");

        Lesson lesson2 = new Lesson("2. ตัวแปร (Variables)", "Declaring and using variables", false, false);
        lesson2.addPageContent(1, "title", "Introduction to Variables");
        lesson2.addPageContent(1, "content", "This Content's About Variables.");

        lessons.put("Lesson1", lesson1);
        lessons.put("Lesson2", lesson2);
    }

    // New method to get all lessons as a List
    public static List<Lesson> getAllLessons() {
        return new ArrayList<>(lessons.values());
    }

    public static String getLessonContent(String lessonTitle, int page, String parameter) {
        Lesson lesson = lessons.get(lessonTitle);
        return (lesson != null) ? lesson.getPageContent(page, parameter) : "Lesson not found";
    }

    public static int getMaxPage(String lessonTitle) {
        Lesson lesson = lessons.get(lessonTitle);
        return (lesson != null) ? lesson.getMaxPage() : -1;
    }
}
