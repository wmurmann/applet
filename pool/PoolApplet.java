//Programmer's name:  William Murmann
//Email address:      wmurmann@gmail.com
//Course:             CPSC223j
//Assignment number:  assignment 4
//Due date:           2013-nov-4

//Project: A program that simulates a random maze

//This is the top level module.  This module activates the user interface.
package pool;

/**
 * 
 *
 * @author wm
 */
import java.awt.Graphics;
import java.util.Timer;
import javax.swing.JApplet;
import javax.swing.JFrame;

public class PoolApplet extends JApplet
{
    private JFrame appletFrame;
   
    @Override
    public void init()
    {
        appletFrame = new PoolFrame(this);
        appletFrame.setVisible (true);
        appletFrame.setEnabled (true);
    }//End of main
    public void close()
    {
        appletFrame.dispose();
        appletFrame=null;
    }
}
