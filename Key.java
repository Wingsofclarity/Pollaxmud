public class Key extends Stackable{
    private boolean spent;

    Key(){
        super("key", 1);
        spent = false; 
    }

    public void setSpent(){
        spent = true;    
    }

}
