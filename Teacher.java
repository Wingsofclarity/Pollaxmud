public class Teacher extends NPC{
    Course c;
    
    Teacher(String name, Room room, Course c){
	super(name, room);

	assert(c!=null);

	this.c = c;


    }

    @Override
    public void interact(Control control){
	Player player = control.getPlayer();
	System.out.print(name+" is a teacher in "+c.getName()+". ");
	if (player.getUnfinishedCourses().contains(c)){

	    //Not completed
	    System.out.println("This is a course you have not completed.");
<<<<<<< HEAD
	    int r = c.ask();
	    int a = Integer.parseInt(control.scan());
	    while (a==-1){
		System.out.println("Enter a number between 1-4");
		a = Integer.parseInt(control.scan());
	    }
	    if (r==(a-1)){
		System.out.println("That was the correct answer.");
		player.setHp(player.getHp()+1); 
	    }
	    else{
		System.out.println("That was a wrong answer.");
		player.setHp(player.getHp()-1);
	    }
=======
	    boolean passed = c.ask();
	    
	    if (passed){
		pass(player);
	    }
	    
	   
>>>>>>> 2c8416838e62565aab2e4c49e681a2805d3e7681
	}
	
	else if (!player.getCompletedCourses().contains(c)){

	    //Free course
	    System.out.println("This is a course you do not have. It has "+c.getHp()+" hp. Do you wish to register for this course? y/n");
	    if (control.ynQuestion()){
		player.enroll(c);
		System.out.println("Congrats, you are registered.");
	    }
	    else{
		System.out.println("Too bad.");
	    }
	}
	
	else if (player.getCompletedCourses().contains(c)) {

	    //Completed course.
	    System.out.println("You have completed this course.");
	}
    }

    @Override
    public String toString(){
	return "Teacher: "+super.toString()+" "+c.getName();
    }

    public void pass(Player player){
	player.getUnfinishedCourses().remove(c);
	player.getCompletedCourses().add(c);
    }    
}
