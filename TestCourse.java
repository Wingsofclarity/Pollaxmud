import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import junit.framework.TestCase;

public class TestCourse extends TestCase {
    private Course c1;
    private Course c2;
    private Course c3;
    private Course c4;

    public void setUp(){
	c1 = new Course();
	c2 = new Course("Course2");
	c3 = new Course("01", "Course3", 60);
	c4 = new Course("01", "Course4", 50);

	LinkedList<String> answers = new LinkedList<String>();
	answers.add("a1");
	answers.add("a2");
	answers.add("a3");
	answers.add("a4");
	c4.addQuestion("This is a uqestion?",answers,0);
    }

    public void testEquality(){
	assertEquals("c3!=c3", c3, c3);
	assertEquals("c3!=c4", c3, c4);
	assertNotEquals("c3==c1", c3, c1);

	assertEquals("getId", c3.getId(), c4.getId());
	assertNotEquals("getId", c1.getId(), c4.getId());
    }

    public void testQuestions(){
	assertEquals("c1 numQuestions", c1.numQuestions(), 0);
	assertEquals("c4 numQuestions", c4.numQuestions(), 1);
	assertEquals("c4 right answer", c4.ask(), 0);

    }

    public void testHp(){
	assertEquals("c3.getHp()", c3.getHp(), 60);
	c3.setHp(70);
	assertEquals("c3.getHp()", c3.getHp(), 70);
	c3.setHp(-10);
	assertEquals("c3.getHp()", c3.getHp(), 0);
    }
    
}
