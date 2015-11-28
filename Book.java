public class Book extends Item{
    Course course;

    Book(Course course){
        super(2); //Borde matchas mot kurspoäng
        this.course = course;
    }

    Book(int volume, Course course){
        super(volume);
        this.course = course;
    }

    public Course getCourse(){
	return this.course;
    }

    public Boolean sameSubject(Course c){
	return course == c;
    }
     

}
