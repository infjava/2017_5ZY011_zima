
/**
 * Write a description of class VelaPokusov here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VelaPokusov {
    private boolean chceZmenit;
    private int pocetVyhier;
    private int pocetPrehier;
    
    public VelaPokusov(boolean chceZmenit) {
        this.chceZmenit = chceZmenit;
    }
    
    public void vykonajVelaPokusov(int pocet) {
        for (int i = 0; i < pocet; i++) {
            Pokus pokus = new Pokus(this.chceZmenit);
            pokus.vykonajPokus();
            if (pokus.hracVyhral()) {
                this.pocetVyhier++;
            } else {
                this.pocetPrehier++;
            }
        }
    }
    
    public int getPocetVyhier() {
        return this.pocetVyhier;
    }
    
    public int getPocetPrehier() {
        return this.pocetPrehier;
    }
    
    public double getPercentoVyhier() {
        return this.pocetVyhier * 100.0 / (this.pocetVyhier + this.pocetPrehier);
    }
}
