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
	NPCs = Parser.parseNPC(NPCFile, courses, rooms, names);
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

    public HashMap<String, NPC> getNPCsRoom(Room r){
	HashMap<String, NPC> e = new HashMap<String, NPC>();
	Object[] array = NPCs.values().toArray();
	for (int i = 0; i<array.length; i++){
	    NPC element = (NPC) array[i];
	    if (element.getLocation()==null){
		
	    }
	    else if (element.getLocation().equals(r)){
		e.put(element.getName(), element);
	    }
	}
	return e;
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
	return r.getDescription()+" Creatures called "+getNPCsRoom(r)+" are present."+" There are "+connected.size()+" doors that leads to "+connected.toString()+" respectively.";
    }

    public Connection getConnection(Room a, Room b){
	return connections.get(connections.indexOf(new Connection(a,b)));
    }
    
    @Override
    public String toString(){
	System.out.println("Trace");
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
