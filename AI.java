/**
 * Start of AI
 */
public class AI {
    public static void main(String[] args){
        try{
            Thread thread = new Thread(new AITask());
            thread.start();
        }
        catch (IllegalStateException e){
            System.out.println(e);
        }
    }
}
