//TODO: Make abstract.
import java.util.*;

public class Creature{
    protected String name;
    protected LinkedList<Item> items;
    protected Room location;

    Creature(){
	this("Unknown creature");
    }

    Creature(String name){
	this(name, null);
    }
    
    Creature(String name, Room room){
	this.name=name;
	items = new LinkedList<Item>();
	location = room;
    }

    public void move(Room to){
	location=to;
    }

    public String location(){
	if (location==null){
	    	return "'Nowhere'";
	}
	return location.toString();
    }

    public Room getLocation(){
	return location;
    }

    @Override
    public boolean equals(Object o){
	assert(o instanceof Creature);
	Creature c = (Creature) o;
	return name.equals(c.name);
    }

    public void removeItem(Item i){
	ErrorControl.error();
    }

    public void addItem(Item i){
	ErrorControl.error();
    }

    public LinkedList<Item> getItems(){
	ErrorControl.error();
	return items;
    }
    
    public String toString(){
	return name+" is at "+location()+", has"+getItems().toString();
    }
    
    @Override
    public int hashCode(){
	ErrorControl.error();
	return -1;
    }

    /*
    public void interact(Creature c){
	ErrorControl.error();
	}*/

    public void chat(){
	System.out.println("I'm "+this.toString());
    }
}
