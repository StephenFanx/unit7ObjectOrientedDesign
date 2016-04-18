import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

/**
 * Game of Life starter code. Demonstrates how to create and populate the game using the GridWorld framework.
 * Also demonstrates how to provide accessor methods to make the class testable by unit tests.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class Minesweeper
{
    // the world comprised of the grid that displays the graphics for the game
    private ActorWorld world;
    
    // the game board will have 5 rows and 5 columns
    private final int ROWS = 20;
    private final int COLS = 20;
    
    /**
     * Default constructor for objects of class Minesweeper
     * 
     * @post    the game will be initialized with a screen of blank tiles
     * 
     */
    public Minesweeper()
    {
        // create the grid, of the specified size, that contains Actors
        BoundedGrid<Actor> grid1 = new BoundedGrid<Actor>(ROWS, COLS);
        BoundedGrid<Actor> grid2 = new BoundedGrid<Actor>(ROWS, COLS);
        
        // create a world based on the grid
        world = new ActorWorld(grid1);
        
        // populate the game
        populateGame();
        
        // display the newly constructed and populated world
        world.show();
        
    }
    
    /**
     * Creates the actors and inserts them into their initial starting positions in the grid
     *
     * @pre     the grid has been created
     * @post    all actors that comprise the initial state of the game have been added to the grid
     * 
     */
    private void populateGame()
    {
        // random locations of mines
        final int column1 = (int)((Math.random()*COLS) + 1), row1 = (int)((Math.random()*ROWS) + 1);
        final int column2 = (int)((Math.random()*COLS) + 1), row2 = (int)((Math.random()*ROWS) + 1);
        final int column3 = (int)((Math.random()*COLS) + 1), row3 = (int)((Math.random()*ROWS) + 1);
        final int column4 = (int)((Math.random()*COLS) + 1), row4 = (int)((Math.random()*ROWS) + 1);
        final int column5 = (int)((Math.random()*COLS) + 1), row5 = (int)((Math.random()*ROWS) + 1);
        final int column6 = (int)((Math.random()*COLS) + 1), row6 = (int)((Math.random()*ROWS) + 1);
        final int column7 = (int)((Math.random()*COLS) + 1), row7 = (int)((Math.random()*ROWS) + 1);
        final int column8 = (int)((Math.random()*COLS) + 1), row8 = (int)((Math.random()*ROWS) + 1);
        final int column9 = (int)((Math.random()*COLS) + 1), row9 = (int)((Math.random()*ROWS) + 1);
        final int column10 = (int)((Math.random()*COLS) + 1), row10 = (int)((Math.random()*ROWS) + 1);
        final int column11 = (int)((Math.random()*COLS) + 1), row11 = (int)((Math.random()*ROWS) + 1);
        final int column12 = (int)((Math.random()*COLS) + 1), row12 = (int)((Math.random()*ROWS) + 1);
        final int column13 = (int)((Math.random()*COLS) + 1), row13 = (int)((Math.random()*ROWS) + 1);
        final int column14 = (int)((Math.random()*COLS) + 1), row14 = (int)((Math.random()*ROWS) + 1);
        final int column15 = (int)((Math.random()*COLS) + 1), row15 = (int)((Math.random()*ROWS) + 1);
        final int column16 = (int)((Math.random()*COLS) + 1), row16 = (int)((Math.random()*ROWS) + 1);
        final int column17 = (int)((Math.random()*COLS) + 1), row17 = (int)((Math.random()*ROWS) + 1);

        // the grid of Actors that maintains the state of the game
        //  (alive cells contains actors; dead cells do not)
        Grid<Actor> grid1 = world.getGrid();
        Grid<Actor> grid2 = world.getGrid();
    }

    /**
     * Generates the next generation based on the rules of the Game of Life and updates the grid
     * associated with the world
     *
     * @pre     the game has been initialized
     * @post    the world has been populated with a new grid containing the next generation
     * 
     */
    public void checkTile()
    {
        // create the grid, of the specified size, that contains Actors
        Grid<Actor> grid1 = world.getGrid();
        Grid<Actor> grid2 = world.getGrid();
        
        
    }
    
    /**
     * Returns the actor at the specified row and column. Intended to be used for unit testing.
     *
     * @param   row the row (zero-based index) of the actor to return
     * @param   col the column (zero-based index) of the actor to return
     * @pre     the grid has been created
     * @return  the actor at the specified row and column
     */
    public Actor getActor(int row, int col)
    {
        Location loc = new Location(row, col);
        Actor actor = world.getGrid().get(loc);
        return actor;
    }

    /**
     * Returns the number of rows in the game board
     *
     * @return    the number of rows in the game board
     */
    public int getNumRows()
    {
        return ROWS;
    }
    
    /**
     * Returns the number of columns in the game board
     *
     * @return    the number of columns in the game board
     */
    public int getNumCols()
    {
        return COLS;
    }
    
    
    /**
     * Creates an instance of this class. Provides convenient execution.
     *
     */
    public static void main(String[] args)
    {
        Minesweeper game = new Minesweeper();
    }

}