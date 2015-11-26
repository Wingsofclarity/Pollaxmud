import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.io.IOException;

public class Parser{

    public static LinkedList<Room> parseRoom(FileReader roomFile){
	LinkedList<Room> rooms = new LinkedList<Room>();
	try(BufferedReader br = new BufferedReader(roomFile)) {
	    for(String line; (line = br.readLine()) != null; ) {
		rooms.push(new Room(line));
	    }
	    return rooms;
	}
	catch (IOException e){
	    ErrorControl.error();
	    return rooms;
	}
    }

    public static LinkedList<String> parseName(FileReader nameFile){
	LinkedList<String> names = new LinkedList<String>();
	try(BufferedReader br = new BufferedReader(nameFile)) {
	    for(String line; (line = br.readLine()) != null; ) {
		names.add(line);
	    }
	    return names;
	}
	catch (IOException e){
	    ErrorControl.error();
	    return names;
	}
    }

    public static LinkedList<NPC> parseNPC(FileReader NPCFile, LinkedList<Course> courses, LinkedList<String> names){

	assert(courses.size()>1);
	LinkedList<NPC> NPCs = new LinkedList<NPC>();
	try(BufferedReader br = new BufferedReader(NPCFile)) {
	    for(String line; (line = br.readLine()) != null; ) {

		switch (line){
		case "randomStudent":
		    NPCs.add(randomStudent(courses, names));
		    break;

		case "randomTeacher":
		    NPCs.add(randomTeacher(courses, names));
		    break;

		default:
		    //TODO: Defensive programming
		    NPCs.add(new Student(line));
		    break;	
		}
	    }
	    return NPCs;
	}
	catch (IOException e){
	    ErrorControl.error();
	    return NPCs;
	}

    }

    public static LinkedList<Connection> parseConnection(FileReader connectionFile, LinkedList<Room> rooms){
	LinkedList<Connection> connections = new LinkedList<Connection>();

	try(BufferedReader br = new BufferedReader(connectionFile)) {
	    for(String line; (line = br.readLine()) != null; ) {
		String[] devided = line.split(", ");

		//TODO: Defensive programming
		Room r1 = rooms.get(rooms.indexOf(new Room(devided[0])));
		Room r2 = rooms.get(rooms.indexOf(new Room(devided[1])));
		Connection con = new Connection(r1,r2);
		if (devided.length>2){
		    con.setAccess(devided[2]);
		}
		connections.add(con);
	    }
	    return connections;
	}
	catch (IOException e){
	    ErrorControl.error();
	    return connections;
	}
    }

    public static LinkedList<Course> parseCourse(FileReader courseFile){
	LinkedList<Course> courses = new LinkedList<Course>();
	try(BufferedReader br = new BufferedReader(courseFile)) {
	    for(String line; (line = br.readLine()) != null; ) {
		String[] devided = line.split(", ");
		//TODO: Defensive programming
		assert(devided.length==3);
		courses.add(new Course(devided[1], devided[0], Integer.parseInt(devided[2])));
		
	    }
	    return courses;
	}
	catch (IOException e){
	    ErrorControl.error();
	    return courses;
	}
    }

    public static void parseQuestion(FileReader questionFile, LinkedList<Course> courses){
	try(BufferedReader br = new BufferedReader(questionFile)) {
	    for(String line; (line = br.readLine()) != null; ) {
		String[] devided = line.split(", ");
		assert(devided.length==7);
		//TODO: Defensive programming
		LinkedList<String> answers = new LinkedList<String>();
		for (int i = 2; i<=5; i++){
		    answers.add(devided[i]);
		}
		courses.get(courses.indexOf(new Course(devided[0]))).addQuestion(devided[1],answers,
								    Integer.parseInt(devided[6]));
	    }
	    return;
	}
	catch (IOException e){
	    ErrorControl.error();
	    return;
	}

    }


    public static Player parsePlayer (LinkedList<Room> rooms, LinkedList<Course> courses){

        LinkedList<Course> completedCourses = new LinkedList<>();

        for(int i = 0; i < 6; i++){
            completedCourses.add(randomCourse(courses));
        }

        return new Player("Mr.Player", rooms.getFirst(), courses);
    }

    public static Student randomStudent(LinkedList<Course> courses, LinkedList<String> names){

	Course c1 = courses.get(randomWithRange(0,courses.size()-1));
	Course c2 = courses.get(randomWithRange(0,courses.size()-1));
        while (c2==c1){
	    c2 = courses.get(randomWithRange(0,courses.size()-1));
	}
	String n = names.get(randomWithRange(0,courses.size()-1));
	return new Student(n ,c1 ,c2);
    }

    public static Teacher randomTeacher(LinkedList<Course> courses, LinkedList<String> names){
	Course c = courses.get(randomWithRange(0,courses.size()-1));
	String n = names.get(randomWithRange(0,courses.size()-1));
	return new Teacher(n , c);
    }

    public static Room randomRoom(){
	ErrorControl.error();
	return new Room();
    }

    public static int randomWithRange(int min, int max)
    {
	int range = (max - min) + 1;     
	return (int)(Math.random() * range) + min;
    }


    public static Course randomCourse(LinkedList<Course> courses){
        int size = courses.size();

	if(size == 0){
            ErrorControl.error();
	}

        Random random = new Random();
        int randomCourse = random.nextInt(size);
	return courses.get(randomCourse);
    }

}
