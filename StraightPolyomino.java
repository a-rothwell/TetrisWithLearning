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
    @Override
    public boolean canFall(Spaces[][] board) {
        boolean canFall = true;
        for(int i = 0; i < this.getPieceShape().length; i++){
            if(getY() + getPieceShape()[i].length  >= 24  || !board[getX() + i][getY() + this.getPieceShape()[i].length].getColor().equals(Color.white)) {
                System.out.println("Can't fall");
                canFall = false;
            }
        }
        return canFall;
    }
    public void setVerticalFalse(){
        this.vertical = false;
    }
}
