package pool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

public class ball extends JPanel 
{
    double x = 300, y = 130;
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        Ellipse2D circle = new Ellipse2D.Double(x,y,20,20);
        g2.setColor(Color.red);
        g2.fill(circle);
    }
    public void changePosition(double xc, double yc)
    {
        this.x = xc;
        this.y = yc;
        repaint();
    }
}