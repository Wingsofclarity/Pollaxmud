public class Student extends NPC{
    Course completedC;
    Course currentC;
    
    Student(String name, Room room, Course completed, Course current){
	super(name, room);
	assert(!completed.equals(current));
	this.completedC=completed;
	this.currentC=current;
    }

    @Override
    public String toString(){
	return "Student: "+super.toString();
    }

    @Override
    public void interact(Player player){
	System.out.println("Hello there! I'm " + name + ".");	

	if (player.hasNotFinished(completedC)){

	    System.out.println("If I can have your book on " + currentC + " I will help you with " + completedC + ".");	
	    System.out.println("Do you want to talk and I'll give you some hints for your exam, or do you want to trade my book for yours?");

	    String ans = System.console().readLine();
	    
	    switch (ans){
	    case "talk":
		System.out.println(completedC.getQuestion());
		break;
	    case "trade":
		trade(player);
		break;
	    default:
		System.out.println("I didn't catch that, sorry.");
	   
	    }
	}
	else{
	    System.out.println("You have not been properly registered for this course, so there's no point in me helping you.");	  
	}
    }
    
    public void trade(Player player){ //Logik för om spelaren har boken ska flyttas & anropas från interact
	int size = player.getBackpack().getBooks().size();
	Book[] books = player.getBackpack().getBooks().toArray(new Book[size]);

	for(int i = 0; i < books.length; i++){
	    Book book = books[i];
	    if (book.sameSubject(currentC)){
		player.getBackpack().getContent().remove(book);
		System.out.println("Thank you for the book! Here's one on " + completedC  + " for you.");
		player.getBackpack().getContent().add(new Book(completedC));
		return;
	    }
	}
	System.out.println("Sorry, you don't have the book I need."); 
    }
	

}

