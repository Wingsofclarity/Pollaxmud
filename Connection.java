import java.util.*;
public class Connection{
    public enum Access{
	Unlocked("Unlocked"), Locked("Locked"), Closed("Closed");

	private String s;
	
	private Access(String s){
	    this.s = s;
	}
    }
    Access access = Access.Unlocked;
    Room room1;
    Room room2;
    

    Connection(Room room1, Room room2){
	assert(room1 != room2);
	this.room1=room1;
	this.room2=room2;
    }

    public Room connect(Room room){
	if (room.equals(room1)){
	    return room2;
	}
	else if (room.equals(room2)){
	    return room1;
	}
	else {
	    return null;
	}
    }

    public boolean connect(Creature creature){
	Room room = connect(creature.getLocation());
	if (access == Access.Locked){
	    return false;
	}
	else if (room.equals(room1)){
	    creature.move(room2);
	    return true;
	}
	else if (room.equals(room2)){
	    creature.move(room1);
	    return true;
	}
	else {
	    ErrorControl.error();
	    return false;
	}
    }

    public LinkedList<Room> getRooms(){
	LinkedList<Room> list = new LinkedList<Room>();
	list.add(room1);
	list.add(room2);
	return list;
    }

    public boolean equals(Object o){
	assert(o instanceof Connection);
	Connection con = (Connection) o;
	return ((room1.equals(con.room1) && room2.equals(con.room2)) ||
		room1.equals(con.room2) && room2.equals(con.room1));
    }

    public void setAccess(Access a){
	this.access=a;
    }

    public void setAccess(String s){
	s=s.toLowerCase();
	switch(s){
	case "unlocked":
	    setAccess(Access.Unlocked);
	    break;

	case "locked":
	    setAccess(Access.Locked);
	    break;

	case "closed":
	    setAccess(Access.Closed);
	    break;

	default:
	    ErrorControl.error();
	    break;
	}
    }

    public boolean isUnlocked(){
	return (access==Access.Unlocked);
    }

    public boolean isLocked(){
	return (access==Access.Locked);
    }

    public String toString(){
	ErrorControl.error();
	room1.toString();
	return room1.toString()+" <-> "+room2.toString()+". "+access.toString();
    }

    public String toStringAccess(){
	/*
	switch (access){
	case Unlocked:
	    return "Unlocked";

	case Closed:
	    return "Closed";

	case Locked:
	    return "Locked";

	default:
	    return "Unknown access";
	    }*/
	return "Unknown access";
    }

    public int hashCode(){
	ErrorControl.error();
	return -1;
    }
}
