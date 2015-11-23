public class Key extends Item{
    private boolean spent;

    Key(){
        super(1);
        spent = false; 
   }

    public void setSpent(){
        this.spent = true;    
    }

}
