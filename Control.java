import java.util.*;

/**
 * The Control class handles the user's choices and thereby directs the control flow throughout the game.
 * @author G. Rosen
 * @author A. Bergqvist
 */
public class Control{
    protected Player player;
    protected World world;
    protected boolean exit = false;

    Control(Player player, World world){
	this.player = player;
	this.world = world;
    }

    public Player getPlayer(){
	return player;
    }

    /**
     * Gets user input.
     * @return User's input.
     */
    public String scan(){
	return System.console().readLine().toLowerCase();
    }

    /**
     * Directs control flow according to user's choices.
     */
    public void command(){
	if (player.getHp()==0){
	    exit=true;
	    return;
	}
	String input = scan();
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

	case "inventory":
	    inventory();
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

	case "check":
	    check(attribute);
	    break;
	    
	default:
	    System.out.println("Unknown command '"+input+"'");
	    break;
	}
    }

    /**
     * Interact with non-player controllable characters in the game.
     * @param name Non-player controllable character to interact with.
     */
    public void interact(String name){
	HashMap<String, NPC> NPCs = world.getNPCsRoom(player.getLocation());
	if (NPCs.containsKey(name)){
	    NPCs.get(name).interact(this);
	}
	else {
	    System.out.println(name+" is not present.");
	}
    }
    /**
     * Describes the room the player is currently in.
     */
    public void description(){
	System.out.println(world.getDescription(player.getLocation()));
    }

    /**
     * Moves player to room of player's choice if room is available.
     * @param direction Name of room.
     */
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

    /**
     * Possibility to unlock door if player has at least one key.
     * @param c The door to unlock.
     */ 
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

    public void inventory(){
	player.printBackpack_2();
    }

    /**
     * Lets player take book.
     * @param item Book to pick up.
     */
    public void take(String item){
	if (item.equals("key")){
	    takeKey();
	}
	else {
	    Item i = player.getLocation().takeItem(item);
	    if (i == null) System.out.println("There is no such item.");
	    else {
		System.out.println("You have picked up "+i+".");
		player.addItem(i);
	    }
	}
    }

    /**
     * Lets player take key.
     */
    public void takeKey(){
	if (player.getLocation().getKeys()>0){
	    player.addKeys(1);
	    player.getLocation().removeKeys(1);
	}
	else {
	    System.out.println("There are no keys in this room.");
	}
    }

    /**
     * If player has a key, lets him/her drop it.
     */
    public void dropKey(){
	if (player.getKeys()>0){
	    player.removeKeys(1);
	    player.getLocation().addKeys(1);
	}
	else {
	    System.out.println("There are no keys in your backpack.");
	}

    }

    /**
     * When backpack is not empty, lets player drop item of choice.
     */
    public void drop(){ //Fall för tom ryggsäck, ska vara inom intervall etc.
	if(player.getBackpack().isEmpty() && player.getKeys()==0){
	    System.out.println("Your backpack is ekande tom, there's nothing to leave behind but your soul.");
	}
	else{
	    System.out.println("You are carrying..:");
	    player.printBackpack();
	    System.out.println("Which object would you like to remove from your backpack?");

	    String ans = scan();
	    if (ans.equals("key") ){
		dropKey();
	    }
	    else {
		player.removeFromBp(Integer.parseInt(ans));
	    }
	}
    }

    /**
     * Exits game.
     */
    public void exit(){
	exit=true;
    }

    public void graduate(){
	Sphinx sphinx = (Sphinx) world.getNPCs().get("sphinx");
	sphinx.graduate(player);
    }

    /**
     * Prints player's own status to screen, e.g. hp or backpack.
     * @param string What information to print.
     */
    public void check(String string){
	switch(string){
	case "hp":
		System.out.println(player.getHp());
		break;
	case "backpack":
	    player.printBackpack();
	    break;
	default:
	System.out.println("Invalid command.");
	    }
    }

    /**
    * Handles yes-or-no questions to player.
    * @return True if player answers yes and false if player answers no.
    */

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
