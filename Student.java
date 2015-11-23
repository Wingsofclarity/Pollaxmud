public class Student extends NPC{
    Course completedC;
    Course currentC;

    Student(){
	this("Studentguy",new Course("whatever"), new Course("whatever2"));
    }
    
    Student(String name, Course completed, Course current){
	super(name);
	assert(!completed.equals(current));
	this.completedC=completed;
	this.currentC=current;

    }
}
