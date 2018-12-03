
/**
 * Write a description of class HraTetris here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HraTetris {
    
    private Tetromino tetromino;
    private int pocetTikov;
    
    /**
     * Constructor for objects of class HraTetris
     */
    public HraTetris() {
        this.tetromino = new Tetromino(new boolean[][] { {false, true, false},
                                                         {true, true, true} });
                                                         
        Manazer manazer = new Manazer();
        manazer.spravujObjekt(this);
        
        this.pocetTikov = 0;
    }
  
    public void posunHore() {
        this.tetromino.otoc();
    }
    
    public void posunVlavo() {
        this.tetromino.posunVlavo();
    }
    
    public void posunVpravo() {
        this.tetromino.posunVpravo();
    }
    
    public void tik() {
        if (this.pocetTikov % 4 == 0) {
            this.tetromino.posunDole();
        }
        this.pocetTikov++;
    }
    
    public void aktivuj() {
        
    }
    
    public void zrus() {
        System.exit(0);
    }
}
