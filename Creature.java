//TODO: Make abstract.
import java.util.*;

public class Creature{
    protected String name;
    protected Room location;

    Creature(){
	this("Unknown creature");
    }

    Creature(String name){
	this(name, null);
    }
    
    Creature(String name, Room room){
	this.name=name;
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
	return name.toLowerCase().equals(c.name.toLowerCase());
    }

    public String getName(){
	return name;
    }
    
    public String toString(){
	return name+" is at "+location();
    }
    
    @Override
    public int hashCode(){
	ErrorControl.error();
	return -1;
    }
}

