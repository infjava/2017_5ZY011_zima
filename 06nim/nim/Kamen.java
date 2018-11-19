
/**
 * Write a description of class Kamen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kamen {
    private Kruh kruh;
    
    public Kamen(Sachovnica sachovnica) {
        this.kruh = new Kruh();
        this.kruh.zmenFarbu("red");
        this.kruh.zmenPriemer(20);
        this.kruh.posunZvisle(-60);
        this.kruh.posunVodorovne((sachovnica.getSirka() - 1) * 20 - 20);
    }
    
    public void zobraz() {
        this.kruh.zobraz();
    }
    
    public void skry() {
        this.kruh.skry();
    }
}
