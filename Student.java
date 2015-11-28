public class Student extends NPC{
    Course completedC;
    Course currentC;
    
    Student(String name, Room room, Course completed, Course current){
	super(name, room);
	assert(!completed.equals(current));
	this.completedC=completed;
	this.currentC=current;
    }

    @Override
    public String toString(){
	return "Student: "+super.toString();
    }

    @Override
    public void interact(Player player){
	System.out.println(completedC.getQuestion());
    }
}
