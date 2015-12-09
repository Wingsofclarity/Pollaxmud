import static org.junit.Assert.*;
import org.junit.Test;

public class TestPlayer extends TestCase {
    private Player player;
    private int negativeHp;
    private Room room;

    @Test

    public void setUp(){
	this.room = new Room("Testrum");
	this.player = new Player("Testspelare",this.room, new LinkedList<Course>() );
      
    }
    @Test
    public void testCreatePlayer() {
	assertEquals("Player does not get correct hp.", 60, this.player.getHp());
    }
}
