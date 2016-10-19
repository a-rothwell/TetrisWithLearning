import javax.swing.*;
import java.awt.*;

/**
 * Created by Andrew on 10/19/2016.
 */
public class Spaces{
    int xPosition;
    int yPosition;
    JButton jButton;
    public Spaces(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.jButton = new JButton();
        jButton.setSize(25,25);
        jButton.setLocation(25 * xPosition, 25 * yPosition);
        jButton.setEnabled(false);
        jButton.setBackground(Color.WHITE);
        jButton.setBorderPainted(false);
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
