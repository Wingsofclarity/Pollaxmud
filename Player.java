public class Player extends Creature{
    private int hp = 0;

    public int getHp(){
	return hp;
    }

    @Override
    public void move(Room to){
	super.move(to);
	System.out.println("I just entered "+location.toString());
    }

    public String toString(){
	return "Player: "+super.toString();
    }
}
