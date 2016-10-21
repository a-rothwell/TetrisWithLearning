import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.TimerTask;


public class TetrisWithLearning extends JFrame{
    private Spaces[][] board = new Spaces[10][24];
    private Piece activePiece = null;
    private boolean canFall;
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

        repaint();
        play();
    }
    private void moveRight(){
        repaint();
        play();
    }
    private void moveDown(){
        canFall = activePiece.canFall(board);
        if(canFall) {
            System.out.println("New Fall");
            for (int i = activePiece.getX(); i < activePiece.getPieceShape().length; i++ ) {
                for (int j = activePiece.getY(); j < activePiece.getPieceShape()[i].length; j++) {
                    System.out.println("i " + i + "\n" + "j " + j + "\n");
                    board[activePiece.getX() + i][activePiece.getY() + 1 + j].setColor(Color.red);
                }
            }
            for (int i = activePiece.getX(); i < activePiece.getPieceShape().length; i++ ) {
                board[activePiece.getX() + i][activePiece.getY()].setColor(Color.white);
            }
        }
        activePiece.incrementY();
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
        SquarePolyomino straightPolyomino = new SquarePolyomino();
//        Color[][] straightPolyomino = {{Color.red , Color.yellow, Color.cyan, Color.gray},
//                {Color.magenta , Color.pink, Color.BLUE, Color.lightGray},
//                {Color.yellow , Color.pink, Color.pink, Color.lightGray},
//                {Color.cyan , Color.magenta, Color.blue, Color.red}};
        activePiece = straightPolyomino;
        activePiece.setPoint(0,0);
        for(int i = 0 ; i < activePiece.getPieceShape().length ; i++ ){
            for(int j = 0; j < activePiece.getPieceShape()[i].length; j++){
                //board[i][j].setColor(straightPolyomino.getPieceShape()[i][j]);
                board[i][j].setColor(activePiece.getPieceShape()[i][j]);
            }
        }
        repaint();
    }
}