public class Teacher extends NPC{

    Teacher(){
	this("Teacherguy");
    }
    
    Teacher(String name){
	super(name);
    }

    public String toString(){
	return "Teacher: "+super.toString();
    }
}
