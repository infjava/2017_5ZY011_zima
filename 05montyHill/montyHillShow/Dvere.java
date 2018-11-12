
/**
 * Write a description of class Dvere here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dvere {
    private boolean suVyherne;
    private boolean suOtvorene;
    private boolean suVybrane;
    
    public Dvere(boolean suVyherne) {
        this.suVyherne = suVyherne;
        this.suOtvorene = false;
        this.suVybrane = false;
    }
    
    public boolean jeVyhra() {
        return this.suVybrane && this.suVyherne;
        /*if (this.suVybrane && this.suVyherne) {
            return true;
        } else {
            return false;
        }*/
    }
    
    public boolean dajuSaOtvorit() {
        return !this.suVyherne && !this.suVybrane && !this.suOtvorene;
    }
    
    public void otvor() {
        if (!this.suVyherne && !this.suVybrane && !this.suOtvorene) {
            this.suOtvorene = true;
        }
    }
    
    public boolean dajuSaVybrat() {
        return !this.suOtvorene;
    }
    
    public void vyber() {
        if (!this.suOtvorene) {
            this.suVybrane = true;
        }
    }
    
    public void zrusVyber() {
        this.suVybrane = false;
    }
}
