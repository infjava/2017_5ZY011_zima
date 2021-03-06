
/**
 * Write a description of class Klient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Klient {
    private String meno;
    private long stavPenazenkyVCentoch;
    
    /**
     * Constructor for objects of class Klient
     */
    public Klient(String meno) {
        this.meno = meno;
        this.stavPenazenkyVCentoch = 10000;
    }
    
    public Ucet zalozUcet(Banka banka, String typUctu) {
        TypUctu typUctuVBanke = banka.getTypUctu(typUctu);
        
        if (typUctuVBanke == null) {
            System.out.format("Neznamy typ uctu '%s'%n", typUctu);
            return null;
        } else {
            return new Ucet(banka, this, typUctuVBanke);
        }
    }
    
    public String getMeno() {
        return this.meno;
    }
    
    public boolean odoberPeniazeZPenazenky(long pocetCentov) {
        if (this.stavPenazenkyVCentoch >= pocetCentov) {
            this.stavPenazenkyVCentoch -= pocetCentov;
            return true;
        } else {
            return false;
        }
    }
    
    public void vlozPeniazeDoPenazenky(long pocetCentov) {
        this.stavPenazenkyVCentoch += pocetCentov;
    }
}
