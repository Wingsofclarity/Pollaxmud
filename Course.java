import java.util.*;
public class Course{
    private String name;
    private String id;
    private LinkedList<Question> questions;
    private int hp;

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

    public String getName(){
	return name;
    }

    public int getHp(){
	return hp;
    }
    
    public int ask(){
	System.out.println("---"+name+"---");
	Question q = getRandQuestion();
	q.run();
	return q.right;
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

	public String toStringAnswers(){
	    return "  A. "+answers.get(0)+'\n'
		+"  B. "+answers.get(1)+'\n'
		+"  C. "+answers.get(2)+'\n'
		+"  D. "+answers.get(3);
	}

	public void run(){
	    System.out.println(question);
	    System.out.println(toStringAnswers());
	}

	public String toString(){
	    String[] options = new String[]{"A", "B", "C", "D"};
	    return question+'\n'+
		toStringAnswers()+
		"Right answer: "+options[right];
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
