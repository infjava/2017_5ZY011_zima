import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Write a description of class Banka here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Banka {
    private String nazov;
    private long celkoveImanieVCentoch;
    private int kodBanky;
    private int posledneCisloUctu;
    private ArrayList<Ucet> zoznamUctov;
    private ArrayList<TypUctu> zoznamTypovUctov;
    
    /**
     * Constructor for objects of class Banka
     */
    public Banka(String nazov, int kodBanky) {
        this.nazov = nazov;
        this.celkoveImanieVCentoch = 0;
        this.kodBanky = kodBanky;
        this.posledneCisloUctu = 0;
        this.zoznamUctov = new ArrayList<Ucet>();
        this.zoznamTypovUctov = new ArrayList<TypUctu>();
    }
    
    public void pridajUcet(Ucet ucet) {
        this.zoznamUctov.add(ucet);
    }
    
    public Ucet getUcet(String cisloUctu) {
        for (Ucet ucet : this.zoznamUctov) {
            if (ucet.getCisloUctu().equals(cisloUctu)) {
                return ucet;
            }
        }
        
        return null;
    }
    
    public String getNazov() {
        return this.nazov;
    }
    
    public String pridelNoveCisloUctu() {
        this.posledneCisloUctu++;
        long noveCislo = (9883692017l * this.posledneCisloUctu) % 10000000000l;
        String cisloUctuBezKC = String.format("%04d000000%010d",
            this.kodBanky,
            noveCislo
        );
        
        String cisloUctuPripravene = cisloUctuBezKC + "282000";
        BigInteger cisloUctuVypocet = new BigInteger(cisloUctuPripravene);
        
        BigInteger kontrolneCislice = cisloUctuVypocet.remainder(new BigInteger("97"));
        return String.format("SK%02d%s", 98 - kontrolneCislice.intValue(), cisloUctuBezKC);
    }
    
    public long getCelkoveImanieBanky() {
        return this.celkoveImanieVCentoch;
    }
    
    public void zvysCelkoveImanie(long sumaVCentoch) {
        this.celkoveImanieVCentoch += sumaVCentoch;
    }
    
    public void znizCelkoveImanie(long sumaVCentoch) {
        this.celkoveImanieVCentoch -= sumaVCentoch;
    }
    
    public void zaratajUrokyAPoplatky() {
        for (Ucet ucet : this.zoznamUctov) {
            ucet.zaratajUrokyAPoplatky();
        }
    }
    
    public void pridajTypUctu(String nazov, int urokVPercentach, int poplatokVCentoch) {
        this.zoznamTypovUctov.add(new TypUctu(nazov, urokVPercentach, poplatokVCentoch));
    }
    
    public TypUctu getTypUctu(String nazov) {
        for (TypUctu typ : this.zoznamTypovUctov) {
            if (typ.getNazov().equals(nazov)) {
                return typ;
            }
        }
        
        return null;
    }
}
