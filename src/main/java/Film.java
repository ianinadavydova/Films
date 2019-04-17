package main.java;

import java.io.Serializable;

public class Film implements Serializable {
    private final String title;
    private final Actor[] actors;

    public Film(String title, Actor... actors) {
        this.title = title;
        this.actors = actors;
    }

    public Actor[] getActors() {
        return actors;
    }

    public String getTitle() {
        return title;
    }
}
