import java.util.*;
public class Room{
    protected String name;
    protected HashMap<String, Item> items;
    protected int keys;
    
    Room(){
	this("Unknown room");
    }

    Room(String name){
	this.name=name;
	items = new HashMap<String, Item>();
	keys = 0;
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
	return name+". There are "+items+" and "+keys+" keys in the room.";
    }

    public void addItem(Item i){    
	items.put(i.getName(), i);
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

    public int getKeys(){
	return keys;
    }

    public Item getItem(String s){
	return items.get(s);
    }

    public Item takeItem(String s){
	Item i = items.get(s);
	items.remove(s);
	return i;
    }
}
