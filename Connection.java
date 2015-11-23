public class Connection{
    public enum Access{
	Unlocked("Unlocked"), Locked("Locked"), Closed("Closed");

	private String s;
	
	private Access(String s){
	    this.s = s;
	}
    }
    Access access = Access.Closed;
    Room room1;
    Room room2;
    

    Connection(Room room1, Room room2){
	this.room1=room1;
	this.room2=room2;
    }

    public Room connect(Room room){
	if (room.equals(room1)){
	    return room2;
	}
	else {
	    return room1;
	}
    }

    public EqList<Room> getRooms(){
	EqList<Room> list = new EqList<Room>();
	list.addElement(room1);
	list.addElement(room2);
	return list;
    }

    public boolean equals(Object o){
	assert(o instanceof Connection);
	Connection con = (Connection) o;
	return getRooms().equals(con.getRooms());
    }

    public void setAccess(Access a){
	this.access=a;
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
}
