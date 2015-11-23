public class Course{
    String name;
    String id;
    EqList<Question> questions;
    String book;
    int hp;

    Course(String id){
	this(id,id, 0);
    }
    
    Course(String id, String name, int hp){
	this.name = name;
	this.id = id;
	this.hp = hp;
    }

    private class Question{
	String question;
	EqList<String> answers;
	int right;
    }
    
}
