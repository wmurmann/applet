//Programmer's name:  William Murmann
//Email address:      wmurmann@gmail.com
//Course:             CPSC223j
//Assignment number:  assignment 4
//Due date:           2013-nov-4



//Project: A program that simulates a random maze

//This module defines the properties of the user interface

package pool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JTextField;

public class PoolFrame extends JFrame
{
    //variables
    double angle = 0;
    
    //objects
    public ball b;
    private JButton newGame, go, pause, exit;
    private JLabel NewGame, Speed, Direction, Table;
    private JTextField speed, direction;
    private Timer timer;
    
    //layout managers
    private GridBagLayout grid;
    private FlowLayout field;
    private FlowLayout global;
    //panels
    private JPanel GameField, input,spacer;
    private ActionListener actionlistener;
    private PoolApplet myapplet;
    
    public PoolFrame(PoolApplet mainapp)
    {
        super("Pool by William Murmann");
        myapplet = mainapp;  
        grid = new GridBagLayout();
        global = new FlowLayout(FlowLayout.CENTER,0,0);
        setLayout(global);
        
        timer = new Timer();
        
        GridBagConstraints c = new GridBagConstraints();
        Font gen = new Font("Sans-Serif", Font.PLAIN, 18);
        
        //Input fields
        b = new ball();
        b.setPreferredSize(new Dimension(600,300));
        b.setSize(600,300);
        b.setBackground(Color.black);
        
        
        spacer = new JPanel();
        spacer.setPreferredSize(new Dimension(1200,5));

        
        JPanel input = new JPanel();
        input.setLayout(grid);
        
        Speed = new JLabel("Speed");
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(0,10,20,0);
        input.add(Speed, c);
        
        speed = new JTextField();
        speed.setPreferredSize(new Dimension(75,30));
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(0,10,20,0);
        input.add(speed, c);
        
        Direction = new JLabel("Direction");
        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(0,10,20,0);
        input.add(Direction, c);
        
        direction = new JTextField();
        direction.setPreferredSize(new Dimension(75,30));
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(0,10,20,0);
        input.add(direction, c);
        
        newGame = new JButton("New");
        c.gridx = 0;
        c.gridy = 3;
        input.add(newGame, c);
        
        go = new JButton("Go");
        c.gridx = 1;
        c.gridy = 3;
        input.add(go, c);
        
        pause = new JButton("Pause");
        c.gridx = 2;
        c.gridy = 3;
        input.add(pause, c);
        
        exit = new JButton("Exit");
        c.gridx = 3;
        c.gridy = 3;
        input.add(exit, c);
        
        buttonhandler action = new buttonhandler();
        newGame.addActionListener(action);
        go.addActionListener(action);
        pause.addActionListener(action);
        exit.addActionListener(action);
        
        add(b);
        add(spacer);
        add(input);
        setSize(600,900);
        setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
    }
    private class buttonhandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == newGame)
            {
               angle = 0;
               b.changePosition(300, 130);
               timer.cancel();
               speed.setText("");
               direction.setText("");
            }
            else if(event.getSource() == go)
            {
                timer.cancel();
                if(!"".equals(speed.getText()) && !"".equals(direction.getText()))
                {
                    angle = Double.parseDouble(direction.getText());
                    startTimer(Integer.parseInt(speed.getText()));
                }
            }
            else if(event.getSource() == pause)
            {
                timer.cancel();
            }
            else if(event.getSource() == exit)
            {
                myapplet.close();
            }
        }
        public void startTimer(int HSeconds)
        {
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    move();
                }
            }, 0, HSeconds);
        }
        public void move()
        {
            if(b.x < 0 || b.x > 600)
            {
                timer.cancel();
                b.changePosition(300, 130);
                speed.setText("");
                direction.setText("");
            }
            if(b.y <= 0 || b.y >= 280)
            {
                angle = 180 - angle;
            }
            double X = Math.sin(Math.toRadians(angle));
            double Y = Math.cos(Math.toRadians(angle));
            b.changePosition(b.x + X,b.y + Y);
        
        }
    }
}//end  











