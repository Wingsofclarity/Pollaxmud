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
	    FileReader nameFile = new FileReader("resources/namesData.txt");
	    World poll = new World(roomFile,creatureFile, connectionFile,
				   courseFile, questionFile, nameFile);
	    Control control = new Control(poll.player, poll);

	    System.out.println("Welcome to pollaxsud.");
	    System.out.println(poll.getDescription(poll.player.getLocation()));
	    while (true){
		System.out.print("Awaiting input: ");
		control.command();

		if (control.exit){
		    System.out.println("Pollaxsud exiting.");
		    return;
		}
	    }

	}
	catch (FileNotFoundException e){
	    System.out.println("Files missing. One or more Data files in directory resources are missing.");
	    return;
	}
    }
}
