import java.awt.*;

/**
 * Created by Andrew on 10/19/2016.
 */
public class SquarePolyomino extends Piece {
    private Color[][] pieceShape = {{Color.red, Color.red},
            {Color.red, Color.red}};

    public SquarePolyomino() {
        super();
        this.setPieceShape(pieceShape);
        this.setColor(Color.red);
    }
    @Override
    public void moveDown(Spaces[][] board){
        for (int i = 0; i < this.getPieceShape().length; i++ ) {
            board[this.getX() + i][this.getY()].setColor(Color.white);
        }
        this.incrementY();
        for (int i = 0; i < this.getPieceShape().length; i++ ) {
            board[this.getX() + i][this.getY() + this.getPieceShape()[i].length - 1].setColor(this.getColor());
        }
    }
}
