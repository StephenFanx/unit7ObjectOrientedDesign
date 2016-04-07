import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

/**
 * Write a description of class ControlPanel here.
 * 
 * @author Stephen Fan
 * @version 4/7
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
        
        //adds buttons
        this.add(colorButton);
        this.add(circleButton);
        this.add(squareButton);
        
        //sets the background
        this.panel.setBackground(this.canvas.getColor());
        
        //adds listeners
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
                //allows the user to pick a color
                canvas.pickColor();
                panel.setBackground(canvas.getColor());
            }
            else if (event.getSource().equals(circleButton))
            {
                //allows the user to add a circle to the drawing editor
                canvas.addCircle();
            }
            else if (event.getSource().equals(squareButton))
            {
                //allows the user to add a square to the drawing editor
                canvas.addSquare();
            }
        }
    }
}
