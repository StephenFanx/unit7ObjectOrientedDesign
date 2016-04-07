import javax.swing.JFrame;
import java.awt.BorderLayout;

/**
 * Write a description of class DrawingEditor here.
 * 
 * @author Stephen Fan
 * @version 4/7
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
        
        //adds everything
        this.add(canvas, BorderLayout.CENTER);
        this.add(controls, BorderLayout.SOUTH);
        
        //sets frame characteristics
        this.setTitle("Drawing Editor");
        this.setSize(this.width, this.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * main method in order to run the program
     */
    public static void main(String[] args)
    {
        // main method
        DrawingEditor deditor = new DrawingEditor();
    }

}