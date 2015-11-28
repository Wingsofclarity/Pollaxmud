public class Teacher extends NPC{
    Course c;
    
    Teacher(String name, Room room, Course c){
	super(name, room);

	assert(c!=null);

	this.c = c;


    }

    @Override
    public void interact(Player player){
	System.out.print(name+" is a teacher in "+c.getName()+". ");
	if (player.getUnfinishedCourses().contains(c)){
	    System.out.println("This is a course you have not completed.");
	    c.ask();
	}
	else if (!player.getCompletedCourses().contains(c)){
	    System.out.println("This is a course you do not have. It has "+c.getHp()+" hp. Do you wish to register for this course? Too bad you have to..");
	    player.enroll(c);
	}
	else if (player.getCompletedCourses().contains(c)) {
	    System.out.println("You have completed this course.");
	}
    }

    @Override
    public String toString(){
	return "Teacher: "+super.toString()+" "+c.getName();
    }
    
}
