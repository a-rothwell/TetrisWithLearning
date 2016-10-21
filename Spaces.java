import javax.swing.*;
import java.awt.*;

/**
 * Created by Andrew on 10/19/2016.
 */
public class Spaces{
    int xPosition;
    int yPosition;
    JButton jButton;
    int top = 1;
    int bottom = 1;
    int left = 1;
    int right = 1;
    public Spaces(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.jButton = new JButton();
        jButton.setSize(25,25);
        jButton.setLocation(50 + (25 * xPosition), 25 * yPosition);
        jButton.setEnabled(false);
        jButton.setBackground(Color.WHITE);
        if(xPosition == 0){
            this.left = 1;
        }
        if(xPosition == 9){
            this.right = 1;
        }
        if(yPosition == 0){
            this.top = 1;
        }
        if(yPosition == 3){
            this.bottom = 1;
        }
        if(yPosition == 23){
            this.bottom = 1;
        }
        jButton.setBorder(BorderFactory.createMatteBorder(top,left,bottom,right,Color.BLACK));

    }
    public int getxPosition(){
        return this.xPosition;
    }
    public int getyPosition(){
        return this.yPosition;
    }
    public Color getColor(){
        return this.jButton.getBackground();
    }
    public void setColor(Color color){
        this.jButton.setBackground(color);
    }
    public JButton getjButton(){
        return this.jButton;
    }
}
