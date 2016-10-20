import java.awt.*;
public class Piece {
    private java.awt.Color[][] pieceShape;
    public Piece(){
        System.out.println("Piece");
    }
    public Color[][] rotate(){
        Color[][] pieceShape = {{Color.white , Color.white, Color.white, Color.white},
                {Color.white , Color.white, Color.white, Color.white},
                {Color.white , Color.white, Color.white, Color.white},
                {Color.white , Color.white, Color.white, Color.white}};
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
}
