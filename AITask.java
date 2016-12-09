import java.awt.*;
import java.util.Random;

public class AITask implements Runnable{
    static Random random = new Random();
    private TetrisWithLearning tetrisWithLearning = new TetrisWithLearning();
    private TetrisWithLearning testGame = tetrisWithLearning;
    public void run() {
        Spaces[][] currentBoard = tetrisWithLearning.getBoard();
        int ifMoveDown = 0;
        int ifMoveRight = 0;
        int ifMoveLeft = 0;

        testGame = tetrisWithLearning;
        testGame.moveDown();
        ifMoveDown = score(testGame.getBoard(),testGame.getScore()) - 200;

        testGame = tetrisWithLearning;
        testGame.moveRight();
        ifMoveRight = score(testGame.getBoard(),testGame.getScore());

        testGame = tetrisWithLearning;
        testGame.moveLeft();
        ifMoveLeft = score(testGame.getBoard(),testGame.getScore());

        if(ifMoveDown > ifMoveLeft && ifMoveDown > ifMoveLeft){
            System.out.println("Move down");
            tetrisWithLearning.moveDown();
        }
        else if(ifMoveRight > ifMoveLeft){
            System.out.println("Move left");
            tetrisWithLearning.moveRight();
        }
        else if(ifMoveLeft > ifMoveRight){
            System.out.println("Move right");
            tetrisWithLearning.moveLeft();
        }
        tetrisWithLearning.repaint();
        try {
            this.wait(50000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            run();
        }
    }
    private static int score(Spaces[][] board,int score){
        int whiteSpaces = 0;
        for(int i = 0; i < 24; i++){
            for(int j = 0 ; j < 10  ; j++){
                if(board[j][i].getColor().equals(Color.white)){
                    whiteSpaces = whiteSpaces + j;
                }
            }
        }
        return whiteSpaces * 2 + score * 100 + random.nextInt(100);
    }
}
