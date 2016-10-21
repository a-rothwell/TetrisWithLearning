import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.TimerTask;


public class TetrisWithLearning extends JFrame{
    private Spaces[][] board = new Spaces[10][24];
    private Piece activePiece = null;
    Random random = new Random();
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
        board[1][23].setColor(Color.BLACK);
        board[1][22].setColor(Color.BLACK);
        board[1][21].setColor(Color.BLACK);
        board[0][23].setColor(Color.BLACK);
        board[0][22].setColor(Color.BLACK);
        board[0][21].setColor(Color.BLACK);
        board[0][20].setColor(Color.BLACK);

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
                    rotate();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }
    private void moveLeft() {
        boolean canLeft;
        for (int i = 0; i < activePiece.getPieceShape().length; i++ ) {
            for(int j = 0; j < activePiece.getPieceShape()[i].length; j++ )
                board[activePiece.getX() + i][activePiece.getY() + j].setColor(Color.white);
        }
        activePiece.decrementX();
        for (int i = 0; i < activePiece.getPieceShape().length; i++ ) {
            for(int j = 0; j < activePiece.getPieceShape()[i].length; j++ )
                board[activePiece.getX() + i][activePiece.getY() + j].setColor(activePiece.getColor());
        }
        repaint();
        play();
    }
    private void moveRight(){
        boolean canRight;
        for (int i = 0; i < activePiece.getPieceShape().length; i++ ) {
            for(int j = 0; j < activePiece.getPieceShape()[i].length; j++ )
            board[activePiece.getX()][activePiece.getY() + j].setColor(Color.white);
        }
        activePiece.incrementX();
        for (int i = 0; i < activePiece.getPieceShape().length; i++ ) {
            for(int j = 0; j < activePiece.getPieceShape()[i].length; j++ )
                board[activePiece.getX() + i][activePiece.getY() + j].setColor(activePiece.getColor());
        }
        repaint();
        play();
    }
    private void moveDown(){
        boolean canFall;
        canFall = activePiece.canFall(board);
        if(canFall) {
            for (int i = 0; i < activePiece.getPieceShape().length; i++ ) {
                    board[activePiece.getX() + i][activePiece.getY()].setColor(Color.white);
            }
            activePiece.incrementY();
            for (int i = 0; i < activePiece.getPieceShape().length; i++ ) {
                board[activePiece.getX() + i][activePiece.getY() + activePiece.getPieceShape()[i].length - 1].setColor(activePiece.getColor());
            }
        }
        if(!canFall){
            activePiece = null;
        }
        repaint();
        play();
    }
    private void rotate(){
        activePiece.rotate();


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
    public void play(){
        int downRate = 1000;
        if(activePiece == null){
            generatePiece();
        }
        try{
            timer.schedule(run, 10000, downRate);
        }
        catch (IllegalStateException e){}
    }

    private void generatePiece() {
        Piece[] randomPiece = {new SquarePolyomino(), new StraightPolyomino()};
        int randomInt = random.nextInt(2);
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