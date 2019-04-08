package main.java;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filename = "films.bin";
        FilmCollection collection = new FilmCollection();
        Actor actor = new Actor("Daniel");

        collection.add(new Film("Harry Potter", actor));
        collection.add(new Film("Skyfall", actor));

        collection.serialize(filename);
        FilmCollection deserialized = FilmCollection.deserialize(filename);

        for (int i = 0, n = deserialized.size(); i != n; ++i) {
            Film f = deserialized.get(i);
            System.out.println(f.getTitle() + " " + f.getMainActor().getName());
        }
    }
}
