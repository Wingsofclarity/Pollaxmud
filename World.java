import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class World{
    //File map;
    LinkedList<Creature> creatures;
    LinkedList<Room> rooms;
    LinkedList<Connection> connections;
    LinkedList<Course> courses;
    Player player;
    
    World(){
	//TODO: Open file with standard name and send to other constructor.

	//Cheat
	rooms = new LinkedList<Room>();
	rooms.add(new Room("Room 2"));
	rooms.add(new Room("Room 3"));
	rooms.add(new Room("Room 4"));
	rooms.add(new Room("Room 1"));
	Room room1 = new Room( "Room 1");
	Room room2= new Room( "Room 2");
	assert(rooms.contains(new Room("Room 1")));
	

	connections = new LinkedList<Connection>();
	connections.add(new Connection(room1, room2));

	creatures = new LinkedList<Creature>();
	creatures.add(new Student("Bertil"));

	courses = new LinkedList<Course>();
	courses.add(new Course("Potatis-kursen"));
    }

    World(FileReader roomFile, FileReader creatureFile, FileReader connectionFile, FileReader courseFile){
	rooms = Parser.parseRoom(roomFile);
	courses = Parser.parseCourse(courseFile);
	creatures = Parser.parseCreature(creatureFile, courses);
	connections = Parser.parseConnection(connectionFile);
	player = new Player("Mr.Player", rooms.getFirst());
    }

    
    public LinkedList<Creature> getCreatures(){
	return creatures;
    }

    /*
    public Room getRoom(String name){
	assert(rooms.contains(new Room(name)));
	return rooms.get(new Room(name));
	}*/
    
    public LinkedList<Room> getRooms(){
	return rooms;
    }

    public LinkedList<Room> getConnectedRooms(Room r){
	LinkedList<Room> e = new LinkedList<Room>();
	for (int i = 0; i<connections.size(); i++){
	    Room to = connections.get(i).connect(r);
	    if (to!=null){
		e.add(to);
	    }
	}
	return e;
    }

    public LinkedList<Creature> getCreaturesRoom(Room r){
	LinkedList<Creature> e = new LinkedList<Creature>();
	for (int i = 0; i<creatures.size(); i++){
	    if (creatures.get(i).getLocation().equals(r)){
		e.add(creatures.get(i));
	    }
	}
	return e;
    }

    @Override
    public String toString(){
	return "Creatures \n" + toStringCreatures()+"\n\n"+
	    "Rooms \n"+toStringRooms()+"\n\n"+
	    "Connections\n"+toStringConnections()+"\n\n"+
	    "Courses\n"+toStringCourses();
    }

    public String toStringCreatures(){
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
