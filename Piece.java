import java.awt.*;
public class Piece {
    private java.awt.Color[][] pieceShape;
    private Point point = new Point();
    private Color color = Color.black;
    public Piece(){

    }
    public Color[][] rotate(){

        for(int i = 0; i < 4 ;i++){
            for(int j = 0; j < 4 ; j++){
                pieceShape[i][j] = this.pieceShape[i][j];
            }
        }
        return pieceShape;
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
    public void setPoint(int xPosition, int yPosition){
        this.point.setLocation(xPosition, yPosition);
    }
    public Point getPoint(){
        return this.point.getLocation();
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
