public class Sphinx extends NPC{
    Sphinx(Room room){
	super("sphinx",room);
    }
    
    public void chat(){
	System.out.println("Jag har ingen näsa :(");
	super.chat();
    }

    public boolean graduate(Player p){
        int number = p.getUnfinishedCourses().size();
        boolean finished =  p.getUnfinishedCourses().isEmpty();

	if(p.getHp()>=180 && finished){
	    System.out.println("HURRA!");
            return true;
	}
	else if(p.getHp() >= 180){
	    System.out.println("You shall not graduate until you have finished your courses. Go do your homework!");
            return false;
        }
        else if(finished){
            System.out.println("You need 180 hp in order to graduate. You lack " + (180-p.getHp()) + " hp.");
            return false;
        }
        else{ // TODO: logical error, branch never taken.
            System.out.println("You have "+ number + " unfinished courses and less than 180 hp. Be gone!");
            return false;}
    }
}
