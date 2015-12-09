public class TestWorld extends TestCase{
    
    public void setUp(){
	FileReader roomFile = new FileReader("resources/roomData.txt");
	FileReader creatureFile = new FileReader("resources/creatureData.txt");
	FileReader connectionFile = new FileReader("resources/connectionData.txt");
	FileReader courseFile = new FileReader("resources/courseData.txt");
	FileReader questionFile = new FileReader("resources/questionData.txt");
	FileReader nameFile = new FileReader("resources/namesData.txt");
	World w = new World(roomFile,creatureFile, connectionFile,
			       courseFile, questionFile, nameFile);
	
	
    }

    
}
