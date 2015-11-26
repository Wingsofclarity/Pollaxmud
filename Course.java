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

    @Override
    public boolean equals(Object o){
	assert(o instanceof Course);
	Course c = (Course) o;
	return id.equals(c.id);
    }

    public void ask(){

	getRandQuestion().run();
    }

    public String getQuestion(){
	if(numQuestions()==0){
	    System.out.println(toString());
	    ErrorControl.error();
	    return "";
	}
	return getRandQuestion().toString();
    }

    public Question getRandQuestion(){
	if(numQuestions()==0){
	    System.out.println(toString());
	    ErrorControl.error();
	}
        int size = questions.size();
        Random random = new Random();
        int randomQuestion = random.nextInt(size);
	return questions.get(randomQuestion);
    }

    public String getId(){
	return id;
    }

    public int numQuestions(){
	return questions.size();
    }

    public String toString(){
	return name+"  "+id+" with "+numQuestions()+" questions";
    }

    public void addQuestion(String question, LinkedList<String> answers, int right){
	questions.add(new Question(question, answers, right));
    }

    private class Question{
	String question;
	LinkedList<String> answers;
	int right;

	Question(String question, LinkedList<String> answers, int right){
	    this.question=question;
	    this.answers=answers;
	    this.right=right;
	}

	public boolean run(){
	    System.out.println(question);
	    System.out.println("  A. "+answers.get(0));
	    System.out.println("  B. "+answers.get(1));
	    System.out.println("  C. "+answers.get(2));
	    System.out.println("  D. "+answers.get(3));

	    //cheat
	    ErrorControl.error();
	    System.out.println("Enter your answer: A");
	    return right==0;
	}

	public String toString(){
	    return question+'\n'+
		"  "+answers.get(0)+'\n'+
		"  "+answers.get(1)+'\n'+
		"  "+answers.get(2)+'\n'+
		"  "+answers.get(3)+'\n'+
		"Right answer: "+right;
	}
    }

    public int hashCode(){
	ErrorControl.error();
	return -1;
    }

    public void setHp(int a){
	if (a<0) hp = 0;
	else hp = a;
    }
}
