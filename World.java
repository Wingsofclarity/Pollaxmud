import java.io.FileReader;
import java.io.BufferedReader;

public class World{
    //File map;
    EqList<Creature> creatures;
    EqList<Room> rooms;
    EqList<Connection> connections;

    World(){
	//TODO: Open file with standard name and send to other constructor.

	//Cheat
	rooms = new EqList<Room>();
	rooms.addElement(new Room("Room 1"));
	rooms.addElement(new Room("Room 2"));
	rooms.addElement(new Room("Room 3"));
	rooms.addElement(new Room("Room 4"));
	Room room1 = new Room( "Room 1");
	Room room2= new Room( "Room 1");
	assert(rooms.has(new Room("Room 1")));
	

	connections = new EqList<Connection>();
	connections.addElement(new Connection(getRoom("Room 1"), getRoom("Room 2")));

	creatures = new EqList<Creature>();
	creatures.addElement(new Creature("Bertil"));
    }

    World(FileReader file){
	//TODO: Parse rooms with map.
	
	ErrorControl.error();
	/*
	assert(file.ready());
	try(BufferedReader br = new BufferedReader(file)) {
	    for(String line; (line = br.readLine()) != null; ) {
		// process the line.
	    }
	}
	
	rooms = new EqList<Room>();*/
	
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

    public String toString(){
	ErrorControl.error();
	return "Creatures \n" + toStringCreatures()+
	    "Rooms \n"+toStringRooms()+
	    "Connections\n"+toStringConnections();
    }

    public String toStringCreatures(){
	ErrorControl.error();
	return creatures.toString();
    }

    public String toStringRooms(){
	return rooms.toString();
    }

    public String toStringConnections(){
	ErrorControl.error();
	return connections.toString();
    }
}
