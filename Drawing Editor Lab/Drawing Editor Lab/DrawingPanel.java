import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;

/**
 * Write a description of class DrawingPanel here.
 * 
 * @author Stephen Fan 
 * @version 4/7
 */
public class DrawingPanel extends JPanel
{
    /** description of instance variable x (add comment for each instance variable) */
    private ArrayList<Shape> shapeList;
    private Shape activeShape;
    private Color color;
    private Dimension dimension;
    
    /**
     * Default constructor for objects of class DrawingPanel
     */
    public DrawingPanel()
    {
        //sets background color to white
        this.setBackground(Color.WHITE);
        
        //sets current color to default (black)
        this.color = Color.BLACK;
        
        //initializes preferred size
        dimension = new Dimension(800,800);
        
        // initialise instance variables
        shapeList = new ArrayList<Shape>();
        this.activeShape = null;
        this.setSize(this.dimension);
        
        //adds mouse listeners
        this.addMouseListener(new MousePressListener());
        this.addMouseMotionListener(new MouseMoveListener());
    }
    
    public void pickColor(){
        //allows the user to pick a color to draw with
        this.color = JColorChooser.showDialog(null, "Pick a color", Color.BLACK);
    }
    
    public Dimension getPreferredSize()
    {
        //returns my preferred frame size
        return this.dimension;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @return     current color
     */
    public Color getColor()
    {
        // returns the current color as a Color
        return this.color;
    }


    /**
     * An example of a method - replace this comment with your own
     *  that describes the operation of the method
     *
     * @pre     preconditions for the method
     *          (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *          (what the method guarantees upon completion)
     * @param   y   description of parameter y
     * @return  description of the return value
     */
    public void addCircle()
    {
        // adds a circle to the drawing editor
        //calculates the center point
        double xofCenter = this.getPreferredSize().getWidth()/2;
        double yofCenter = this.getPreferredSize().getHeight()/2;
        Point2D.Double center = new Point2D.Double(xofCenter, yofCenter);
        
        //gets a random radius
        double radius = Math.random()*50 + 50;
        
        //initializes a circle
        Circle circle = new Circle(center, radius, this.color);
        
        //adds it to shapeList
        this.shapeList.add(circle);
        
        //makes the new circle the active shape
        this.activeShape = circle;
        
        repaint();
    }

        /**
     * An example of a method - replace this comment with your own
     *  that describes the operation of the method
     *
     * @pre     preconditions for the method
     *          (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *          (what the method guarantees upon completion)
     * @param   y   description of parameter y
     * @return  description of the return value
     */
    public void addSquare()
    {
        // adds a square to the drawing editor
        //calculates the center point
        double xofCenter = this.getPreferredSize().getWidth()/2;
        double yofCenter = this.getPreferredSize().getHeight()/2;
        Point2D.Double center = new Point2D.Double(xofCenter, yofCenter);
        
        //gets a random radius
        double radius = Math.random()*50 + 50;
        
        //initializes a square
        Square square = new Square(center, radius, this.color);
        
        //adds the square to shapeList
        this.shapeList.add(square);
        
        //makes the square the active shape
        this.activeShape = square;
        
        repaint();
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   Graphics object
     */
    public void paintComponent(Graphics g)
    {
        // paints the picture
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        for (Shape shape : this.shapeList)
        {
            if (shape.equals(this.activeShape) == false)
            {
                //If the shape is not the active shape, draw it
                shape.draw(g2, true);
            }
        }
        
        if (this.activeShape != null)
        {
            //If there is an active shape, draw it last
            this.activeShape.draw(g2, false);
        }
    }
    
    class MousePressListener implements MouseListener
    {
        public void mousePressed(MouseEvent event)
        {
            //changes the active shape to the shape the user clicks on
            //if the user did not click on a shape, makes the active shape = null
            
            activeShape = null;
            Point2D.Double point = new Point2D.Double(event.getX(), event.getY());
            
            for (int i = 0; i < shapeList.size(); i++)
            {
                if (shapeList.get(i).isInside(point))
                {
                    activeShape = shapeList.get(i);
                }
            }
            
            repaint();
        }
        public void mouseReleased(MouseEvent event) {}
        public void mouseClicked(MouseEvent event) {}
        public void mouseEntered(MouseEvent event) {}
        public void mouseExited(MouseEvent event) {}
    }
    
    public class MouseMoveListener implements MouseMotionListener
    {
        /**
         * The method that is executed whenever the mouse is pressed and dragged
         */
        public void mouseDragged(MouseEvent event)
        {
            //allows the user to move the active shape
            if (activeShape != null)
            {
                 Point2D.Double center = activeShape.getCenter();
                 
                 double dx = event.getX() - center.getX();
                 double dy = event.getY() - center.getY();
                 
                 activeShape.move(dx, dy);
            }
            repaint();
        }
        public void mouseMoved(MouseEvent event){}
    }
}