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
}
