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
            if (banka.getNazov().toLowerCase().equals(nazov.toLowerCase())) {
                System.out.format("Banka '%s' uz existuje%n", nazov);
                return null;
            }
        }
        
        // 2. vygeneruje 4-miestny kod banky
        int kodBanky = (7211 * (this.zoznamBank.size() + 1)) % 10000;
        
        Banka nova = new Banka(this, nazov, kodBanky);
        this.zoznamBank.add(nova);
        return nova;
    }
    
    public Ucet getUcet(String cisloUctu) {
        int hladanyKodBanky = Integer.parseInt(cisloUctu.substring(4, 8));
        
        for (Banka banka : this.zoznamBank) {
            if (banka.getKod() == hladanyKodBanky) {
                return banka.getUcet(cisloUctu);
            }
        }
        
        return null;
    }
}
