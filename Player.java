import java.util.*;

public class Player extends Creature{
    private int hp = 0;
    private LinkedList<Course> unfinishedCourses = new LinkedList<Course>();
    private LinkedList<Course> completedCourses = new LinkedList<>();
    private Backpack backpack = new Backpack();

    Player(String name, Room room, LinkedList<Course> completedCourses){
	super(name, room);
	hp = 60;
        completedCourses = completedCourses;
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


    public Course getRandCourse(LinkedList<Course> courses){
        int size = courses.size();

	if(size == 0){
	    System.out.println(toString());
	    ErrorControl.error();
	}

        Random random = new Random();
        int randomCourse = random.nextInt(size);
	return courses.get(randomCourse);
    }

}
