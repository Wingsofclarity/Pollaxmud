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
	assert(o instanceof Course);
	Course c = (Course) o;
	return id.equals(c.id);
    }

    public void ask(){
	questions.head().run();
    }

    private class Question{
	String question;
	EqList<String> answers;
	int right;

	public boolean run(){
	    System.out.println(question);
	    System.out.println(answers);
	    return false;
	}
    }
}
