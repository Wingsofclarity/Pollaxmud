import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class World{
    //File map;
    EqList<Creature> creatures;
    EqList<Room> rooms;
    EqList<Connection> connections;
    EqList<Course> courses;

    World(){
	//TODO: Open file with standard name and send to other constructor.

	//Cheat
	rooms = new EqList<Room>();
	rooms.addElement(new Room("Room 2"));
	rooms.addElement(new Room("Room 3"));
	rooms.addElement(new Room("Room 4"));
	Room room1 = new Room( "Room 1");
	Room room2= new Room( "Room 1");
	assert(rooms.has(new Room("Room 1")));
	

	connections = new EqList<Connection>();
	connections.addElement(new Connection(getRoom("Room 1"), getRoom("Room 2")));
	System.out.println(getConnectedRooms(rooms.head()));

	creatures = new EqList<Creature>();
	creatures.addElement(new Student("Bertil"));

	courses = new EqList<Course>();
	courses.addElement(new Course("Potatis-kursen"));
    }

    World(FileReader roomFile, FileReader creatureFile){
	
	rooms = new EqList<Room>();
	try(BufferedReader br = new BufferedReader(roomFile)) {
	    for(String line; (line = br.readLine()) != null; ) {
		rooms.addElement(new Room(line));
	    }
	}
	catch (IOException e){
	    return;
	}

	creatures = new EqList<Creature>();
	try(BufferedReader br = new BufferedReader(creatureFile)) {
	    for(String line; (line = br.readLine()) != null; ) {
		creatures.addElement(new Student(line));
	    }
	}
	catch (IOException e){
	    return;
	}

	courses = new EqList<Course>();
	connections = new EqList<Connection>();
	
    }

    
    public EqList<Creature> getCreatures(){
	return creatures;
    }

    public Room getRoom(String name){
	assert(rooms.has(new Room(name)));
	return rooms.get(new Room(name));
    }
    
    public EqList<Room> getRooms(){
	return rooms;
    }

    public EqList<Room> getConnectedRooms(Room r){
	EqList<Room> e = new EqList<Room>();
	for (int i = 0; i<connections.size(); i++){
	    Room to = connections.getNth(i).connect(r);
	    if (to!=null){
		e.addElement(to);
	    }
	}
	return e;
    }

    @Override
    public String toString(){
	ErrorControl.error();
	return "Creatures \n" + toStringCreatures()+
	    "Rooms \n"+toStringRooms()+
	    "Connections\n"+toStringConnections()+
	    "Courses\n"+toStringCourses();
    }

    public String toStringCreatures(){
	ErrorControl.error();
	return creatures.toString();
    }

    public String toStringRooms(){
	return rooms.toString();
    }

    public String toStringConnections(){
	return connections.toString();
    }

    public String toStringCourses(){
	return courses.toString();
    }
}
