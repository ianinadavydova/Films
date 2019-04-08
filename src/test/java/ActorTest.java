package test.java;

import main.java.Actor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ActorTest {
    @Test
    public void getActorName() {
        String name = "Benedict Cumberbatch";
        Actor actor = new Actor(name);
        assertEquals(name, actor.getName());
    }
}
