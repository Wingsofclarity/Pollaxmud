import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class World{
    //File map;
    private LinkedList<Creature> creatures;
    private LinkedList<Room> rooms;
    private LinkedList<Connection> connections;
    private LinkedList<Course> courses;
    public Player player;
    
    World(){
    }

    World(FileReader roomFile, FileReader creatureFile, FileReader connectionFile,
	  FileReader courseFile, FileReader questionFile){
	rooms = Parser.parseRoom(roomFile);
	courses = Parser.parseCourse(courseFile);
	creatures = Parser.parseCreature(creatureFile, courses);
	connections = Parser.parseConnection(connectionFile, rooms);
	player = new Player("Mr.Player", rooms.getFirst(), courses);
	Parser.parseQuestion(questionFile, courses);
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

    public void interactAll(){
	for (int i = 0; i<creatures.size(); i++){
	    creatures.get(i).interact();
	}
    }

    public LinkedList<Room> getUnreachable(){
	LinkedList<Room> r = new LinkedList<Room>();
	boolean reachable = false;
	for (int i = 0; i<rooms.size(); i++){
	    for (int j = 0; j<connections.size(); j++){
		if (connections.get(j).getRooms().contains(rooms.get(i))){
		    reachable = true;
		    break;
		}
	    }
	    if (!reachable){
		r.add(rooms.get(i));
	    }
	}
	return r;
    }

    public String getDescription(Room r){
	if (r == null) return "You see absolute emptiness. You are nowhere.";
	String s = r.toString();
	s +="\n  Creatures: ";
	for (int i = 0; i<creatures.size(); i++){
	    if (r.equals(creatures.get(i).getLocation())){
		s+=creatures.get(i).toString()+", ";
	    }
	}

	s+= " it connects to ";
	s+=getConnectedRooms(r).toString();
	/*for (int i = 0; i<connections.size(); i++){
	    if (connections.get(i).getRooms().contains(r)){
		s+=" "+connections.get(i).connect(r).toString();
	    }
	    }*/
	
	return s;
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
