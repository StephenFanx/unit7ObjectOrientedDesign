import java.awt.Color;

public class Tile
{
   private Color color;
   private boolean up;
   
   public Tile(Color color)
   {
      up = false;
      this.color = color;
   }

   public Color getColor()
   {
      if (up)
         return color;
      else 
         return Color.BLACK;
   }

   public void setColor(Color color)
   {
      this.color = color;
   }
   
   public String getText() { return ""; } 
   
   public void flip()
   {
      up = !up;
   }
}