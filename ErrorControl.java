public class ErrorControl{
    private static int num = 0;

    public static void error(){
	error("");
    }

    public static void error(String s){
	System.out.println("Error "+s);
    }
}
