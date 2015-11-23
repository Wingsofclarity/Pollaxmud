public class Course{
    String name;
    String id;
    EqList<Question> questions;
    String book;

    Course(String id){
	this(id,id);
    }
    
    Course(String id, String name){

    }

    private class Question{
	String question;
	EqList<String> answers;
	int right;
    }
    
}
