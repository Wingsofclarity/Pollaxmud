import java.io.FileReader;
import java.io.FileNotFoundException;

public class Pollaxmud{
    public static void main(String arg[]) {
	try{
	    FileReader roomFile = new FileReader("resources/roomData.txt");
	    FileReader creatureFile = new FileReader("resources/creatureData.txt");
	    FileReader connectionFile = new FileReader("resources/connectionData.txt");
	    FileReader courseFile = new FileReader("resources/courseData.txt");
	    FileReader questionFile = new FileReader("resources/questionData.txt");
	    World poll = new World(roomFile,creatureFile, connectionFile, courseFile, questionFile);
	    poll.interactAll();
	    System.out.println(poll);
	}
	catch (FileNotFoundException e){
	    System.out.println("Files missing. One or more Data files in directory resources are missing.");
	    return;
	}
    }
}
