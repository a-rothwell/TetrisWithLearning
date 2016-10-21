import java.awt.*;

/**
 * Created by Andrew on 10/19/2016.
 */
public class SquarePolyomino extends Piece{
    private Color[][] pieceShape = {{Color.red , Color.red},
            {Color.red, Color.red}};
    public SquarePolyomino(){
        super();
        System.out.println("Straight Piece");
        this.setPieceShape(pieceShape);
    }
    @Override
    public Color[][] rotate() {
        return pieceShape;
    }
    @Override
    public boolean canFall(){
        return true;
    }
}
