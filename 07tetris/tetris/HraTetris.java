
/**
 * Write a description of class HraTetris here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HraTetris {
    private Smetisko smetisko;
    private TovarenNaTetromina tovaren;
    private Tetromino tetromino;
    private int pocetTikov;
    
    /**
     * Constructor for objects of class HraTetris
     */
    public HraTetris() {
        this.smetisko = new Smetisko();
        this.tovaren = new TovarenNaTetromina(this.smetisko);
        
        this.tetromino = this.tovaren.vytvorNahodne();
                                                         
        Manazer manazer = new Manazer();
        manazer.spravujObjekt(this);
        
        this.pocetTikov = 0;
    }
  
    public void posunHore() {
        this.tetromino.otoc(this.smetisko);
    }
    
    public void posunVlavo() {
        this.tetromino.posunVlavo(this.smetisko);
    }
    
    public void posunVpravo() {
        this.tetromino.posunVpravo(this.smetisko);
    }
    
    public void posunDole() {
        this.tetromino.padni(this.smetisko);
    }
    
    public void tik() {
        if (this.pocetTikov % 4 == 0) {
            this.tetromino.posunDole(this.smetisko);
            
            if (this.tetromino.jeNaDne(this.smetisko)) {
                this.smetisko.pridajNaSmetisko(this.tetromino);
                this.tetromino = this.tovaren.vytvorNahodne();
            }
        }
        this.pocetTikov++;
    }
    
    public void aktivuj() {
        
    }
    
    public void zrus() {
        System.exit(0);
    }
}
