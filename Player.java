import java.util.*;

public class Player extends Creature{
    private int hp = 0;
    private LinkedList<Course> unfinishedCourses = new LinkedList<Course>();
    private LinkedList<Course> completedCourses = new LinkedList<>();
    private LinkedList<Item> backpack = new LinkedList<>();

    Player(String name, Room room, LinkedList<Course> completedCourses){
	super(name, room);
	hp = 60;
        completedCourses = completedCourses;
    }

    public int getHp(){
	return hp;
    }

    public void setHp(int a){
	this.hp=a;
    }

    public LinkedList<Course> getUnfinishedCourses(){
        return unfinishedCourses;
    }

    public LinkedList<Course> getCompletedCourses(){
	return completedCourses;
    }


    public Boolean hasCompleted(Course c){
        return completedCourses.contains(c);
    }

    public Boolean hasNotFinished(Course c){
        return unfinishedCourses.contains(c);
    }

    public int getKeys(){
	ErrorControl.error();
	return 1;
    }
    public LinkedList<Item> getBackpack(){
        return backpack;
    }

    public LinkedList<Book> getBooks(){
	LinkedList<Book> books = new LinkedList<>();
	Iterator<Item> iterBackpack = backpack.iterator();

	for(int i = 0; i < backpack.size(); i++){
	    Item current = iterBackpack.next();
	    if(current instanceof Book){
		books.add((Book)current);
	    }
	}
	return books;
    }

    public void enroll(Course c){
	unfinishedCourses.add(c);
    }

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
