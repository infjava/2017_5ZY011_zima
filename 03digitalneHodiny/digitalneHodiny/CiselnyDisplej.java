/**
 * Trieda reprezentujuca jeden ciselny displej v digitalnych hodinach.
 * Stara sa o zmenu hodnoty v zadanych hraniciach a o formatovanie
 * cisla do tvaru dvojcifernej hodnoty.
 */
public class CiselnyDisplej {
    private int minimalnaHodnota;
    private int maximalnaHodnota;
    private int hodnota;
    
    /**
     * Inicializuje ciselny displej na hodnotu 0. Horna hranica sa pouzije
     * ta, co zada pouzivatel v parametri.
     * @param pthis.hornaHranica Predstavuje cislo, ktore hodnota ciselneho
     * displeja nemoze dosiahnut.
     */
    public CiselnyDisplej(int minimalnaHodnota, int maximalnaHodnota, int pociatocnaHodnota) {
        this.minimalnaHodnota = minimalnaHodnota;
        this.maximalnaHodnota = maximalnaHodnota;
        this.hodnota = pociatocnaHodnota;
    }
    
    /**
     * Vrati aktualnu hodnotu ciselneho displeja vo forme celeho cisla typu
     * int.
     */
    public int getHodnota() {
        return this.hodnota;
    }
    
    public int getMaximalnaHodnota() {
        return this.maximalnaHodnota;
    }
    
    /**
     * Nastavi novu hodnotu ciselneho displeja vo forme celeho cisla typu int.
     * Kontroluje platnost zadavaneho cisla. V pripade, ze je mimo rozsah,
     * nechava povodnu hodnotu.
     * 
     * @param hodnota hodnota, ktora sa ma nastavit.
     */
    public void setHodnota(int hodnota) {
        if (hodnota >= this.minimalnaHodnota) {
            if (hodnota <= this.maximalnaHodnota) {
                this.hodnota = hodnota;
            }
        }
    }
    
    /**
     * Vrati hodnotu ciselneho displeja vo forme retazca, pricom hodnota je
     * vzdy vo forme dvojciferneho cisla s pripadnou uvodnou nulou.
     */
    public String getHodnotaAkoRetazec() {
        if (this.hodnota < 10) {
            return "0" + this.hodnota;
        } else {
            return "" + this.hodnota;
        }
    }
    
    /**
     * Zvacsi hodnotu na ciselnom displeji o hodnotu jedna. Ak dosiahne hornu
     * hranicu, pokracuje znovu od nuly.
     */
    public void krok() {
        if (this.hodnota >= this.maximalnaHodnota) {
            this.hodnota = this.minimalnaHodnota;
        } else {
            this.hodnota++;
        }
    }
}
