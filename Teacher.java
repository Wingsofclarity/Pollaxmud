public class Teacher extends NPC{
    Course c;

    Teacher(){
	this("Teacherguy");
    }

    Teacher(String name) {
	this(name, null);
    }
    
    Teacher(String name, Room room, Course c){
	super(name, room);
	this.c = c;
	System.out.println("A new teacher is born.");

    }

    @Override
    public void interact(){
	if (c==null) return;
	System.out.println("I am a teacher. Here comes a question.");
	c.ask();
    }

    @Override
    public String toString(){
	return "Teacher: "+super.toString();
    }
    
}
