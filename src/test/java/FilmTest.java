package test.java;

import main.java.Actor;
import main.java.Film;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FilmTest {
    private final String title = "Scherlock";
    private final Actor holmes = new Actor("Benedict Cumberbatch");
    private final Actor watson = new Actor("Matrin Friman");
    private final Film film = new Film(title, holmes, watson);

    @Test
    public void getTitle() {
        assertEquals(title, film.getTitle());
    }

    @Test
    public void getMainActor() {
        Actor[] actors = film.getActors();
        assertEquals(actors.length, 2);
        assertEquals(actors[0], holmes);
        assertEquals(actors[1], watson);
    }
}
