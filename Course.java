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
    
    public void ask(){
	System.out.println("---"+name+"---");
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
	  
	    String[] options = new String[]{"a", "b", "c", "d"};
	    System.out.println("Your answer: ");

	    String ans = System.console().readLine().toLowerCase();

	    while(!Arrays.asList(options).contains(ans)){
		System.out.println("So, is it gonna be A, B, C or D?");
		ans = System.console().readLine().toLowerCase();
	    }

	    if(0 == ans.compareTo(options[right])){
		System.out.println("Good job! I'm proud of you. Soon you will be ready to enter the almighty realms and envåldsmakt of the Svenskt näringsliv!");
	    }
	    else{
		System.out.println("Hmph, ridiculous... You have some more practicing to do, young person of unknown gender. Ah well, enjoy your freedom until the Arbetslivet gets hold of you!");
	    }	
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
