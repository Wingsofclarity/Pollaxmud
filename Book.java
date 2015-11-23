public class Book extends Item{
    Course c;

    Book(int volume, Course c){
        super(volume);
        this.c = c;
    }

}
