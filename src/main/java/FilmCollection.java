package main.java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilmCollection {
    private final List<Film> list = new ArrayList<>();

    public void add(Film film) {
        list.add(film);
    }

    public int size() {
        return list.size();
    }

    public Film get(int i) {
        return list.get(i);
    }

    public void serialize(String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeInt(list.size());
            for (Film f : list)
                out.writeObject(f);
        }
    }

    public static FilmCollection deserialize(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            FilmCollection result = new FilmCollection();
            int n = in.readInt();

            for (int i = 0; i != n; ++i) {
                result.add((Film) in.readObject());
            }

            return result;
        }
    }

}
