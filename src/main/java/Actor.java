package main.java;

import java.io.Serializable;

public class Actor implements Serializable {
    private final String name;

    public Actor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
