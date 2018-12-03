
/**
 * Write a description of class TovarenNaTetromina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TovarenNaTetromina {
    /**
     * Constructor for objects of class TovarenNaTetromina
     */
    public TovarenNaTetromina() {
        // initialise instance variables
    }
    
    public Tetromino vytvorL() {
        return new Tetromino(
            new boolean[][] {
                {true, false},
                {true, false},
                {true, true},
            }
        );
    }
    
    public Tetromino vytvorJ() {
        return new Tetromino(
            new boolean[][] {
                {false, true},
                {false, true},
                {true, true},
            }
        );
    }
    
    public Tetromino vytvorO() {
        return new Tetromino(
            new boolean[][] {
                {true, true},
                {true, true},
            }
        );
        
    }
    
    public Tetromino vytvorZ() {
        return new Tetromino(
            new boolean[][] {
                {true, true, false},
                {false, true, true},
            }
        );
    }
    
    public Tetromino vytvorS() {
        return new Tetromino(
            new boolean[][] {
                {false, true, true},
                {true, true, false},
            }
        );
    }
    
    public Tetromino vytvorT() {
        return new Tetromino(
            new boolean[][] {
                {true, true, true},
                {false, true, false},
            }
        );
    }
    
    public Tetromino vytvorI() {
        return new Tetromino(
            new boolean[][] {
                {true},
                {true},
                {true},
                {true},
            }
        );
    }
}
