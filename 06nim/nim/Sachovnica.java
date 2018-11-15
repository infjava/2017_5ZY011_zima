import java.util.ArrayList;

public class Sachovnica {
    private ArrayList<Stvorec> policka;
    
    public Sachovnica(int sirka, int vyska) {
        this.policka = new ArrayList<Stvorec>();
        
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
                maBytCierna = !maBytCierna;
                this.policka.add(policko);
            }
            if (sirka % 2 == 0) {
                maBytCierna = !maBytCierna;
            }
        }
    }
    
    public void zobraz() {
        for (Stvorec policko : this.policka) {
            policko.zobraz();
        }
    }
    
    public void skry() {
        for (Stvorec policko : this.policka) {
            policko.skry();
        }
    }
}
