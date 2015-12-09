public class Book extends Item{
    Course course;

    Book(Course course){
	this("Bookof"+course.getName(), course.getHp(), course);
    }

    Book(String name, int volume, Course course){
        super(name, volume);
        this.course = course;
    }
    
    public Course getCourse(){
	return course;
    }

    public Boolean sameSubject(Course c){
	return course.equals(c);
    }
     

}
