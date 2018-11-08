
/**
 * Write a description of class TypUctu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TypUctu {
    private int urokVPercentach;
    private int poplatokVCentoch;
    private String nazovTypu;
    
    public TypUctu(String nazov, int urokVPercentach, int poplatokVCentoch) {
        this.urokVPercentach = urokVPercentach;
        this.poplatokVCentoch = poplatokVCentoch;
        this.nazovTypu = nazov;
    }
    
    public int getUrokVPercentach() {
        return this.urokVPercentach;
    }
    
    public int getPoplatokVCentoch() {
        return this.poplatokVCentoch;
    }
    
    public String getNazov() {
        return this.nazovTypu;
    }
}
