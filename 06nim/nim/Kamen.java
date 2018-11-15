
/**
 * Write a description of class Kamen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kamen {
    /**
     * Constructor for objects of class Kamen
     */
    public Kamen(Sachovnica sachovnica) {
        Kruh kruh = new Kruh();
        kruh.zmenFarbu("red");
        kruh.zmenPriemer(20);
        kruh.posunZvisle(-60);
        kruh.posunVodorovne((sachovnica.getSirka() - 1) * 20 - 20);
        kruh.zobraz();
    }
}
