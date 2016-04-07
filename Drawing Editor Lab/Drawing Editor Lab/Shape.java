import java.awt.geom.Point2D;
import java.awt.*;

/**
 * Abstract class Shape - write a description of the class here
 * 
 * @author Stephen Fan
 * @version 4/7
 */
public abstract class Shape
{
    // instance variables - replace the example below with your own
    private Point2D.Double center;
    private double radius;
    private Color color;
    
    public Shape(Point2D.Double center, double radius, Color color)
    {
        //instance variables
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the center point as a Point2D.Double
     */
    public Point2D.Double getCenter()
    {
        // returns center
        return this.center;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the radius as a double
     */
    public double getRadius()
    {
        // put your code here
        return this.radius;
    }
    
       /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the current color as a Color
     */
    public Color getColor()
    {
        return this.color;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   the number of spaces moved
     */
    public void move(double x, double y)
    {
        // moves the shape a number of spaces
        this.center.setLocation((this.center.getX() + x), (this.center.getY() + y));
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   the intended radius
     */
    public void setRadius(double r)
    {
        // sets the radius to the intended radius
        this.radius = r;
    }
    public abstract boolean isInside(Point2D.Double point);
    public abstract void draw(Graphics2D g2, boolean filled);

}
