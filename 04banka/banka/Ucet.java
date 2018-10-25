
/**
 * Write a description of class Ucet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ucet {
    private long stavUctuVCentoch;
    private Banka banka;
    private Klient klient;
    
    /**
     * Constructor for objects of class Ucet
     */
    public Ucet(Banka banka, Klient klient) {
        this.banka = banka;
        this.stavUctuVCentoch = 0;
        this.klient = klient;
    }
    
    public String getNazovBanky() {
        return this.banka.getNazov();
    }
    
    public String getMenoMajitela() {
        return this.klient.getMeno();
    }
    
    public long getStavUctuVCentoch() {
        return this.stavUctuVCentoch;
    }
    
    public void vlozPeniaze(long pocetCentov) {
        if (pocetCentov > 0) {
            this.stavUctuVCentoch += pocetCentov;
            this.banka.zvysCelkoveImanie(pocetCentov);
        } else {
            System.out.println("Chod volakam!");
        }
    }
    
    public void vyberPeniaze(long pocetCentov) {
        if (pocetCentov <= this.stavUctuVCentoch && pocetCentov > 0) {
            this.stavUctuVCentoch -= pocetCentov;
            this.banka.znizCelkoveImanie(pocetCentov);
        } else {
            System.out.println("Telo penazi nemas!");
        }
    }
}
