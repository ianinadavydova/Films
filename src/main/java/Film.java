package main.java;

import java.io.Serializable;

public class Film implements Serializable {
    private final String title;
    private final Actor mainActor;

    public Film(String title, Actor mainActor) {
        this.title = title;
        this.mainActor = mainActor;
    }

    public Actor getMainActor() {
        return mainActor;
    }

    public String getTitle() {
        return title;
    }
}
