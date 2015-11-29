import java.util.*;

public class Backpack{
 private LinkedList<Item> content = new LinkedList<>();

    Backpack(){
    }

    public LinkedList<Book> getBooks(){
	LinkedList<Book> books = new LinkedList<>();
	Iterator<Item> iterContent = content.iterator();

	for(int i = 0; i < content.size(); i++){
	    Item current = iterContent.next();
	    if(current instanceof Book){
		books.add((Book)current);
	    }
	}
	return books;
    }


    public LinkedList<Item> getContent(){
	return content;
    }

}
