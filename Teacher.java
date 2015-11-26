public class Teacher extends NPC{
    Course c;

    Teacher(){
	this("Teacherguy");
    }

    Teacher(String name) {
	this(name, null);
    }
    
    Teacher(String name, Course c){
	super(name);
	this.c = c;
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
