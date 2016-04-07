import java.awt.geom.*;
import java.awt.*;

/**
 * Write a description of class Square here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Square extends Shape
{
    // instance variables - replace the example below with your own
    public Square(Point2D.Double center, double radius, Color color)
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
        // put your code here
        Rectangle2D.Double square = new Rectangle2D.Double(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(), 2*this.getRadius(), 2*this.getRadius());
        return square.contains(point);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void draw(Graphics2D g2, boolean filled)
    {
        //Calculates the coordinates of the top left corner of the square
        double xofTopLeft = this.getCenter().getX() - this.getRadius();
        double yofTopLeft = this.getCenter().getY() - this.getRadius();
        
        //Calculates the "diameter" of the square, or its length
        double diameter = this.getRadius() * 2;
        
        //Initializes the square to a new rectangle
        Rectangle2D.Double square = new Rectangle2D.Double(xofTopLeft, yofTopLeft, diameter, diameter);
        
        //Sets the color
        g2.setColor(this.getColor());
        if (filled)
        {
            //If the square should be filled, fill it
            g2.fill(square);
        }
        
        //Draws the square
        g2.draw(square);
        
    }
}
