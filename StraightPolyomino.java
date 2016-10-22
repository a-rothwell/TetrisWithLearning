import java.awt.*;

public class StraightPolyomino extends Piece {
    private Color[][] pieceShapeHorizontal = {{Color.blue }, {Color.blue}, {Color.blue}, {Color.blue}};
    private Color[][] pieceShapeVertical = {{Color.blue , Color.blue, Color.blue, Color.blue}};
    private boolean vertical = true;
    public StraightPolyomino(boolean vertical){
        super();
        super.setPieceShape(pieceShapeVertical);
        super.setColor(Color.blue);
        this.vertical = vertical;
    }
    @Override
    public Color[][] rotate(Spaces[][] board){
        return null;
    }
    @Override
    public Color[][] getPieceShape(){
        if(vertical){
            return pieceShapeVertical;
        }
        else {
            return pieceShapeHorizontal;
        }
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
    @Override
    public void moveLeft(Spaces[][] board) {
        for (int i = 0; i < this.getPieceShape().length; i++) {
            for (int j = 0; j < this.getPieceShape()[i].length; j++)
                board[this.getX() + i][this.getY() + j].setColor(Color.white);
        }
        this.decrementX();
        for (int i = 0; i < this.getPieceShape().length; i++) {
            for (int j = 0; j < this.getPieceShape()[i].length; j++)
                board[this.getX() + i][this.getY() + j].setColor(this.getColor());
        }
    }
    @Override
    public void moveRight(Spaces[][] board){
        for (int i = 0; i < this.getPieceShape().length; i++) {
            for (int j = 0; j < this.getPieceShape()[i].length; j++)
                board[this.getX()][this.getY() + j].setColor(Color.white);
        }
        this.incrementX();
        for (int i = 0; i < this.getPieceShape().length; i++) {
            for (int j = 0; j < this.getPieceShape()[i].length; j++)
                board[this.getX() + i][this.getY() + j].setColor(this.getColor());
        }
    }
    public void setVerticalFalse(){
        this.vertical = false;
    }
}
