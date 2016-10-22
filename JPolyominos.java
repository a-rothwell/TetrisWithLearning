import java.awt.*;

public class JPolyominos  extends Piece{
    private Color[][] pieceShape = {{Color.white, Color.yellow},{Color.white,Color.yellow},{Color.yellow, Color.yellow}};
    public JPolyominos(){
        super();
        this.setPieceShape(pieceShape);
        this.setColor(Color.yellow);
    }
    @Override
    public void moveDown(Spaces[][] board){
        for (int i = 0; i < this.getPieceShape().length; i++ ) {
            board[this.getX() + i][this.getY()].setColor(Color.white);
            board[this.getX() + i][this.getY() + this.getPieceShape()[i].length - 1].setColor(Color.white);
        }
        this.incrementY();
        for (int i = 0; i < this.getPieceShape().length; i++ ) {
            board[this.getX() + i][this.getY()].setColor(this.getPieceShape()[i][0]);
            if(!this.getPieceShape()[i][this.getPieceShape()[i].length - 1].equals(Color.WHITE)){
                board[this.getX() + i][this.getY() + this.getPieceShape()[i].length - 1].setColor(this.getPieceShape()[i][this.getPieceShape()[i].length - 1]);
            }

        }
    }
}
