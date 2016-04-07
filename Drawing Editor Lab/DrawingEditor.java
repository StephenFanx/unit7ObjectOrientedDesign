import javax.swing.JFrame;
import java.awt.BorderLayout;

/**
 * Write a description of class DrawingEditor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DrawingEditor extends JFrame
{
    /** description of instance variable x (add comment for each instance variable) */
    private DrawingPanel canvas;
    private ControlPanel controls;
    
    private int height;
    private int width;
    /**
     * Default constructor for objects of class DrawingEditor
     */
    public DrawingEditor()
    {
        // initialise instance variables
        canvas = new DrawingPanel();
        controls = new ControlPanel(canvas);
        
        this.height = (int)canvas.getPreferredSize().getWidth();
        this.width = (int)canvas.getPreferredSize().getHeight();
        
        this.add(canvas, BorderLayout.CENTER);
        this.add(controls, BorderLayout.SOUTH);
        
        this.setTitle("Drawing Editor");
        this.setSize(this.width, this.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * An example of a method - replace this comment with your own
     *    that describes the operation of the method
     *
     * @pre        preconditions for the method
     *            (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *            (what the method guarantees upon completion)
     * @param    y    description of parameter y
     * @return    description of the return value
     */
    public static void main(String[] args)
    {
        // put your code here
        DrawingEditor deditor = new DrawingEditor();
    }

}