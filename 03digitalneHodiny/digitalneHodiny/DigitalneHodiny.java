/**
 * Jednoduche digitalne hodiny pracujuce s virtualnym casom.
 * Pamataju si hodiny a minuty.
 */
public class DigitalneHodiny {
    private CiselnyDisplej hodiny;
    private CiselnyDisplej minuty;
    private CiselnyDisplej sekundy;
    
    /**
     * Inicializuje digitalne hodiny. Cas zacina plynut od
     * polnoci (00:00).
     */
    public DigitalneHodiny() {
        this.hodiny = new CiselnyDisplej(0, 23, 0);
        this.minuty = new CiselnyDisplej(0, 59, 0);
        this.sekundy = new CiselnyDisplej(0, 59, 0);
    }
    
    public void prepni12Alebo24() {
        if (this.hodiny.getMaximalnaHodnota() == 23) {
            int noveHodiny = this.hodiny.getHodnota() % 12;
            if (noveHodiny == 0) {
                noveHodiny = 12;
            }
            this.hodiny = new CiselnyDisplej(1, 12, noveHodiny);
        } else {
            this.hodiny = new CiselnyDisplej(0, 23, this.hodiny.getHodnota());
        }
    }
    
    /**
     * Vykonava posunutie virtualneho casu o jednu minutu.
     */
    public void tik() {
        this.sekundy.krok();
        
        if (this.sekundy.getHodnota() == 0) {
            this.minuty.krok();
            
            if (this.minuty.getHodnota() == 0) {
                this.hodiny.krok();
            }
        }
    }
    
    /**
     * Nastavi virtualny cas na zadanu hodnotu.
     * 
     * @param hodina Hodina na ktoru sa ma cas nastavit.
     * @param minuta Minuta na ktoru sa ma cas nastavit.
     */
    public void setCas(int hodina, int minuta, int sekunda) {
        this.hodiny.setHodnota(hodina);
        this.minuty.setHodnota(minuta);
        this.sekundy.setHodnota(sekunda);
    }
    
    /**
     * Vrati cas vo forme retazca.
     */
    public String getCas() {
        return this.hodiny.getHodnotaAkoRetazec()
            + ":" + this.minuty.getHodnotaAkoRetazec()
            + ":" + this.sekundy.getHodnotaAkoRetazec();
    }
}
