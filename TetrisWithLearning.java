import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.TimerTask;


public class TetrisWithLearning extends JFrame{
    private Spaces[][] board = new Spaces[10][24];
    private Piece movingPeice;
    private boolean activePeice = false;
    private int drop;
    java.util.Timer timer = new java.util.Timer();
    TimerTask run = new TimerTask() {
        public void run() {
            moveDown();
        }
    };
    public TetrisWithLearning(){
        setUp();
        play();
    }
    public Spaces[][] getBoard(){
        return this.board;
    }
    public void setUp(){
        JFrame jFrame = new JFrame();
        jFrame.setSize(600,1200);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container container = jFrame.getContentPane();
        container.setLayout(null);
        for (int i = 0; i < this.getBoard().length;i++){
            for( int j = 0; j < this.getBoard()[i].length;j++){
                board[i][j] = new Spaces(i,j);
                container.add(board[i][j].jButton);
            }
        }
        board[3][23].setColor(Color.BLACK);
        jFrame.setVisible(true);
        jFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if(key == KeyEvent.VK_LEFT){
                    moveLeft();
                }
                if(key == KeyEvent.VK_RIGHT){
                    moveRight();
                }
                if(key == KeyEvent.VK_DOWN){
                    moveDown();
                }
                if(key == KeyEvent.VK_R){
                    System.out.println("Rotate");
                    rotate();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }
    private void moveLeft() {

        repaint();
        play();
    }
    private void moveRight(){
        repaint();
        play();
    }
    private void moveDown(){
        boolean canFall = true;
        if(!board[0][4 + drop].getColor().equals(Color.white)){
            System.out.print("FALSE");
            canFall = false;
        }
        if(!board[1][4 + drop].getColor().equals(Color.white)){
            System.out.print("FALSE");
            canFall = false;
        }
        if(!board[2][4 + drop].getColor().equals(Color.white)){
            System.out.print("FALSE");
            canFall = false;
        }
        if(!board[3][4 + drop].getColor().equals(Color.white)){
            System.out.print("FALSE");
            canFall = false;
        }

        if(canFall) {
            drop++;
            for (int i = board.length - 1; i > -1; i--) {
                for (int j = board[i].length - 1; j > -1; j--) {
                    if (j + 1 != board[i].length && board[i][j + 1].getColor().equals(Color.white) && canFall) {
                        board[i][j + 1].setColor(board[i][j].getColor());
                        board[i][j].setColor(Color.WHITE);
                    }
                }
            }
        }

        repaint();
        play();
    }
    private void rotate(){
        Color[][] pieceShape = {{Color.white , Color.white, Color.white, Color.white},
                {Color.white , Color.white, Color.white, Color.white},
                {Color.white , Color.white, Color.white, Color.white},
                {Color.white , Color.white, Color.white, Color.white}};


        pieceShape[0][0] = board[3][drop].getColor();
        pieceShape[0][1] = board[2][drop].getColor();
        pieceShape[0][2] = board[1][drop].getColor();
        pieceShape[0][3] = board[0][drop].getColor();
        pieceShape[1][0] = board[3][1 + drop].getColor();
        pieceShape[1][1] = board[2][1 + drop].getColor();
        pieceShape[1][2] = board[1][1 + drop].getColor();
        pieceShape[1][3] = board[0][1 + drop].getColor();
        pieceShape[2][0] = board[3][2 + drop].getColor();
        pieceShape[2][1] = board[2][2 + drop].getColor();
        pieceShape[2][2] = board[1][2 + drop].getColor();
        pieceShape[2][3] = board[0][2 + drop].getColor();
        pieceShape[3][0] = board[3][3 + drop].getColor();
        pieceShape[3][1] = board[2][3 + drop].getColor();
        pieceShape[3][2] = board[1][3 + drop].getColor();
        pieceShape[3][3] = board[0][3 + drop].getColor();

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                board[i][j + drop].setColor(pieceShape[i][j]);
            }
        }
        repaint();
        play();
    }
    public void play(){
        int downRate = 1000;
        if(!activePeice){
            generatePiece();
        }
        try{
            timer.schedule(run, 10000, downRate);
        }
        catch (IllegalStateException e){}
    }

    private void generatePiece() {
        System.out.println("Generate Piece");
        SquarePolyomino straightPolyomino = new SquarePolyomino();
//        Color[][] straightPolyomino = {{Color.red , Color.yellow, Color.cyan, Color.gray},
//                {Color.magenta , Color.pink, Color.BLUE, Color.lightGray},
//                {Color.yellow , Color.pink, Color.pink, Color.lightGray},
//                {Color.cyan , Color.magenta, Color.blue, Color.red}};
        movingPeice = straightPolyomino;
        for(int i = 0 ; i < 4 ; i++ ){
            for(int j = 0; j < 4; j++){
                //board[i][j].setColor(straightPolyomino.getPieceShape()[i][j]);
                board[i][j].setColor(movingPeice.getPieceShape()[i][j]);
            }
        }
        activePeice = true;
        repaint();
    }
}