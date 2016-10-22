import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.TimerTask;


public class TetrisWithLearning extends JFrame{
    private Spaces[][] board = new Spaces[10][24];
    Piece activePiece = null;
    Random random = new Random();
    JFrame jFrame = new JFrame();
    java.util.Timer timer = new java.util.Timer();
    TimerTask run = new TimerTask() {
        public void run() {
            moveDown();
        }
    };
    public TetrisWithLearning() {
        setUp();
        play();
    }
    public Spaces[][] getBoard(){
        return this.board;
    }
    public void setUp(){
        jFrame.setSize(350,400);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container container = jFrame.getContentPane();
        container.setLayout(null);
        for (int i = 0; i < this.getBoard().length;i++){
            for( int j = 0; j < this.getBoard()[i].length;j++){
                board[i][j] = new Spaces(i,j);
                container.add(board[i][j].jButton);
            }
        }
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
                    System.exit(0);
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }
    public void moveLeft() {
        boolean canLeft = activePiece.canLeft(board);
        if(canLeft) {
            activePiece.moveLeft(board);
        }
        repaint();
        play();
    }
   public void moveRight(){
       boolean canRight = activePiece.canRight(board);
       if(canRight) {
           activePiece.moveRight(board);
       }
        repaint();
        play();
    }
    public  void moveDown(){
        boolean canFall = activePiece.canFall(board);
        if(canFall){
            activePiece.moveDown(board);
        }
        else{
            activePiece = null;
        }
        repaint();
        play();
    }
    private void rotate(){
        activePiece.rotate(board);

//        pieceShape[0][0] = board[3][drop].getColor();
//        pieceShape[0][1] = board[2][drop].getColor();
//        pieceShape[0][2] = board[1][drop].getColor();
//        pieceShape[0][3] = board[0][drop].getColor();
//        pieceShape[1][0] = board[3][1 + drop].getColor();
//        pieceShape[1][1] = board[2][1 + drop].getColor();
//        pieceShape[1][2] = board[1][1 + drop].getColor();
//        pieceShape[1][3] = board[0][1 + drop].getColor();
//        pieceShape[2][0] = board[3][2 + drop].getColor();
//        pieceShape[2][1] = board[2][2 + drop].getColor();
//        pieceShape[2][2] = board[1][2 + drop].getColor();
//        pieceShape[2][3] = board[0][2 + drop].getColor();
//        pieceShape[3][0] = board[3][3 + drop].getColor();
//        pieceShape[3][1] = board[2][3 + drop].getColor();
//        pieceShape[3][2] = board[1][3 + drop].getColor();
//        pieceShape[3][3] = board[0][3 + drop].getColor();

        for(int i = 0; i < activePiece.getPieceShape().length; i++){
            for(int j = 0; j <  activePiece.getPieceShape()[i].length; j++){
                board[i][j].setColor(activePiece.getPieceShape()[i][j]);
            }
        }
        repaint();
        play();
    }
    public void play() {
        int downRate = 1000;
        if(!checkForLoss() && activePiece == null){
            jFrame.dispose();
        }
        if(activePiece == null && checkForLoss()){
            generatePiece();
        }
        try{
            //timer.schedule(run, 1000, downRate);
        }
        catch (IllegalStateException e){
            //System.out.println(e);
        }
    }

    private boolean checkForLoss() {
        for(int i = 0; i < 10; i++){
            for(int j = 0 ; j < 4 ; j++){
                if(!board[i][j].getColor().equals(Color.white)){
                    return false;
                }
            }
        }
        return true;
    }

    private void generatePiece() {
        Piece[] randomPiece = {new SquarePolyomino(), new StraightPolyomino(true), new StraightPolyomino(false), new JPolyominos()};
        int randomInt = random.nextInt(4);
        activePiece = randomPiece[randomInt];
        activePiece.setPoint(0,0);
        for(int i = 0 ; i < activePiece.getPieceShape().length ; i++ ){
            for(int j = 0; j < activePiece.getPieceShape()[i].length; j++){
                board[i][j].setColor(activePiece.getPieceShape()[i][j]);
            }
        }
        repaint();
    }
}