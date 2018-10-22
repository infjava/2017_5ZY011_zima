
/**
 * Write a description of class Klient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Klient {
    private String meno;
    private Banka banka;
    private long stavUctuVCentoch;
    /**
     * Constructor for objects of class Klient
     */
    public Klient(String meno) {
        this.meno = meno;
        this.banka = null;
        this.stavUctuVCentoch = 0;
    }
    
    public void zalozUcet(Banka banka) {
        if (this.banka != null) {
            this.banka.znizCelkoveImanie(this.stavUctuVCentoch);
        }
        this.banka = banka;
        this.banka.zvysCelkoveImanie(this.stavUctuVCentoch);
    }
    
    public String getNazovBanky() {
        if (this.banka == null) {
            return null;
        } else {
            return this.banka.getNazov();
        }
    }
    
    public long getStavUctuVCentoch() {
        return this.stavUctuVCentoch;
    }
    
    public void vlozPeniaze(long pocetCentov) {
        if (this.banka == null) {
            System.out.println("Ved nemas ucet!");
        } else if (pocetCentov > 0) {
            this.stavUctuVCentoch += pocetCentov;
            this.banka.zvysCelkoveImanie(pocetCentov);
        } else {
            System.out.println("Chod volakam!");
        }
    }
    
    public void vyberPeniaze(long pocetCentov) {
        if (this.banka == null) {
            System.out.println("Ved nemas ucet!");
        } else if (pocetCentov <= this.stavUctuVCentoch && pocetCentov > 0) {
            this.stavUctuVCentoch -= pocetCentov;
            this.banka.znizCelkoveImanie(pocetCentov);
        } else {
            System.out.println("Telo penazi nemas!");
        }
    }
}
