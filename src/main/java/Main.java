package main.java;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filename = "films.bin";
        FilmCollection collection = new FilmCollection();
        Actor daniel = new Actor("Daniel");

        collection.add(new Film("Harry Potter", daniel, new Actor("Emma"), new Actor("Rupert")));
        collection.add(new Film("Skyfall", daniel));

        collection.serialize(filename);
        FilmCollection deserialized = FilmCollection.deserialize(filename);

        for (int i = 0, n = deserialized.size(); i != n; ++i) {
            Film f = deserialized.get(i);
            System.out.println(f.getTitle() + " " + Arrays.toString(f.getActors()));
        }
    }
}
