import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class World{
    //File map;
    private HashMap<String, NPC> NPCs;
    private HashMap<String,Room> rooms;
    private LinkedList<Connection> connections;
    private HashMap<String, Course> courses;
    private LinkedList<String> names;
    public Player player;
    
    World(){
    }

    World(FileReader roomFile, FileReader NPCFile, FileReader connectionFile,
	  FileReader courseFile, FileReader questionFile, FileReader nameFile){
	names = Parser.parseName(nameFile);
	rooms = Parser.parseRoom(roomFile);
	courses = Parser.parseCourse(courseFile);
	NPCs = Parser.parseNPC(NPCFile, courses, names);
	connections = Parser.parseConnection(connectionFile, rooms);
	player = Parser.parsePlayer(rooms, courses);
	Parser.parseQuestion(questionFile, courses);
    }
    
    public HashMap<String, NPC> getNPCs(){
	return NPCs;
    }

    /*
    public Room getRoom(String name){
	assert(rooms.contains(new Room(name)));
	return rooms.get(new Room(name));
	}*/
    
    public HashMap<String,Room> getRooms(){
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

    public LinkedList<NPC> getNPCsRoom(Room r){
	LinkedList<NPC> e = new LinkedList<NPC>();
	for (int i = 0; i<NPCs.size(); i++){
	    if (NPCs.get(i).getLocation().equals(r)){
		e.add(NPCs.get(i));
	    }
	}
	return e;
    } 

    public void interactAll(){
	for (int i = 0; i<NPCs.size(); i++){
	    NPCs.get(i).interact();
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
	LinkedList<Room> connected = getConnectedRooms(r);
	return r.getDescription()+ " There is "+connected.size()+" doors that leads to "+connected.toString()+" respectively.";
    }

    @Override
    public String toString(){
	return "NPCs \n" + toStringNPCs()+"\n\n"+
	    "Rooms \n"+toStringRooms()+"\n\n"+
	    "Connections\n"+toStringConnections()+"\n\n"+
	    "Courses\n"+toStringCourses();
    }

    public String toStringNPCs(){
	return NPCs.toString();
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
