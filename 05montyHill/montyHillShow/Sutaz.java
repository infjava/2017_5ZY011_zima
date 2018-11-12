import java.util.Random;

/**
 * Write a description of class Sutaz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sutaz {
    private Dvere[] dvere;
    private Random nahodneCisla;
    
    public Sutaz() {
        this.nahodneCisla = new Random();
        
        this.dvere = new Dvere[3];
        
        int vyherneDvere = this.nahodneCisla.nextInt(3);
        
        for (int i = 0; i < 3; i++) {
            /*if (i == vyherneDvere) {
                this.dvere[i] = new Dvere(true);
            } else {
                this.dvere[i] = new Dvere(false);
            }*/
            this.dvere[i] = new Dvere(i == vyherneDvere);
        }
    }
    
    public void otvorNahodneDvere() {
        int otvaraneDvere;
        
        do {
            otvaraneDvere = this.nahodneCisla.nextInt(3);
        } while (!this.dvere[otvaraneDvere].dajuSaOtvorit());
        
        this.dvere[otvaraneDvere].otvor();
    }
    
    public void vyberNahodneDvere() {
        int vyberaneDvere = this.nahodneCisla.nextInt(3);
        this.dvere[vyberaneDvere].vyber();
    }
    
    public void zmenVybraneDvere() {
        for (Dvere aktualne : this.dvere) {
            if (aktualne.getSuVybrane()) {
                aktualne.zrusVyber();
            } else if (aktualne.dajuSaVybrat()) {
                aktualne.vyber();
            }
        }
    }
    
    public boolean hracVyral() {
        for (Dvere aktualne : this.dvere) {
            if (aktualne.jeVyhra()) {
                return true;
            }
        }
        
        return false;
    }
}
