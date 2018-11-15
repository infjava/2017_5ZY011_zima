
/**
 * Write a description of class Sachovnica here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sachovnica {
    /**
     * Constructor for objects of class Sachovnica
     */
    public Sachovnica(int sirka, int vyska) {
        boolean maBytCierna = true;
        for (int y = vyska - 1; y >= 0; y--) {
            for (int x = 0; x < sirka; x++) {
                Stvorec policko = new Stvorec();
                policko.zmenStranu(20);
                policko.posunZvisle(20 * y - 50);
                policko.posunVodorovne(20 * x - 60);
                if (maBytCierna) {
                    policko.zmenFarbu("black");
                } else {
                    policko.zmenFarbu("white");
                }
                policko.zobraz();
                maBytCierna = !maBytCierna;
            }
            if (sirka % 2 == 0) {
                maBytCierna = !maBytCierna;
            }
        }
    }
}
