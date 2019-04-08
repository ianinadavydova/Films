package test.java;

import main.java.Actor;
import main.java.Film;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FilmTest {
    private final String title = "Scherlock";
    private final Actor actor = new Actor("Benedict Cumberbatch");
    private final Film film = new Film(title, actor);

    @Test
    public void getTitle() {
        assertEquals(title, film.getTitle());
    }

    @Test
    public void getMainActor() {
        assertEquals(actor, film.getMainActor());
    }
}
