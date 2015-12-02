import java.util.*;
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
	    int right = c.ask();
	    String ans = control.scan();
	    String[] options = new String[]{"a", "b", "c", "d"};
	    if (player.hasBookWithSubject(c)){
		Random generator = new Random();
		int notRight = generator.nextInt(4);
		while (notRight==right){
		    notRight = generator.nextInt(4);
		}
		System.out.println("Your book tells you it's not "+options[notRight].toUpperCase()+". ");
	    }
	    
	    while(!Arrays.asList(options).contains(ans)){
		System.out.println("So, is it gonna be A, B, C or D?");
		ans = control.scan();
	    }

	    if(0 == ans.compareTo(options[right])){
		System.out.println("Good job! I'm proud of you. Soon you will be ready to enter the almighty realms and envåldsmakt of the Svenskt näringsliv!");
		pass(player);
	    }
	    else{
		System.out.println("Hmph, ridiculous... You have some more practicing to do, young person of unknown gender. Ah well, enjoy your freedom until the Arbetslivet gets hold of you!");
	    }
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
