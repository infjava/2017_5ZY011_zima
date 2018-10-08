
/**
 * Write a description of class Kalkulacka here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kalkulacka {
    private int aktualnyVysledok;
    
    /**
     * Constructor for objects of class Kalkulacka
     */
    public Kalkulacka() {
        this.aktualnyVysledok = 0;
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
}
