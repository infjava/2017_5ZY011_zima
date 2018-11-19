import java.util.ArrayList;

public class Sachovnica {
    private ArrayList<Stvorec> policka;
    private ArrayList<Kamen> kamene;
    private int sirka;
    
    public Sachovnica(int sirka, int vyska) {
        this.policka = new ArrayList<Stvorec>();
        this.kamene = new ArrayList<Kamen>();
        this.sirka = sirka;
        
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
        for (Kamen kamen : this.kamene) {
            kamen.zobraz();
        }
    }
    
    public void skry() {
        for (Stvorec policko : this.policka) {
            policko.skry();
        }
        for (Kamen kamen : this.kamene) {
            kamen.skry();
        }
    }
    
    public Kamen pridajKamen() {
        Kamen novyKamen = new Kamen(this);
        this.kamene.add(novyKamen);
        return novyKamen;
    }
    
    public int getSirka() {
        return this.sirka;
    }
}
