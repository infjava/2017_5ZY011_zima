import java.util.Random;

/**
 * Write a description of class TovarenNaTetromina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TovarenNaTetromina {
    private Random random;
    private Smetisko smetisko;
    
    /**
     * Constructor for objects of class TovarenNaTetromina
     */
    public TovarenNaTetromina(Smetisko smetisko) {
        this.random = new Random();
        this.smetisko = smetisko;
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
    
    public Tetromino vytvorNahodne() {
        Tetromino vytvorene;
        
        switch (this.random.nextInt(7)) {
            case 0:
                vytvorene = this.vytvorL();
                break;
            case 1:
                vytvorene = this.vytvorJ();
                break;
            case 2:
                vytvorene = this.vytvorO();
                break;
            case 3:
                vytvorene = this.vytvorZ();
                break;
            case 4:
                vytvorene = this.vytvorS();
                break;
            case 5:
                vytvorene = this.vytvorT();
                break;
            case 6:
                vytvorene = this.vytvorI();
                break;
            default:
                return null;
        }
        
        int pocetOtoceni = this.random.nextInt(4);
        for (int i = 0; i < pocetOtoceni; i++) {
            vytvorene.otoc(this.smetisko);
        }
        
        return vytvorene;
    }
}
