import java.io.FileReader;
import java.io.FileNotFoundException;

public class Pollaxmud{
    public static void main(String arg[]){
	try{
	    FileReader roomFile = new FileReader("resources/roomData.txt");
	    FileReader creatureFile = new FileReader("resources/creatureData.txt");
	    World poll = new World(roomFile,creatureFile);
	    System.out.println(poll);
	}
	catch (FileNotFoundException e){
	    System.out.println("Files missing");
	    return;
	}
    }
}
