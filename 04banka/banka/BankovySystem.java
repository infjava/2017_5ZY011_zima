import java.util.ArrayList;

/**
 * Write a description of class BankovySystem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BankovySystem {
    private ArrayList<Banka> zoznamBank;
    
    public BankovySystem() {
        this.zoznamBank = new ArrayList<Banka>();
    }
    
    public Banka zalozBanku(String nazov) {
        // 1. skontroluje nazov => musi byt unikatny
        for (Banka banka : this.zoznamBank) {
            if (banka.getNazov().equals(nazov)) {
                System.out.format("Banka '%s' uz existuje%n", nazov);
                return null;
            }
        }
        
        // 2. vygeneruje 4-miestny kod banky
        int kodBanky = (7211 * (this.zoznamBank.size() + 1)) % 10000;
        
        Banka nova = new Banka(nazov, kodBanky);
        this.zoznamBank.add(nova);
        return nova;
    }
}
