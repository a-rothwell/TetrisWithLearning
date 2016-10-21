import java.awt.*;

public class StraightPolyomino extends Piece {
    private Color[][] pieceShapeHorizantal = {{Color.blue }, {Color.blue}, {Color.blue}, {Color.blue}};
    private Color[][] pieceShapeVertical = {{Color.blue , Color.blue, Color.blue, Color.blue}};
    private boolean vertical = true;
    public StraightPolyomino(boolean vertical){
        super();
        super.setPieceShape(pieceShapeVertical);
        super.setColor(Color.blue);
        this.vertical = vertical;
    }
    @Override
    public Color[][] rotate(){
        return null;
    }
    @Override
    public Color[][] getPieceShape(){
        if(vertical){
            return pieceShapeVertical;
        }
        else {
            return pieceShapeHorizantal;
        }
    }
    public void setVerticalFalse(){
        this.vertical = false;
    }
}
