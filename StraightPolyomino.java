import java.awt.*;

public class StraightPolyomino extends Piece {
    private Color[][] pieceShapeHorizantal = {{Color.blue }, {Color.blue}, {Color.blue}, {Color.blue}};
    private Color[][] pieceShapeVertical = {{Color.blue , Color.blue, Color.blue, Color.blue}};
    private boolean vertical = true;
    public StraightPolyomino(){
        super();
        super.setPieceShape(pieceShapeVertical);
        super.setColor(Color.blue);
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
    @Override
    public boolean canFall(Spaces[][] board) {
        boolean canFall = true;
        for(int i = 0; i < this.getPieceShape().length; i++){
            for(int j = 0; j < this.getPieceShape()[i].length; j++)
                if(getY() == 23 || !board[getX() + i][getY() + 1].getColor().equals(Color.white)){
                    canFall = false;
                }
        }
        return canFall;
    }
}
