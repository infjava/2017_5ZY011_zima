
/**
 * Write a description of class Displej here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Displej {
    public static final int SIRKA = 10;
    public static final int VYSKA = 20;
    public static final int VELKOST = 14;
    
    private Stvorec[][] mriezka;
    
    private static Displej displej;

    public static Displej getDisplej() {
        if (displej == null) {
            displej = new Displej();
        }
        
        return displej;
    }
    
    /**
     * Constructor for objects of class Displej
     */
    private Displej() {        
        this.mriezka = new Stvorec[VYSKA][SIRKA];
        
        for (int y = 0; y < VYSKA ; y++) {
            for (int x = 0; x < SIRKA; x++) {
                Stvorec stvorec = new Stvorec();
                stvorec.zmenStranu(this.VELKOST);
                stvorec.posunZvisle((this.VELKOST + 1) * y - 50);
                stvorec.posunVodorovne((this.VELKOST + 1) * x - 60);
                stvorec.zmenFarbu("black");
                stvorec.zobraz();
                
                this.mriezka[y][x] = stvorec;
            }
        }
    }
    
    public void zhasni(int x, int y) {
        if (x < 0 || y < 0 || x >= SIRKA || y >= VYSKA) {
            return;
        }
        
        this.mriezka[y][x].zmenFarbu("black");
    }
    
    public void zasviet(int x, int y) {
        if (x < 0 || y < 0 || x >= SIRKA || y >= VYSKA) {
            return;
        }
        
        this.mriezka[y][x].zmenFarbu("yellow");
    }
}
