import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import junit.framework.TestCase;

public class TestPlayer extends TestCase {
    private Player player;
    private int negativeHp;
    private Room room;
    private Course course;

  public void setUp(){
      this.room = new Room("Testrum");
      this.course = new Course("1", "Testkurs", 50);
      LinkedList<Course> courses = new LinkedList<>();
      courses.add(course);
      this.player = new Player("Testspelare",this.room, courses);
  }

  public void testCreatePlayer() {
      assertEquals("Player does not get correct hp.", 60, this.player.getHp());
  }
}
