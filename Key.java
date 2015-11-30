public class Key extends Item{
    private boolean spent;
    private static int no = 0;
    
    Key(){
        super("key"+no, 1);
        spent = false;
	no++;
    }

    public void setSpent(){
	spent = true;    
    }

}
