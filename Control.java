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

	case "take":
	    take(attribute);
	    break;

	case "drop":
	    drop();
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
		unlock(c);
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

    public void unlock(Connection c){
	if (player.getKeys()>0){
	    System.out.print("Do you wish to unlock this door and move through? You got "+player.getKeys()+" keys to spare. y/n ");
	    if (ynQuestion()){
		player.removeKeys(1);
		c.setAccess("unlocked");
		System.out.println("Door unlocked.");
	    }
	}
	else {
	    System.out.println("You dont got enough keys to unlock this door.");
	}
    }

    public void take(String item){
	if (item.equals("key")){
	    takeKey();
	}
	else {
	    ErrorControl.error();
	}
    }

    public void takeKey(){
	if (player.getLocation().getKeys()>0){
	    player.addKeys(1);
	    player.getLocation().removeKeys(1);
	}
	else {
	    System.out.println("There are no keys in this room.");
	}
    }

    public void drop(){ //Fall för tom ryggsäck, ska vara inom intervall etc.
	if(player.getBackpack().isEmpty()){
	    System.out.println("Your backpack is ekande tom, there's nothing to leave behind.");
	}
	else{
	    System.out.println("You are carrying..:");
	    player.printBackpack();
	    System.out.println("Which object would you like to remove from your backpack?");

	    String ans = scan();
	    player.removeFromBp(Integer.parseInt(ans));
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
