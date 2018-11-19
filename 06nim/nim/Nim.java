
/**
 * Write a description of class Nim here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nim {
    private Sachovnica sachovnica;
    private Kamen kamen;
    
    public Nim(int sirka, int vyska) {
        this.sachovnica = new Sachovnica(sirka, vyska);
        this.kamen = this.sachovnica.pridajKamen();
        this.sachovnica.zobraz();
    }
    
    public void tahDole(int pocet) {
        if (pocet < 1) {
            return;
        }
        
        int novyRiadok = this.kamen.getAktualnyRiadok() - pocet;
        int novyStlpec = this.kamen.getAktualnyStlpec();
        
        this.kamen.posunNa(novyStlpec, novyRiadok);
    }
    
    public void tahVlavo(int pocet) {
        if (pocet < 1) {
            return;
        }
        
        int novyRiadok = this.kamen.getAktualnyRiadok();
        int novyStlpec = this.kamen.getAktualnyStlpec() - pocet;
        
        this.kamen.posunNa(novyStlpec, novyRiadok);
    }
}
