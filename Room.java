import java.util.*;
public class Room{
    protected String name;
    protected LinkedList<Item> items;
    protected int keys;
    
    Room(){
	this("Unknown room");
    }

    Room(String name){
	this.name=name;
	items = new LinkedList<Item>();
	keys = 0;
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
	items.add(i);
    }

    public Item getItem(String s){
	Item[] itemsArray = (Item[]) items.toArray();
	for (int i = 0; i<itemsArray.length; i++){
	    if (itemsArray[i].getName().equals(s)){
		return items.get(i);
	    }
	}
	return null;
    }

    public Item takeItem(String s){
	Object[] itemsArray =  items.toArray();
	for (int i = 0; i<itemsArray.length; i++){
	    Item item = (Item) items.get(i);
	    if (item.getName().toLowerCase().equals(s)){
		items.remove(i);
		return item;
	    }
	}
	return null;
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
}
