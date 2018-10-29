import java.math.BigInteger;

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
    
    /**
     * Constructor for objects of class Banka
     */
    public Banka(String nazov, int kodBanky) {
        this.nazov = nazov;
        this.celkoveImanieVCentoch = 0;
        this.kodBanky = kodBanky;
        this.posledneCisloUctu = 0;
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
}
