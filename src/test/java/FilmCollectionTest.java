package test.java;

import main.java.Actor;
import main.java.Film;
import main.java.FilmCollection;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FilmCollectionTest {

    private final Actor actor = new Actor("Daniel");
    private final Film film1 = new Film("Harry Potter", actor);
    private final Film film2 = new Film("Skyfall", actor);

    @Test
    public void add() {
        FilmCollection collection = new FilmCollection();
        collection.add(film1);
        assertEquals(film1, collection.get(0));
    }

    @Test
    public void get() {
        FilmCollection collection = new FilmCollection();
        collection.add(film1);
        collection.add(film2);
        assertEquals(film1, collection.get(0));
        assertEquals(film2, collection.get(1));
    }

    @Test
    public void size() {
        FilmCollection collection = new FilmCollection();
        collection.add(film1);
        assertEquals(1, collection.size());
        collection.add(film2);
        assertEquals(2, collection.size());
    }

    @Test
    public void serialization() throws IOException, ClassNotFoundException {
        String filename = "films.bin";
        FilmCollection collection = new FilmCollection();
        collection.add(film1);
        collection.add(film2);
        collection.serialize(filename);
        FilmCollection deserialized = FilmCollection.deserialize(filename);
        assertEquals(2, deserialized.size());
    }

    @Test
    public void sameObject() throws IOException, ClassNotFoundException {
        FilmCollection collection = new FilmCollection();
        String filename = "films.bin";
        collection.add(film1);
        collection.add(film2);
        collection.serialize(filename);
        FilmCollection deserialized = FilmCollection.deserialize(filename);
        assert deserialized.get(0).getMainActor() == deserialized.get(1).getMainActor();
    }
}
