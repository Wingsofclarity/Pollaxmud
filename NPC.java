public abstract class NPC extends Creature{

    NPC(String name){
	super(name);
    }
    
    public void aiStep(){
	Math.random();
    }

    public void chat(){
	System.out.println("Name: "+name);
    }
    
    public void interact(){
	this.chat();
    }
}
