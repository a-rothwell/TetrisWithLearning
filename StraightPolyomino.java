import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.*;

/**
 * Created by Andrew on 10/19/2016.
 */
public class StraightPolyomino extends Piece {
    private Color[][] pieceShape = {{Color.blue }, {Color.blue}, {Color.blue}, {Color.blue}};
    public StraightPolyomino(){
        super();
        System.out.println("Straight Piece");
        this.setPieceShape(pieceShape);
    }
    @Override
    public Color[][] rotate(){
        return null;
    }

    @Override
    public boolean canFall(Spaces[][] board) {
        return super.canFall(board);
    }
}
