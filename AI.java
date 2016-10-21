import java.util.Random;

/**
 * Start of AI
 */
public class AI {
    public static void main(String[] args){
        Random random = new Random();
        TetrisWithLearning tetrisWithLearning = new TetrisWithLearning();

        for(int i = 0; i < 1000; i++){
            int choice = random.nextInt(3);
            switch (choice){
                case 0:
                    tetrisWithLearning.moveDown();
                    break;
                case 1:
                    tetrisWithLearning.moveLeft();
                    break;
                case 2:
                    tetrisWithLearning.moveRight();
                    break;
            }
        }
    }
}
