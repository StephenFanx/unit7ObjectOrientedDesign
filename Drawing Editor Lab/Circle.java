import java.awt.geom.*;
import java.awt.*;

/**
 * Write a description of class Circle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Circle extends Shape
{
    // instance variables - replace the example below with your own
    public Circle(Point2D.Double center, double radius, Color color)
    {
        super(center, radius, color);
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public boolean isInside(Point2D.Double point)
    {   
        //The coordinates of the point passed in as a parameter
        Ellipse2D.Double circle = new Ellipse2D.Double(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(), 2*this.getRadius(), 2*this.getRadius());
        return circle.contains(point);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void draw(Graphics2D g2, boolean filled)
    {
        //Calculates the coordinates of the top left corner
        //of the rectangular frame that contains the circle
        double xTopLeft = this.getCenter().getX() - this.getRadius();
        double yTopLeft = this.getCenter().getY() - this.getRadius();
        
        //Calculates the diameter of the circle
        double diameter = this.getRadius() * 2;
        
        //Initializes the circle to a new ellipse
        Ellipse2D.Double circle = new Ellipse2D.Double(xTopLeft, yTopLeft, diameter, diameter);
        
        //Sets the color
        g2.setColor(this.getColor());
        
        //Draws the circle
        g2.draw(circle);
        if (filled == true)
        {
            //If the circle should be filled, fill it
            g2.fill(circle);
        }
        
    }

}