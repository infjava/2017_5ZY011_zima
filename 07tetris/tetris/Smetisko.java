
/**
 * Write a description of class Smetisko here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Smetisko {
    private boolean[][] obsadenePolicka;
    
    public Smetisko() {
        this.obsadenePolicka = new boolean[Displej.VYSKA][Displej.SIRKA];
    }
    
    public void pridajNaSmetisko(Tetromino tetromino) {
        for (int y = 0; y < this.obsadenePolicka.length; y++) {
            for (int x = 0; x < this.obsadenePolicka[y].length; x++) {
                if (tetromino.svietiNaPozicii(x, y)) {
                    this.obsadenePolicka[y][x] = true;
                }
            }
        }
    }
    
    public boolean jeKolizia(Tetromino tetromino) {
        for (int y = 0; y < this.obsadenePolicka.length; y++) {
            for (int x = 0; x < this.obsadenePolicka[y].length; x++) {
                if (tetromino.svietiNaPozicii(x, y) && this.obsadenePolicka[y][x]) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
