public class Course{
    String name;
    String id;
    EqList<Question> questions;
    int hp;

    Course(String id){
	this(id,id, 0);
    }
    
    Course(String id, String name, int hp){
	this.name = name;
	this.id = id;
	this.hp = hp;
    }

    public boolean equals(Object o){
	assert(o instance of Course);
	Course c = (Course) o;
	return id.equals(c.id);
    }

    private class Question{
	String question;
	EqList<String> answers;
	int right;
    }
}
