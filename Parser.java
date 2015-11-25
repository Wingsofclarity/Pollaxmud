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

    public static LinkedList<Creature> parseCreature(FileReader creatureFile, LinkedList<Course> courses){

	assert(courses.size()>1);
	LinkedList<Creature> creatures = new LinkedList<Creature>();
	try(BufferedReader br = new BufferedReader(creatureFile)) {
	    for(String line; (line = br.readLine()) != null; ) {

		switch (line){
		case "randomStudent":
		    creatures.add(randomStudent(courses));
		    break;

		case "randomTeacher":
		    creatures.add(randomTeacher(courses));
		    break;

		default:
		    creatures.add(new Student(line));
		    break;	
		}
	    }
	    return creatures;
	}
	catch (IOException e){
	    ErrorControl.error();
	    return creatures;
	}

    }

    public static LinkedList<Connection> parseConnection(FileReader connectionFile){
	ErrorControl.error();
	LinkedList<Connection> connections = new LinkedList<Connection>();
	/*
	try(BufferedReader br = new BufferedReader(connectionFile)) {
	    for(String line; (line = br.readLine()) != null; ) {
		connections.add(new Student(line));
	    }
	    return connections;
	}
	catch (IOException e){
	    ErrorControl.error();
	    return connections;
	    }*/
	return connections;
    }

    public static LinkedList<Course> parseCourse(FileReader courseFile){
	LinkedList<Course> courses = new LinkedList<Course>();
	try(BufferedReader br = new BufferedReader(courseFile)) {
	    for(String line; (line = br.readLine()) != null; ) {
		if (line.equals("randomCourse")){
		    ErrorControl.error();
		    courses.add(randomCourse());
		}
		else{
		    String[] devided = line.split(", ");
		    assert(devided.length==3);
		    courses.add(new Course(devided[1], devided[0], Integer.parseInt(devided[2])));
		}
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

    public static Student randomStudent(LinkedList<Course> courses){
	Course c1 = courses.get(randomWithRange(0,courses.size()-1));
	Course c2 = courses.get(randomWithRange(0,courses.size()-1));
        while (c2==c1){
	    c2 = courses.get(randomWithRange(0,courses.size()-1));
	}
	return new Student("Studentguy",c1 ,c2);
    }

    public static Teacher randomTeacher(LinkedList<Course> courses){
	Course c = courses.get(randomWithRange(0,courses.size()-1));
	return new Teacher("Teacherguy", c);
    }


    public static Course randomCourse(){
	ErrorControl.error();
	return new Course();
    }

    public static Room randomRoom(){
	ErrorControl.error();
	return new Room();
    }

    public static LinkedList<Connection> randomConnection(LinkedList<Room> rooms){
	ErrorControl.error();
	return new LinkedList<Connection>();
    }

    public static int randomWithRange(int min, int max)
    {
	int range = (max - min) + 1;     
	return (int)(Math.random() * range) + min;
    }

}
