import java.util.*;
public class Course{
    String name;
    String id;
    LinkedList<Question> questions;
    int hp;

    Course(){
	this("NotMath");
    }
    
    Course(String id){
	this(id,id, 0);
    }
    
    Course(String id, String name, int hp){
	this.name = name;
	this.id = id;
	this.hp = hp;
	questions = new LinkedList<Question>();
    }

    public boolean equals(Object o){
	assert(o instanceof Course);
	Course c = (Course) o;
	return id.equals(c.id);
    }

    public void ask(){
	questions.get((Util.randomRange(1,2))).run();
    }

    public int numQuestions(){
	return questions.size();
    }

    public String toString(){
	return name+"  "+id+" with "+numQuestions()+" questions";
    }

    private class Question{
	String question;
	LinkedList<String> answers;
	int right;

	public boolean run(){
	    System.out.println(question);
	    System.out.println(answers);
	    return false;
	}
    }
}
