import java.awt.*;

/**
 * Created by Andrew on 10/19/2016.
 */
public class SquarePolyomino extends Piece{
    private Color[][] pieceShape = {{Color.red , Color.red},
            {Color.red, Color.red }};
    public SquarePolyomino(){
        super();
        this.setPieceShape(pieceShape);
    }
    @Override
    public Color[][] rotate() {
        return pieceShape;
    }
    @Override
    public boolean canFall(Spaces[][] board){
        boolean canFall = true;
        for(int i = 0; i < pieceShape[pieceShape.length - 1].length; i++){
            if(getY() + 1 < board[board.length-1].length && !board[getX()][getY() + pieceShape.length].getColor().equals(Color.white)){
                canFall = false;
            }
        }
        return canFall;
    }
}
