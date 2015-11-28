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

	    while (true){
		System.out.print("Awaiting input..");

	
		//Utskrifter för att se om det finns lärare.
		System.out.print(poll.getNPCsRoom(poll.getRooms().get("2000")).toString());
		System.out.print(poll.getNPCsRoom(poll.getRooms().get("2001")).toString());
		System.out.print(poll.getNPCsRoom(poll.getRooms().get("2002")).toString());
		System.out.print(poll.getNPCsRoom(poll.getRooms().get("2100")).toString());
		System.out.print(poll.getNPCsRoom(poll.getRooms().get("2101")).toString());
		System.out.print(poll.getNPCsRoom(poll.getRooms().get("2102")).toString());
		System.out.print(poll.getNPCsRoom(poll.getRooms().get("2103")).toString());

		control.scan();

		control.command();

		if (control.exit){
		    //System.out.println(poll);
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
