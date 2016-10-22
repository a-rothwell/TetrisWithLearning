import java.util.Random;
import java.util.TimerTask;

/**
 * Start of AI
 */
public class AI {
    public static void main(String[] args){
        Random random = new Random();
        TetrisWithLearning tetrisWithLearning = new TetrisWithLearning();
        java.util.Timer timer = new java.util.Timer();
        TimerTask run = new TimerTask() {
            public void run() {
                    int choice = random.nextInt(3);
                    if(tetrisWithLearning.activePiece == null){
                        tetrisWithLearning.dispose();
                    }
                    switch (choice){
                        case 0:
                            if(tetrisWithLearning.activePiece != null){
                                tetrisWithLearning.moveDown();
                            }
                            break;
                        case 1:
                            if(tetrisWithLearning.activePiece != null){
                                tetrisWithLearning.moveLeft();
                            }
                            break;
                        case 2:
                            if(tetrisWithLearning.activePiece != null){
                                tetrisWithLearning.moveRight();
                            }
                            break;
                    }
            }
        };
        TimerTask start = new TimerTask() {
            public void run() {
                AI ai = new AI();
                ai.main(null);
            }
        };
        try{
            timer.schedule(run, 1000, 50);
            timer.schedule(start, 45000);
        }
        catch (IllegalStateException e){
            System.out.println(e);
        }

    }
}
