import java.awt.*;
public class Piece {
    private java.awt.Color[][] pieceShape;
    private Point point = new Point();
    private Color color = Color.black;
    public Piece(){

    }
    public Color[][] rotate(){
        Color[][] array = {{Color.white}};
        return array;
    }

    public Color[][] getPieceShape() {
        return pieceShape;
    }

    public void setPieceShape(Color[][] peiceShape) {
        this.pieceShape = peiceShape;
    }

    public boolean canFall(Spaces[][] board) {
        return false;
    }
    public boolean canRight(Spaces[][] board){
        return false;
    }
    public boolean canLeft(Spaces[][] board){
        return false;
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
