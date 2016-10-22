import javax.swing.*;
import java.awt.*;

/**
 * What the Board is made of
 */
public class Spaces{
    private int xPosition;
    private int yPosition;
    JButton jButton;
    public Spaces(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.jButton = new JButton();
        jButton.setSize(15,15);
        jButton.setLocation(50 + (15 * xPosition), 15 * yPosition);
        jButton.setEnabled(false);
        jButton.setBackground(Color.WHITE);
        int top = 0;
        int bottom = 0;
        int left = 0;
        int right = 0;
        if(xPosition == 0){
            left = 1;
        }
        if(xPosition == 9){
            right = 1;
        }
        if(yPosition == 0){
            top = 1;
        }
        if(yPosition == 3){
            bottom = 1;
        }
        if(yPosition == 23){
            bottom = 1;
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
