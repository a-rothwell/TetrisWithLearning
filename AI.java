import java.util.Random;

/**
 * Start of AI
 */
public class AI {
    public static void main(String[] args){
        Random random = new Random();
        TetrisWithLearning tetrisWithLearning = new TetrisWithLearning();

        for(int i = 0; i < 50; i++){
            int choice = random.nextInt(3);
            System.out.println(choice);
            switch (choice){
                case 0:
                    System.out.println("AI MoveDown");
                    tetrisWithLearning.moveDown();
                    break;
                case 1:
                    System.out.println("AI MoveLeft");
                    tetrisWithLearning.moveLeft();
                    break;
                case 2:
                    System.out.println("AI MoveRight");
                    tetrisWithLearning.moveRight();
                    break;
            }
        }
    }
}
