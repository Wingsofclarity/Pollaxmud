import java.util.*;
public class Control{
    Player player;
    World world;
    boolean exit = false;

    Control(Player player, World world){
	this.player = player;
	this.world = world;
    }

    public Player getPlayer(){
	return player;
    }

    public String scan(){
	return System.console().readLine().toLowerCase();
    }

    public void command(){
	String input = scan();
	//input = input.toLowerCase();
        String[] parts = input.split(" ");
        String command = parts[0];
	String attribute = null;
	if (parts.length > 1){
	    attribute = parts[1];
	}
	
        switch (command){
	case "go":
	    chooseDirection(attribute);
	    break;

	case "look":
	    description();
	    break;

	case "interact":
	    interact(attribute);
	    break;
	    
	case "exit":
	    exit();
	    break;

	case "graduate":
	    graduate();
	    break;

	case "cheat":
	    System.out.println(world);
	    break;
	    
	default:
	    System.out.println("Unknown command '"+input+"'");
	    break;
	}
    }

    public void interact(String name){
	HashMap<String, NPC> NPCs = world.getNPCsRoom(player.getLocation());
	if (NPCs.containsKey(name)){
	    NPCs.get(name).interact(this);
	}
	else {
	    System.out.println(name+" is not present.");
	}
    }

    public void description(){
	System.out.println(world.getDescription(player.getLocation()));
    }

    public void chooseDirection(String direction){
	Room r = world.getRooms().get(direction);
	if (r == null){
	    System.out.println("No such room.");
	}
	else if (world.getConnectedRooms(player.getLocation()).contains(r)){
	    Connection c = world.getConnection(player.getLocation(), r);
	    if (c.isUnlocked()){
		player.move(r);
		System.out.println("I just entered a new room.\n");
		description();
	    }
	    else if (c.isLocked()){
		System.out.println("Door is locked.\n");
		unLock(c);
		if (c.isUnlocked()) {
		    player.move(r);
		    System.out.println("I just entered a new room.\n");
		    description();
		}
	    }
	}
	else {
	    System.out.println("No such adjacent room.");
	}
    }

    public void unLock(Connection c){
	if (player.getKeys()>0){
	    System.out.println("Do you wish to unlock this door and move through? You got "+player.getKeys()+" keys to spare.");
	    if (ynQuestion()){
		c.setAccess("unlocked");
		System.out.println("Door unlocked.");
	    }
	}
	else {
	    System.out.println("You dont got enough keys to unlock this door.");
	}
    }

    public void exit(){
	exit=true;
    }

    public void graduate(){
	Sphinx sphinx = (Sphinx) world.getNPCs().get("sphinx");
	sphinx.graduate(player);
    }

    public boolean ynQuestion(){
	String input = scan();
	input = input.toLowerCase();
	while (true){
	    if (input.equals("no") || input.equals("n")){
		return false;
	    }
	    else if (input.equals("yes") || input.equals("y")){
		return true;
	    }
	    else {
		System.out.println("Invalid input: "+input+". Type 'yes' or 'no'.");
	    }
	}
	
    }
    
}
