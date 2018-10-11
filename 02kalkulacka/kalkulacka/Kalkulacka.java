
/**
 * Write a description of class Kalkulacka here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kalkulacka {
    private int aktualnyVysledok;
    private int pamat;
    private int pocetStlaceniMrc;
    
    /**
     * Constructor for objects of class Kalkulacka
     */
    public Kalkulacka() {
        this.aktualnyVysledok = 0;
        this.pamat = 0;
        this.pocetStlaceniMrc = 0;
    }
    
    public void scitaj(int operand) {
        //this.aktualnyVysledok = this.aktualnyVysledok + operand;
        this.aktualnyVysledok += operand;
    }
    
    public void odcitaj(int operand) {
        //this.aktualnyVysledok = this.aktualnyVysledok - operand;
        this.aktualnyVysledok -= operand;
    }
    
    public void vynasob(int operand) {
        //this.aktualnyVysledok = this.aktualnyVysledok * operand;
        this.aktualnyVysledok *= operand;
    }
    
    public void vydel(int operand) {
        //this.aktualnyVysledok = this.aktualnyVysledok / operand;
        this.aktualnyVysledok /= operand;
    }
    
    public int getVysledok() {
        return this.aktualnyVysledok;
    }
    
    public void ms() {
        this.pamat = this.aktualnyVysledok;
    }
    
    public void mr() {
        this.aktualnyVysledok = this.pamat;
    }
    
    public void mc() {
        this.pamat = 0;
    }
    
    public void mPlus() {
        this.pamat += this.aktualnyVysledok;
    }
    
    public void mrc() {
        //this.pocetStlaceniMrc = this.pocetStlaceniMrc + 1;
        //this.pocetStlaceniMrc += 1;
        this.pocetStlaceniMrc++;
        if (this.pocetStlaceniMrc == 1) {
            // pri prvom stlaceni mrc
            this.aktualnyVysledok = this.pamat;
        } else {
            // pri druhom stlaceni mrc
            this.pamat = 0;
        }
    }
}
