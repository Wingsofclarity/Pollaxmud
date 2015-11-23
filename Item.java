public abstract class Item{
    String name = "Item";

    public String toString(){
	return name;
    }

    public boolean equals(Object o){
	assert(o instanceof Item);
	Item i = (Item) o;
	return name.equals(i.name);
    }
}
