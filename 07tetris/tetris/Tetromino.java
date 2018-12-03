
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
        poziciaY = 0;
        
        int sirkaTetromina = tvar[0].length;
        poziciaX = Displej.SIRKA / 2 - 1 - sirkaTetromina / 2;
        
        this.zobraz();
    }
    
    public void posunVpravo() {
        if (poziciaX + tvar[0].length == Displej.SIRKA) {
            return;
        }
        
        skry();
        poziciaX++;
        zobraz();
    }
    
    public void posunVlavo() {
        if (poziciaX <= 0) {
            return;
        }
        
        skry();
        poziciaX--;
        zobraz();
    }
    
    public void posunDole() {
        if (poziciaY + tvar.length >= Displej.VYSKA) {
            return;
        }   
        
        skry();
        poziciaY++;
        zobraz();
    }   
    
    private void zobraz()
    {
        Displej displej = Displej.getDisplej();
        
        for (int y = 0; y < tvar.length; y++) {
            for (int x = 0; x < tvar[y].length; x++) {
                if (tvar[y][x] == true) {
                    displej.zasviet(poziciaX + x, poziciaY + y);
                }
            }
        }
    }
    
    private void skry()
    {
        Displej displej = Displej.getDisplej();
        
        for (int y = 0; y < tvar.length; y++) {
            for (int x = 0; x < tvar[y].length; x++) {
                if (tvar[y][x] == true) {
                    displej.zhasni(poziciaX + x, poziciaY + y);
                }
            }
        }
    }
    
}
