import java.util.*;

public class Player extends Creature{
    private int hp = 0;
    private LinkedList<Course> unfinishedCourses = new LinkedList<Course>();
    private LinkedList<Course> completedCourses = new LinkedList<Course>();
    private LinkedList<Item> backpack = new LinkedList<Item>();
    private int keys = 0;

    Player(String name, Room room, LinkedList<Course> completedCourses){
	super(name, room);
	hp = 60;
        completedCourses = completedCourses;
    }

    public int getHp(){
	return hp;
    }

    public void setHp(int a){
	if (a>180) a=180;
	if (a<0) a=0;
	this.hp=a;
    }

    public void increaseHp(int a){
	setHp(getHp()+a);
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
	return keys;
    }
    
    public LinkedList<Item> getBackpack(){
        return backpack;
    }

    public boolean hasBookWithSubject(Course course){
	Item[] bp = backpack.toArray(new Item[0]);
	for (int i = 0; i<bp.length; i++){
	    if (bp[i] instanceof Book){
		Book book = (Book) bp[i];
		if (book.sameSubject(course)){
		    return true;
		}
	    }
	}
	return false;
    }

    public void printBackpack(){
	Item[] bp = backpack.toArray(new Item[0]);
	for(int i = 0; i<bp.length; i++){
	    if (bp[i]==null) 	    System.out.println("Trace1");
	    System.out.println((i+1) + ". " + bp[i].toString());
	}
	System.out.println("You got "+getKeys()+" keys.");
    }

    public void printBackpack_2(){
	System.out.println(backpack);
	System.out.println("You got "+getKeys()+" keys.");
    }

    public void removeFromBp(int key){
	Item[] bp = backpack.toArray(new Item[0]);
	Item item = bp[key];
	System.out.println("You left your deeply treasured " + item.toString());
	backpack.remove(item);
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

    public void addItem(Item i){
	backpack.add(i);
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

    public void addKeys(int a){
	keys+=a;
    }

    public void removeKeys(int a){
	if (a>=keys) {
	    keys=0;
	    return;
	}
	keys-=a;
    }
}
