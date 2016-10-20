import java.awt.*;

/**
 * Created by Andrew on 10/19/2016.
 */
public class StraightPolyomino extends Piece {
    private Color[][] pieceShape = {{Color.white , Color.white, Color.white, Color.white},
            {Color.white , Color.white, Color.white, Color.white},
            {Color.white , Color.white, Color.white, Color.white},
            {Color.blue , Color.blue, Color.blue, Color.blue}};
    public StraightPolyomino(){
        super();
        System.out.println("Straight Piece");
        this.setPieceShape(pieceShape);
    }

}
