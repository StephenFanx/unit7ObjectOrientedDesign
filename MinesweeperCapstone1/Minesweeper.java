import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;
import java.util.ArrayList;

/**
 * Write a description of class NewGridWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MineSweeper extends World<Actor>
{
    /** description of instance variable x (add comment for each instance variable) */
    
    /**
     * Default constructor for objects of class NewGridWorld
     */
    public MineSweeper(Grid<Actor> grid)
    {
        // initialise instance variables
        super(grid);
        for(int row = 0; row < this.getGrid().getNumRows(); row++)
        {
            for (int col = 0; col < this.getGrid().getNumCols(); col++)
            {
                Location loc = new Location(row, col);
                this.add(loc,new NoMineTile());
            }
        }
        
        for(int i = 0; i < 21; i++)
        {
            Location loc = new Location((int)(Math.random()*this.getGrid().getNumRows()), (int)(Math.random()*this.getGrid().getNumCols()));
            this.remove(loc);
            this.add(loc, new MineTile());
        }
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
    public boolean locationClicked(Location locClicked)
    {
        // put your code here
        Grid grid = this.getGrid();
        ArrayList<Location> occupiedList = grid.getOccupiedAdjacentLocations(locClicked);
        int minecount = 0;
        boolean b = false;
        
        for(int i = 0; i < occupiedList.size(); i++)
        {
            if (grid.get(occupiedList.get(i)) instanceof MineTile == true)
            {
                minecount++;
            }
        }
        
        if (grid.get(locClicked) instanceof One || grid.get(locClicked) instanceof Two || grid.get(locClicked) instanceof Three || 
        grid.get(locClicked) instanceof Four || grid.get(locClicked) instanceof Five || grid.get(locClicked) instanceof Six || 
        grid.get(locClicked) instanceof Seven || grid.get(locClicked) instanceof Eight || grid.get(locClicked) instanceof Kaboom)
        {}
        else if(grid.get(locClicked) instanceof MineTile)
        {
            Kaboom kaboom = new Kaboom();
            grid.remove(locClicked);
            grid.put(locClicked,kaboom);
            
            for(int row = 0; row < grid.getNumRows(); row++)
            {
                for (int col = 0; col < grid.getNumCols(); col++)
                {
                    Location loc = new Location(row, col);
                    if (grid.get(loc) instanceof MineTile)
                    {
                        grid.remove(loc);
                        grid.put(loc,new Kaboom());
                    }
                }
            }
            
            b = true;
            System.out.println("You lose :(");
        }
        else if (minecount == 0)
        {
            grid.remove(locClicked);
        }
        else if (minecount == 1)
        {
            One one = new One();
            grid.remove(locClicked);
            grid.put(locClicked,one);
        }
        else if (minecount == 2)
        {
            Two two = new Two();
            grid.remove(locClicked);
            grid.put(locClicked,two);
        }
        else if (minecount == 3)
        {
            Three three = new Three();
            grid.remove(locClicked);
            grid.put(locClicked,three);
        }
        else if (minecount == 4)
        {
            Four four = new Four();
            grid.remove(locClicked);
            grid.put(locClicked,four);
        }
        else if (minecount == 5)
        {
            Five five = new Five();
            grid.remove(locClicked);
            grid.put(locClicked,five);
        }
        else if (minecount == 6)
        {
            Six six = new Six();
            grid.remove(locClicked);
            grid.put(locClicked,six);
        }
        else if (minecount == 7)
        {
            Seven seven = new Seven();
            grid.remove(locClicked);
            grid.put(locClicked,seven);
        }
        else if (minecount == 8)
        {
            Eight eight = new Eight();
            grid.remove(locClicked);
            grid.put(locClicked,eight);
        }
        
        int winner = 0;
        for (int row = 0; row < grid.getNumRows(); row++)
        {
            for (int col = 0; col < grid.getNumCols(); col++)
            {
                Location loc = new Location (row, col);
                if (grid.get(loc) instanceof NoMineTile)
                {
                    winner++;
                }
            }
        }
        
        if (winner > 0)
        {
            System.out.println("You win! :)");
        }
        return b;
    }

     /**
     * Creates an instance of this class. Provides convenient execution.
     *
     */
    public static void main(String[] args)
    {
        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(15,15);
        
        MineSweeper minesweeper = new MineSweeper(grid);
        minesweeper.show();
    }
}