
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
        if (Displej.displej == null) {
            Displej.displej = new Displej();
        }
        
        return Displej.displej;
    }
    
    /**
     * Constructor for objects of class Displej
     */
    private Displej() {        
        this.mriezka = new Stvorec[Displej.VYSKA][Displej.SIRKA];
        
        for (int y = 0; y < Displej.VYSKA ; y++) {
            for (int x = 0; x < Displej.SIRKA; x++) {
                Stvorec stvorec = new Stvorec();
                stvorec.zmenStranu(Displej.VELKOST);
                stvorec.posunZvisle((Displej.VELKOST + 1) * y - 50);
                stvorec.posunVodorovne((Displej.VELKOST + 1) * x - 60);
                stvorec.zmenFarbu("black");
                stvorec.zobraz();
                
                this.mriezka[y][x] = stvorec;
            }
        }
    }
    
    public void zhasni(int x, int y) {
        if (x < 0 || y < 0 || x >= Displej.SIRKA || y >= Displej.VYSKA) {
            return;
        }
        
        this.mriezka[y][x].zmenFarbu("black");
    }
    
    public void zasviet(int x, int y) {
        if (x < 0 || y < 0 || x >= Displej.SIRKA || y >= Displej.VYSKA) {
            return;
        }
        
        this.mriezka[y][x].zmenFarbu("yellow");
    }
}
