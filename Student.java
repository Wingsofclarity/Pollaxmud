public class Student extends NPC{
    Course completedC;
    Course currentC;

    Student(String name, Course completed, Course current){
	super(name);
	this.completedC=completed;
	this.currentC=current;
	
    }
    


}
