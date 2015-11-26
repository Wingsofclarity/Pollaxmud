import java.util.*;

public class Player extends Creature{
    private int hp = 0;
    private LinkedList<Course> unfinishedCourses = new LinkedList<Course>();

    Player(String name, Room room){
	super(name, room);
	hp = 60;
    }

    public int getHp(){
	return hp;
    }

    public LinkedList<Course> getUnfinishedCourses(){
        return unfinishedCourses;
    }

    /*
    @Override
    public void move(Room to){
	super.move(to);
	//System.out.println("I just entered "+location.toString()+location.getDescription());
    }*/

    @Override
    public String toString(){
	return "Player: "+super.toString();
    }
}
