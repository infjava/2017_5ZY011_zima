
/**
 * Write a description of class Tetromino here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tetromino {
    
    private boolean[][] tvar;
    private int poziciaX;
    private int poziciaY;
    
    /**
     * Constructor for objects of class Tetromino
     */
    public Tetromino(boolean[][] tvar) {
        this.tvar = tvar;
        this.poziciaY = 0;
        
        int sirkaTetromina = this.tvar[0].length;
        this.poziciaX = Displej.SIRKA / 2 - 1 - sirkaTetromina / 2;
        
        this.zobraz();
    }
    
    public void posunVpravo(Smetisko smetisko) {
        if (this.poziciaX + this.tvar[0].length == Displej.SIRKA) {
            return;
        }
        
        this.skry();
        this.poziciaX++;
        if (smetisko.jeKolizia(this)) {
            this.poziciaX--;
        }
        this.zobraz();
    }
    
    public void posunVlavo(Smetisko smetisko) {
        if (this.poziciaX <= 0) {
            return;
        }
        
        this.skry();
        this.poziciaX--;
        if (smetisko.jeKolizia(this)) {
            this.poziciaX++;
        }
        this.zobraz();
    }
    
    public void posunDole(Smetisko smetisko) {
        if (this.poziciaY + this.tvar.length >= Displej.VYSKA) {
            return;
        }   
        
        this.skry();
        this.poziciaY++;
        if (smetisko.jeKolizia(this)) {
            this.poziciaY--;
        }
        this.zobraz();
    }  
    
    public void otoc(Smetisko smetisko) {
        int novaSirka = this.tvar.length;
        int novaVyska = this.tvar[0].length;
        
        if (this.poziciaX + novaSirka > Displej.SIRKA || this.poziciaY + novaVyska > Displej.VYSKA) {
            return;
        }
        
        boolean[][] novyTvar = new boolean[novaVyska][novaSirka];
        
        for (int stareY = 0; stareY < this.tvar.length; stareY++) {
            for (int stareX = 0; stareX < this.tvar[0].length; stareX++) {
                int noveX = novaSirka - 1 - stareY;
                int noveY = stareX;
                
                novyTvar[noveY][noveX] = this.tvar[stareY][stareX];
            }
        }
        
        boolean[][] staryTvar = this.tvar;
        
        this.skry();
        this.tvar = novyTvar;
        
        if (smetisko.jeKolizia(this)) {
            this.tvar = staryTvar;
        }
        
        this.zobraz();
    }
    
    public void padni(Smetisko smetisko) {
        this.skry();
        
        while (this.poziciaY + this.tvar.length <= Displej.VYSKA && !smetisko.jeKolizia(this)) {
            this.poziciaY++;
        }
        
        this.poziciaY--;
        
        this.zobraz();
    }
    
    private void zobraz() {
        Displej displej = Displej.getDisplej();
        
        for (int y = 0; y < this.tvar.length; y++) {
            for (int x = 0; x < this.tvar[y].length; x++) {
                if (this.tvar[y][x]) {
                    displej.zasviet(this.poziciaX + x, this.poziciaY + y);
                }
            }
        }
    }
    
    private void skry() {
        Displej displej = Displej.getDisplej();
        
        for (int y = 0; y < this.tvar.length; y++) {
            for (int x = 0; x < this.tvar[y].length; x++) {
                if (this.tvar[y][x]) {
                    displej.zhasni(this.poziciaX + x, this.poziciaY + y);
                }
            }
        }
    }
    
    public boolean jeNaDne(Smetisko smetisko) {
        if (this.poziciaY + this.tvar.length >= Displej.VYSKA) {
            return true;
        }
        
        this.poziciaY++;
        if (smetisko.jeKolizia(this)) {
            this.poziciaY--;
            return true;
        }
        
        this.poziciaY--;
        return false;
    }
    
    public boolean svietiNaPozicii(int x, int y) {
        if (x < this.poziciaX) {
            return false;
        }
        
        if (y < this.poziciaY) {
            return false;
        }
        
        if (x >= this.poziciaX + this.tvar[0].length) {
            return false;
        }
        
        if (y >= this.poziciaY + this.tvar.length) {
            return false;
        }
        
        return this.tvar[y - this.poziciaY][x - this.poziciaX];
    }
}
