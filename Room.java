import java.util.*;
public class Room{
    protected String name;
    
    Room(){
	this("Unknown room");
    }

    Room(String name){
	this.name=name;
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
	assert(o instanceof Room);
	Room r = (Room)o;
	return name.equals(r.name);
    }
    
    public int hashCode(){
	ErrorControl.error();
	return -1;
    }

    public String getDescription(){
	ErrorControl.error();
	return "nothing";
    }
}
