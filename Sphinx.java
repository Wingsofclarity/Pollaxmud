public class Sphinx extends NPC{
    
    Sphinx(){
	name = "The Sphinx";
    }
    
    public void chat(){
	System.out.println("Jag har ingen näsa :(");
	super.chat();
    }

    public void graduate(Player p){
	if(p.getHp()>=180){
	    System.out.println("HURRA!");
	}
	else{
	    System.out.println(":<");
	}
    }
}
