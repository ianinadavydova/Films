package test.java;

import main.java.Actor;
import main.java.Film;
import main.java.FilmCollection;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FilmCollectionTest {

    private final Actor daniel = new Actor("Daniel");
    private final Film potter = new Film("Harry Potter", daniel, new Actor("Emma"), new Actor("Rupert"));
    private final Film skyfall = new Film("Skyfall", daniel);

    @Test
    public void add() {
        FilmCollection collection = new FilmCollection();
        collection.add(potter);
        assertEquals(collection.size(), 1);
        assertEquals(potter, collection.get(0));
    }

    @Test
    public void get() {
        FilmCollection collection = new FilmCollection();
        collection.add(potter);
        collection.add(skyfall);
        assertEquals(collection.size(), 2);
        assertEquals(potter, collection.get(0));
        assertEquals(skyfall, collection.get(1));
    }

    @Test
    public void size() {
        FilmCollection collection = new FilmCollection();
        collection.add(potter);
        assertEquals(1, collection.size());
        collection.add(skyfall);
        assertEquals(2, collection.size());
    }

    @Test
    public void serialization() throws IOException, ClassNotFoundException {
        String filename = "films.bin";
        FilmCollection collection = new FilmCollection();
        collection.add(potter);
        collection.add(skyfall);
        collection.serialize(filename);
        FilmCollection deserialized = FilmCollection.deserialize(filename);
        assertEquals(2, deserialized.size());
    }

    @Test
    public void sameObject() throws IOException, ClassNotFoundException {
        FilmCollection collection = new FilmCollection();
        String filename = "films.bin";
        collection.add(potter);
        collection.add(skyfall);
        collection.serialize(filename);
        FilmCollection deserialized = FilmCollection.deserialize(filename);
        assertEquals(2, deserialized.size());
        Actor[] actors0 = deserialized.get(0).getActors(), actors1 = deserialized.get(1).getActors();
        assertEquals(actors0.length, 3);
        assertEquals(actors1.length, 1);
        assertEquals(actors0[0], actors1[0]);
    }
}
