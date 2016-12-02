import java.awt.*;
import java.util.Random;

public class AITask implements Runnable{
    Random random = new Random();
    private TetrisWithLearning tetrisWithLearning = new TetrisWithLearning();
    private TetrisWithLearning testGame = new TetrisWithLearning();
    public void run() {
        Spaces[][] currentBoard = tetrisWithLearning.getBoard();
        int ifMoveDown;
        int ifMoveRight;
        int ifMoveLeft;
//        while(tetrisWithLearning.getActivePiece() == null){
//            //System.out.println("Waiting");
//        }
        testGame.setBoard(currentBoard,tetrisWithLearning.getActivePiece());
        testGame.moveDown();
        ifMoveDown = score(testGame.getBoard(),testGame.getScore());

        testGame.setBoard(currentBoard,tetrisWithLearning.getActivePiece());
        testGame.moveRight();
        ifMoveRight = score(testGame.getBoard(),testGame.getScore());

        testGame.setBoard(currentBoard,tetrisWithLearning.getActivePiece());
        testGame.moveLeft();
        ifMoveLeft = score(testGame.getBoard(),testGame.getScore());

        System.out.println(ifMoveDown);
        System.out.println(ifMoveRight);
        System.out.println(ifMoveLeft);

        if(ifMoveDown > ifMoveLeft && ifMoveDown > ifMoveLeft){
            tetrisWithLearning.moveDown();
        }
        else if(ifMoveRight > ifMoveLeft){
            tetrisWithLearning.moveRight();
        }
        else if(ifMoveLeft > ifMoveRight){
            tetrisWithLearning.moveLeft();
        }
        else{
            System.out.println("Random");
            int choice = random.nextInt(3);
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
    }
    private static int score(Spaces[][] board,int score){
        int whiteSpaces = 0;
        for(int i = 0; i < 24; i++){
            for(int j = 0 ; j < 10  ; j++){
                if(board[j][i].getColor().equals(Color.white)){
                    whiteSpaces++;
                }
            }
        }
        return whiteSpaces * 5 + score * 10;
    }
}
