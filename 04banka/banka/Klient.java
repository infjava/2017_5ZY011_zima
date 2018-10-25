
/**
 * Write a description of class Klient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Klient {
    private String meno;
    
    /**
     * Constructor for objects of class Klient
     */
    public Klient(String meno) {
        this.meno = meno;
    }
    
    public Ucet zalozUcet(Banka banka) {
        return new Ucet(banka, this);
    }
    
    public String getMeno() {
        return this.meno;
    }
}
