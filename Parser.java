import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.io.IOException;

public class Parser{

    public static HashMap<String,Room> parseRoom(FileReader roomFile){
	HashMap<String,Room> rooms = new HashMap<String,Room>();
	try(BufferedReader br = new BufferedReader(roomFile)) {
	    for(String line; (line = br.readLine()) != null; ) {
		Room r = new Room(line);
		rooms.put(r.getName(), r);
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

    public static HashMap<String, NPC> parseNPC(FileReader NPCFile, HashMap<String,Course> courses, HashMap<String,Room> rooms, LinkedList<String> names){

	assert(courses.size()>1);
	HashMap<String, NPC> NPCs = new HashMap<String, NPC>();
	try(BufferedReader br = new BufferedReader(NPCFile)) {

	    for(String line; (line = br.readLine()) != null;){
		//line=line.toLowerCase();
		String[] devided = line.split(", ");
		switch (devided[0]){
		case "randomstudent":{
		    Student s = randomStudent(courses,rooms, names);
		    while (NPCs.containsKey(s.getName())){
			s = randomStudent(courses,rooms, names);
		    }
		    NPCs.put(s.getName(), s);
		    break;
		}

		case "randomteacher":{
		    Teacher t = randomTeacher(courses, rooms, names);
		    while (NPCs.containsKey(t.getName())){
			t = randomTeacher(courses, rooms, names);
		    }
		    NPCs.put(t.getName(), t);
		    break;
		}

		case "student":{
		    String name = devided[1];
		    Room r = rooms.get(devided[2]);
		    Course c1 = courses.get(devided[3]);
		    Course c2 = courses.get(devided[4]);
		    NPCs.put(name, new Student(name, r, c1, c2));
		    break;
		}

		case "sphinx":{
		    if(devided[1].equals("random")){
			Sphinx s = randomSphinx(rooms);
			NPCs.put(s.getName(), s);
		    }
		    else{
			Room r = rooms.get(devided[1]);
			Sphinx s = new Sphinx(r);
			NPCs.put(s.getName(), s);
		    }
		    break;
		}

		default:{
		    String name = devided[1];
		    Room r = rooms.get(devided[2]);
		    Course c1 = courses.get(devided[3]);
		    Course c2= courses.get(devided[4]);
		    NPCs.put(name, new Student(name, r, c1, c2));
		    break;
		}
		}
	    }
	    return NPCs;
	}
	catch (IOException e){
	    ErrorControl.error();
	    return NPCs;
	}

    }

    public static LinkedList<Connection> parseConnection(FileReader connectionFile, HashMap<String,Room> rooms){
	LinkedList<Connection> connections = new LinkedList<Connection>();

	try(BufferedReader br = new BufferedReader(connectionFile)) {
	    for(String line; (line = br.readLine()) != null; ) {
		String[] devided = line.split(", ");
		//TODO: Defensive programming
		Room r1 = rooms.get(devided[0]);
		Room r2 = rooms.get(devided[1]);
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

    public static HashMap<String, Course> parseCourse(FileReader courseFile){
	HashMap<String,Course> courses = new HashMap<String,Course>();
	try(BufferedReader br = new BufferedReader(courseFile)) {
	    for(String line; (line = br.readLine()) != null; ) {
		String[] devided = line.split(", ");
		//TODO: Defensive programming
		assert(devided.length==3);
		Course c = new Course(devided[1], devided[0], Integer.parseInt(devided[2]));
		assert(!courses.containsKey(c.getId()));
		courses.put(c.getId(),c);
		
	    }
	    return courses;
	}
	catch (IOException e){
	    ErrorControl.error();
	    return courses;
	}
    }

    public static void parseQuestion(FileReader questionFile, HashMap<String,Course> courses){
	try(BufferedReader br = new BufferedReader(questionFile)) {
	    for(String line; (line = br.readLine()) != null; ) {
		String[] devided = line.split(", ");
		assert(devided.length==7);
		//TODO: Defensive programming
		LinkedList<String> answers = new LinkedList<String>();
		for (int i = 2; i<=5; i++){
		    answers.add(devided[i]);
		}
		courses.get(devided[0]).addQuestion(devided[1], answers, Integer.parseInt(devided[6]));
	    }
	    return;
	}
	catch (IOException e){
	    ErrorControl.error();
	    return;
	}

    }


    public static Player parsePlayer (HashMap<String,Room> rooms, HashMap<String,Course> courses){
        LinkedList<Course> completedCourses = new LinkedList<Course>();
	Random generator = new Random();
        for(int i = 0; i < 6; i++){
	    Object[] values = courses.values().toArray();
	    Course randomCourse = (Course) values[generator.nextInt(values.length)];
            completedCourses.add(randomCourse);
        }

	
	Object[] values = rooms.values().toArray();
	Room randomRoom = (Room) values[generator.nextInt(values.length)];

        return new Player("Mr.Player", randomRoom, completedCourses);
    }

    public static Student randomStudent(HashMap<String,Course> courses, HashMap<String,Room> rooms, LinkedList<String> names){
	String n = names.get(randomWithRange(0,names.size()-1));
	Random generator = new Random();
	Object[] values =  courses.values().toArray();
	Course c1 = (Course) values[generator.nextInt(values.length)];
	Course c2 = (Course) values[generator.nextInt(values.length)];
        while (c2.equals(c1)){
	    c2 = (Course) values[generator.nextInt(values.length)];
	}

	Object[] roomsArray = rooms.values().toArray();
	Room r = (Room) roomsArray[generator.nextInt(roomsArray.length)];
	return new Student(n, r, c1, c2);
    }

    public static Teacher randomTeacher(HashMap<String,Course> courses, HashMap<String,Room> rooms, LinkedList<String> names){
	Course c = courses.get(randomWithRange(0,courses.size()-1));
	String n = names.get(randomWithRange(0,names.size()-1));

	//Object[] roomsArray = rooms.values().toArray();
	Room r = rooms.get("2001");
	//rooms.get(randomWithRange(0,rooms.size()-1));
	//(Room) roomsArray[generator.nextInt(roomsArray.length)];

	return new Teacher(n, r, c);
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

    
    public static Course randomCourse(HashMap<String,Course> courses){
        int size = courses.size();

	if(size == 0){
            ErrorControl.error();
	}

        Random random = new Random();
        int randomCourse = random.nextInt(size);
	return courses.get("000111");
    }

    public static Sphinx randomSphinx(HashMap<String,Room> rooms){
	Random generator = new Random();
	Object[] roomsArray = rooms.values().toArray();
	Room r = (Room) roomsArray[generator.nextInt(roomsArray.length)];
	return new Sphinx(r);
    }

}
