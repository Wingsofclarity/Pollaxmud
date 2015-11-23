//TODO: Make abstract.

public class Creature{
    String name;
    EqList<Item> items;
    Room location;

    Creature(){
	this("Unknown creature");
    }

    Creature(String name){
	this.name=name;
	items = new EqList<Item>();
    }

    public void move(){
	ErrorControl.error();
    }

    public String location(){
	ErrorControl.error();
	return "nowhere";
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

    public EqList<Item> getItems(){
	ErrorControl.error();
	return items;
    }
    
    public String toString(){
	return name+" is at "+location()+", has"+getItems().toString(" ",", ");
    }
    
    @Override
    public int hashCode(){
	ErrorControl.error();
	return -1;
    }

    public void interact(Creature c){
	ErrorControl.error();
    }
}
