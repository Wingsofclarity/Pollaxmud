public abstract class NPC extends Creature{

    NPC(String name, Room room){
	super(name, room);
    }

    NPC(String name){
	super(name);
    }
    
    public void aiStep(){
	Math.random();
    }

    public void chat(){
	System.out.println("Name: "+name);
    }
    
    public void interact(Control control){
	this.chat();
    }
}
