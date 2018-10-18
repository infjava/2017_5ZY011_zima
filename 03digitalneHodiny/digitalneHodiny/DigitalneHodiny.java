/**
 * Jednoduche digitalne hodiny pracujuce s virtualnym casom.
 * Pamataju si hodiny a minuty.
 */
public class DigitalneHodiny {
    private CiselnyDisplej hodiny;
    private CiselnyDisplej minuty;
    
    /**
     * Inicializuje digitalne hodiny. Cas zacina plynut od
     * polnoci (00:00).
     */
    public DigitalneHodiny() {
        this.hodiny = new CiselnyDisplej(24);
        this.minuty = new CiselnyDisplej(60);
    }
    
    /**
     * Vykonava posunutie virtualneho casu o jednu minutu.
     */
    public void tik() {
        this.minuty.krok();
        
        if (this.minuty.getHodnota() == 0) {
            this.hodiny.krok();
        }
    }
    
    /**
     * Nastavi virtualny cas na zadanu hodnotu.
     * 
     * @param hodina Hodina na ktoru sa ma cas nastavit.
     * @param minuta Minuta na ktoru sa ma cas nastavit.
     */
    public void setCas(int hodina, int minuta) {
        this.hodiny.setHodnota(hodina);
        this.minuty.setHodnota(minuta);
    }
    
    /**
     * Vrati cas vo forme retazca.
     */
    public String getCas() {
        return this.hodiny.getHodnotaAkoRetazec() + ":" + this.minuty.getHodnotaAkoRetazec();
    }
}
