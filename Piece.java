import java.awt.*;
public class Piece {
    private java.awt.Color[][] pieceShape;
    private Point point = new Point();
    private Color color = Color.black;
    public Piece(){

    }
    public Color[][] rotate(){
        return pieceShape;
    }

    public Color[][] getPieceShape() {
        return pieceShape;
    }

    public void setPieceShape(Color[][] peiceShape) {
        this.pieceShape = peiceShape;
    }

    public boolean canFall(Spaces[][] board) {
        boolean canFall = true;
        for(int i = 0; i < this.getPieceShape().length; i++){
            if(getY() + getPieceShape()[i].length  >= 24  || !board[getX() + i][getY() + this.getPieceShape()[i].length].getColor().equals(Color.white)) {
                canFall = false;
            }
        }
        return canFall;
    }
    public boolean canRight(Spaces[][] board){
        boolean canRight = true;
        for(int j = 0; j < this.getPieceShape()[this.getPieceShape().length - 1].length; j++){
            if(getX() + getPieceShape().length  >= 10  || !board[getX() + this.getPieceShape().length][getY() + j].getColor().equals(Color.white)) {
                canRight = false;
            }
        }
        return canRight;
    }
    public boolean canLeft(Spaces[][] board){
        boolean canLeft = true;
        for(int j = 0; j < this.getPieceShape()[0].length; j++){
            if(getX() <=0  || !board[getX() - 1][getY() + j].getColor().equals(Color.white)) {
                canLeft = false;
            }
        }
        return canLeft;
    }
    public void setPoint(int xPosition, int yPosition){
        this.point.setLocation(xPosition, yPosition);
    }
    public int getX(){
        return this.point.x;
    }
    public int getY(){
        return this.point.y;
    }
    public void incrementY() {
        this.point.y++;
    }
    public void incrementX(){
        this.point.x++;
    }
    public void decrementX(){
        this.point.x--;
    }
    public Color getColor(){
        return this.color;
    }
    public void setColor(Color color){
        this.color = color;
    }
}
