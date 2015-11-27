public class Control{
    Player player;
    World world;
    boolean exit = false;

    Control(Player player, World world){
	this.player = player;
	this.world = world;
    }

    public void scan(){
        String input = System.console().readLine();
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

	default:
	    System.out.println("Unknown command '"+input+"'");
	    break;
	}
    }

    public void interact(String name){
	world.getNPCs().get(name).interact();
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
	    }
	}
	else {
	    System.out.println("No such adjacent room.");
	}
    }

    public void exit(){
	exit=true;
    }

    public void graduate(){
	Sphinx sphinx = (Sphinx) world.getNPCs().get("sphinx");
	sphinx.graduate(player);
    }

    /*   public void move(String direction) {
        player.move(world.getConnections(player.getLocation()));
        
        }*/

    
}
