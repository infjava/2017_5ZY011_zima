
/**
 * Write a description of class Pokus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pokus {
    private Sutaz sutaz;
    private boolean chceZmenit;
    
    public Pokus(boolean chceZmenit) {
        this.sutaz = new Sutaz();
        this.chceZmenit = chceZmenit;
    }
    
    public void vykonajPokus() {
        this.sutaz.vyberNahodneDvere();
        this.sutaz.otvorNahodneDvere();
        
        if (this.chceZmenit) {
            this.sutaz.zmenVybraneDvere();
        }
    }
    
    public boolean hracVyhral() {
        return this.sutaz.hracVyhral();
    }
}
