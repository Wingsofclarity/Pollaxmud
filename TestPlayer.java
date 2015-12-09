import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import junit.framework.TestCase;

public class TestPlayer extends TestCase {
    private Player player;
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
        assertEquals("New player does not get correct hp.", 60, this.player.getHp());
        assertEquals("New player does not get correct number of keys.", 0, this.player.getKeys());
        assertTrue("New player does not get correct completed courses.", this.player.hasCompleted(this.course));
        assertTrue("New player gets unfinished courses (should have none).", this.player.getUnfinishedCourses().isEmpty());
    }

    public void testSetHp(){
        int initialHp = player.getHp();
        player.setHp(-(initialHp+1));
        assertTrue("Possible to get negative hp.", player.getHp() >= 0);
        player.setHp(180 + 2);
        assertTrue("Possible to collect more than 180 hp.", player.getHp() <= 180);
    }


    public void testEnroll(){
        player.enroll(course);
        assertTrue("Does not register player for course.", player.getUnfinishedCourses().contains(course));
    }
}
