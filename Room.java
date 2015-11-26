import java.util.*;
public class Room{
    protected String name;
    protected String description;
    
    Room(){
	this("Unknown room");
    }
    
    Room(String name){
	this(name, name+" is empty.");
    }
    Room(String name, String description){
	this.name=name;
	this.description=description;
    }
    
    public LinkedList<Connection> getConnections(){
	ErrorControl.error();
	return new LinkedList<Connection>();
    }

    @Override
    public String toString(){
	return name;
    }

    @Override
    public boolean equals(Object o){
	if (o==null) return false;
	assert(o instanceof Room);
	Room r = (Room)o;
	return name.toLowerCase().equals(r.name.toLowerCase());
    }
    
    public int hashCode(){
	ErrorControl.error();
	return -1;
    }

    public String getName(){
	return name;
    }
    
    public String getDescription(){
	return description;
    }
}
