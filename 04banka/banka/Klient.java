
/**
 * Write a description of class Klient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Klient {
    private String meno;
    private Banka banka;
    /**
     * Constructor for objects of class Klient
     */
    public Klient(String meno) {
        this.meno = meno;
        this.banka = null;
    }
    
    public void zalozUcet(Banka banka) {
        this.banka = banka;
    }
}
