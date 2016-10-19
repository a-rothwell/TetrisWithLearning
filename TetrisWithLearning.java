import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.TimerTask;


public class TetrisWithLearning extends JFrame{
    private Spaces[][] board = new Spaces[10][24];
    private int downRate = 1000;
    java.util.Timer timer = new java.util.Timer();
    TimerTask task = new TimerTask() {
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
        board[5][5].getjButton().setBackground(Color.black);
        board[4][5].getjButton().setBackground(Color.lightGray);
        board[3][5].getjButton().setBackground(Color.GRAY);
        board[2][5].getjButton().setBackground(Color.orange);
        board[1][5].getjButton().setBackground(Color.yellow);

        board[5][16].getjButton().setBackground(Color.blue);
        board[5][15].getjButton().setBackground(Color.green);
        board[2][21].getjButton().setBackground(Color.red);
        board[1][22].getjButton().setBackground(Color.yellow);
        board[4][6].getjButton().setBackground(Color.magenta);


        jFrame.setVisible(true);
        jFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("KEY PRESS");
                int key = e.getKeyCode();
                if(key == KeyEvent.VK_LEFT){
                    moveLeft();
                }
                if(key == KeyEvent.VK_RIGHT){
                    moveRight();
                }
                if(key == KeyEvent.VK_DOWN){
                    System.out.print("Move Down");
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

        play();
    }
    private void moveRight(){

        play();
    }
    private void moveDown(){
        for(int i = board.length - 1 ; i > 0;i--){
            for(int j = board[i].length - 1; j > 0; j--){
                if(i + 1 != board.length && j + 1 != board[i].length && board[i][j + 1].getColor().equals(Color.white)){
                    board[i][j + 1].setColor(board[i][j].getColor());
                    board[i][j].setColor(Color.WHITE);
                }
            }
        }
        repaint();
        play();
    }
    private void rotate(){
        play();
    }
    public void play(){
        try{
            timer.schedule(task, 5, downRate);
        }
        catch (IllegalStateException e){}
    }
    public boolean gameover(){
        return false;
    }
}