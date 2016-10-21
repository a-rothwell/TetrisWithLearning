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
        this.setColor(Color.red);
    }
    @Override
    public boolean canLeft(Spaces[][] board){
        return false;
    }
    @Override
    public boolean canRight(Spaces[][] board){
        return false;
    }
    @Override
    public boolean canFall(Spaces[][] board){
        boolean canFall = true;
        for(int i = 0; i < pieceShape.length; i++){
            for(int j = 0; j < pieceShape[i].length; j++)
            if(getY() == 22 || !board[getX() + j][getY() + pieceShape.length].getColor().equals(Color.white)){
                canFall = false;
            }
        }
        return canFall;
    }
}
