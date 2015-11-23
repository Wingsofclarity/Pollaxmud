public class Control{
    Player player;

    Control(Player player){
	this.player = player;
    }

    public void scan(){
        String input = System.console().readLine().toLowerCase();
        String[] parts = input.split(" ");
        String command = parts[0];
        String attribute = parts[1];

        if (command.equals("go")){
                this.chooseDirection(attribute);
            }
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

    /*   public void move(String direction) {
        player.move(world.getConnections(player.getLocation()));
        
        }*/

    
}
