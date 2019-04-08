package main.java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilmCollection {
    private final List<Film> list = new ArrayList<>();

    public void add(Film f) {
        list.add(f);
    }

    public int size() {
        return list.size();
    }

    public Film get(int i) {
        return list.get(i);
    }

    public void serialize(String filename) throws IOException {
        FileOutputStream file = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(file);

        out.writeInt(list.size());
        for (Film f : list)
            out.writeObject(f);

        out.close();
    }

    public static FilmCollection deserialize(String filename) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(file);

        FilmCollection result = new FilmCollection();
        int n = in.readInt();

        for (int i = 0; i != n; ++i) {
            result.add((Film) in.readObject());
        }

        in.close();
        return result;
    }

}
