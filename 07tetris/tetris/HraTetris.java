
/**
 * Write a description of class HraTetris here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HraTetris {
    
    private Tetromino tetromino;
    
    /**
     * Constructor for objects of class HraTetris
     */
    public HraTetris() {
        this.tetromino = new Tetromino(new boolean[][] { {false, true, false},
                                                         {true, true, true} });
                                                         
        Manazer manazer = new Manazer();
        manazer.spravujObjekt(this);
    }
  
    public void posunHore() {
        // TODO: Otocenie tetromina
    }
    
    public void posunVlavo() {
        this.tetromino.posunVlavo();
    }
    
    public void posunVpravo() {
        this.tetromino.posunVpravo();
    }
    
    public void tik() {
        this.tetromino.posunDole();
    }
    
    public void aktivuj() {
        
    }
    
    public void zrus() {
        System.exit(0);
    }
}
