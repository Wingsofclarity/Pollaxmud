public abstract class Item{
    String name = "Item";
    int volume = 0;

    Item(int volume){
        this.volume = volume;
    }

    public String toString(){
	return name;
    }

    public int getVolume(){
        return this.volume;
    }

    public boolean equals(Object o){
	assert(o instanceof Item);
	Item i = (Item) o;
	return name.equals(i.name);
    }
}
