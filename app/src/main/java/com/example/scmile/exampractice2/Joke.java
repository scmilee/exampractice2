package com.example.scmile.exampractice2;

import java.util.ArrayList;
import java.util.UUID;

public class Joke {
    private ArrayList<String> lines;
    private boolean completed;
    private String title;
    private UUID id;


     public Joke(ArrayList<String> jokeLines){
        this.lines = jokeLines;
    }

    public ArrayList<String> getLines() {
        return lines;
    }

    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public UUID getId() {
        return id;
    }


    public void setTitle(String title) {
        this.title = title;
    }
}
