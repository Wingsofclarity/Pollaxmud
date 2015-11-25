public class Student extends NPC{
    Course completedC;
    Course currentC;

    Student(){
	this("Studentguy");
    }

    Student(String name){
	this(name ,new Course("whatever"), new Course("whatever2"));
    }
    
    Student(String name, Course completed, Course current){
	super(name);
	assert(!completed.equals(current));
	this.completedC=completed;
	this.currentC=current;
    }

    public String toString(){
	return "Student: "+super.toString();
    }

    @Override
    public void interact(){
	System.out.println(completedC.getQuestion());
    }
}
