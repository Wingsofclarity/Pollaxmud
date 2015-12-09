import static org.junit.Assert.*;
import org.junit.Test;

public class TestPlayer extends TestCase {
  @Test
  private Player player;
    private int negativeHp;
    private Room room;

  public void setUp(){
      this.room = new Room("Testrum");
      this.player = new Player("Testspelare",this.room, new LinkedList<Course>() )
  }

  public void testCreatePlayer() {
      assertEquals("Player does not get correct hp.", 60, this.player.getHp());
  }
}
