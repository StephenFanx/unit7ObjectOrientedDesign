import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

/**
 * Write a description of class ControlPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlPanel extends JPanel
{
    // instance variables - replace the example below with your own
    private JButton colorButton;
    private JButton circleButton;
    private JButton squareButton;
    
    private JPanel panel;
    private DrawingPanel canvas;

    /**
     * Constructor for objects of class ControlPanel
     */
    public ControlPanel(DrawingPanel dpanel)
    {
        // initialise instance variables
        colorButton = new JButton("Pick Color");
        circleButton = new JButton("Add Circle");
        squareButton = new JButton("Add Square");
        
        panel = new JPanel();
        
        this.canvas = dpanel;
        
        this.add(colorButton);
        this.add(circleButton);
        this.add(squareButton);
        
        this.panel.setBackground(this.canvas.getColor());
        
        colorButton.addActionListener(new ButtonListener());
        circleButton.addActionListener(new ButtonListener());
        squareButton.addActionListener(new ButtonListener());
    }

    public class ButtonListener implements ActionListener
    {
        /**
         * The method that is executed whenever a button is clicked
         */
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource().equals(colorButton))
            {
                //If the "Pick Color" button was clicked, allow the 
                //user to pick a drawing color
                canvas.pickColor();
                panel.setBackground(canvas.getColor());
            }
            else if (event.getSource().equals(circleButton))
            {
                //If the "Add Circle" button was clicked, add a 
                //circle to the canvas
                canvas.addCircle();
            }
            else if (event.getSource().equals(squareButton))
            {
                //If the "Add Square" button was clicked, add a 
                //square to the canvas
                canvas.addSquare();
            }
        }
    }
}
