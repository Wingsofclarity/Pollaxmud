public class Control{
    Player player;
    World world;
    boolean exit = false;

    Control(Player player, World world){
	this.player = player;
	this.world = world;
    }

    public void scan(){
        String input = System.console().readLine().toLowerCase();
	input = input.toLowerCase();
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
	    
	case "exit":
	    exit();
	    break;
	}
    }

    public void description(){
	System.out.println(world.getDescription(player.getLocation()));
    }

    public void chooseDirection(String direction){

        switch(direction){
        case "n": 
            System.out.println("Goes north.");
            break;
        case "e": 
            System.out.println("Goes east.");
            break;
        case "s": 
             System.out.println("Goes south.");
            break;
        case "w": 
            System.out.println("Goes west.");
            break;
        default: 
            System.out.println("Invalid direction.");
        }
    }

    public void exit(){
	exit=true;
    }

    /*   public void move(String direction) {
        player.move(world.getConnections(player.getLocation()));
        
        }*/

    
}
