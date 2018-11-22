
/**
 * Write a description of class Nim here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nim {
    private Sachovnica sachovnica;
    private Kamen kamen;
    private String[] menaHracov;
    private int poradoveCisloHraca;
    
    public Nim(int sirka, int vyska, String menoPrveho, String menoDruheho) {
        this.sachovnica = new Sachovnica(sirka, vyska);
        this.kamen = this.sachovnica.pridajKamen();
        this.sachovnica.zobraz();
        this.menaHracov = new String[] { menoPrveho, menoDruheho };
        this.poradoveCisloHraca = 0;
    }
    
    public String getMenoHracaNaTahu() {
        return this.menaHracov[this.poradoveCisloHraca];
    }
    
    public void tahDole(int pocet) {
        if (pocet < 1 || pocet >= this.kamen.getAktualnyRiadok()) {
            return;
        }
        
        int novyRiadok = this.kamen.getAktualnyRiadok() - pocet;
        int novyStlpec = this.kamen.getAktualnyStlpec();
        
        this.kamen.posunNa(novyStlpec, novyRiadok);
        
        this.poradoveCisloHraca = (this.poradoveCisloHraca + 1) % this.menaHracov.length;
    }
    
    public void tahVlavo(int pocet) {
        if (pocet < 1 || pocet >= this.kamen.getAktualnyStlpec()) {
            return;
        }
        
        int novyRiadok = this.kamen.getAktualnyRiadok();
        int novyStlpec = this.kamen.getAktualnyStlpec() - pocet;
        
        this.kamen.posunNa(novyStlpec, novyRiadok);
        
        this.poradoveCisloHraca = (this.poradoveCisloHraca + 1) % this.menaHracov.length;
    }
}
