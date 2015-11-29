import java.util.*;
public class Room{
    protected String name;
    protected HashMap<String, Item> items;
    
    Room(){
	this("Unknown room");
    }

    Room(String name){
	this.name=name;
	items = new HashMap<String, Item>();
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
	return name+" there are "+items+".";
    }

    public void addItem(Item i){
	if (i instanceof Stackable && items.containsKey(i.getName())){
	    Stackable s = (Stackable) items.get(i.getName());
	    s.add();
	}
	else {
	    items.put(i.getName(), i);
	}
    }

    public Item getItem(String s){
	return items.get(s);
    }
}
