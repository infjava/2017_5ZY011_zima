
/**
 * Write a description of class Kamen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kamen {
    private Kruh kruh;
    private int aktualnyStlpec;
    private int aktualnyRiadok;
    
    public Kamen(Sachovnica sachovnica) {
        this.kruh = new Kruh();
        this.kruh.zmenFarbu("red");
        this.kruh.zmenPriemer(20);
        this.kruh.posunZvisle(-60);
        this.kruh.posunVodorovne((sachovnica.getSirka() - 1) * 20 - 20);
        this.aktualnyStlpec = sachovnica.getSirka();
        this.aktualnyRiadok = sachovnica.getVyska();
    }
    
    public void zobraz() {
        this.kruh.zobraz();
    }
    
    public void skry() {
        this.kruh.skry();
    }
    
    public void posunNa(int stlpec, int riadok) {
        int posunStlpec = this.aktualnyStlpec - stlpec;
        int posunRiadok = this.aktualnyRiadok - riadok;
        
        this.kruh.posunVodorovne(-20 * posunStlpec);
        this.kruh.posunZvisle(20 * posunRiadok);
        
        this.aktualnyStlpec = stlpec;
        this.aktualnyRiadok = riadok;
    }
}
