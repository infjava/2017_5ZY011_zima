
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
    private int operand;
    private char operator;
    
    /**
     * Constructor for objects of class Kalkulacka
     */
    public Kalkulacka() {
        this.aktualnyVysledok = 0;
        this.pamat = 0;
        this.pocetStlaceniMrc = 0;
        this.operand = 0;
        this.operator = '+';
    }
    
    public void setOperand(int operand) {
        this.operand = operand;
    }
    
    public void vykonaj(char operator) {
        switch (this.operator) {
            case '+':
                this.aktualnyVysledok = this.aktualnyVysledok + this.operand;
                break;
            case '-':
                this.aktualnyVysledok = this.aktualnyVysledok - this.operand;
                break;
            case '*':
                this.aktualnyVysledok = this.aktualnyVysledok * this.operand;
                break;
            case '/':
                this.aktualnyVysledok = this.aktualnyVysledok / this.operand;
                break;
        }
        
        this.pocetStlaceniMrc = 0;
        this.operator = operator;
    }
    
    public int getVysledok() {
        return this.aktualnyVysledok;
    }
    
    public void ms() {
        this.pamat = this.aktualnyVysledok;
        this.pocetStlaceniMrc = 0;
    }
    
    public void mr() {
        this.operand = this.pamat;
        this.pocetStlaceniMrc = 0;
    }
    
    public void mc() {
        this.pamat = 0;
        this.pocetStlaceniMrc = 0;
    }
    
    public void mPlus() {
        this.pamat += this.aktualnyVysledok;
        this.pocetStlaceniMrc = 0;
    }
    
    public void mrc() {
        //this.pocetStlaceniMrc = this.pocetStlaceniMrc + 1;
        //this.pocetStlaceniMrc += 1;
        this.pocetStlaceniMrc++;
        if (this.pocetStlaceniMrc % 2 == 1) {
            // pri prvom stlaceni mrc
            this.operand = this.pamat;
        } else {
            // pri druhom stlaceni mrc
            this.pamat = 0;
        }
    }
}
