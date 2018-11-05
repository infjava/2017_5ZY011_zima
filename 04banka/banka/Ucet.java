
/**
 * Write a description of class Ucet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ucet {
    private long stavUctuVCentoch;
    private Banka banka;
    private Klient klient;
    private StringBuilder vypis;
    private String cisloUctu;
    
    /**
     * Constructor for objects of class Ucet
     */
    public Ucet(Banka banka, Klient klient) {
        this.banka = banka;
        this.stavUctuVCentoch = 0;
        this.klient = klient;
        
        this.vypis = new StringBuilder();
        
        this.cisloUctu = banka.pridelNoveCisloUctu();
        banka.pridajUcet(this);
    }
    
    public String getCisloUctu() {
        return this.cisloUctu;
    }
    
    public String getNazovBanky() {
        return this.banka.getNazov();
    }
    
    public String getMenoMajitela() {
        return this.klient.getMeno();
    }
    
    public long getStavUctuVCentoch() {
        return this.stavUctuVCentoch;
    }
    
    public void vlozPeniaze(long pocetCentov) {
        if (pocetCentov > 0) {
            if (this.klient.odoberPeniazeZPenazenky(pocetCentov)) {
                this.stavUctuVCentoch += pocetCentov;
                this.banka.zvysCelkoveImanie(pocetCentov);
                String cisloSEurom = String.format("%.2f€", pocetCentov/100.0);
                this.vypis.append(String.format("Vklad %-20s zostatok %.2f€%n", cisloSEurom, this.stavUctuVCentoch/100.0));
            } else {
                System.out.println("Nemas dost penazi v penazenke");
            }
        } else {
            System.out.println("Chod volakam!");
        }
    }
    
    public void vyberPeniaze(long pocetCentov) {
        if (pocetCentov <= this.stavUctuVCentoch && pocetCentov > 0) {
            this.klient.vlozPeniazeDoPenazenky(pocetCentov);
            this.stavUctuVCentoch -= pocetCentov;
            this.banka.znizCelkoveImanie(pocetCentov);
            String cisloSEurom = String.format("%.2f€", pocetCentov/100.0);
            this.vypis.append(String.format("Vyber %-20s zostatok %.2f€%n", cisloSEurom, this.stavUctuVCentoch/100.0));
        } else {
            System.out.println("Telo penazi nemas!");
        }
    }
    
    public void zaratajUroky(int percenta) {
        long uroky = this.stavUctuVCentoch * percenta / 100;
        
        this.stavUctuVCentoch += uroky;
        this.banka.zvysCelkoveImanie(uroky);
        String cisloSEurom = String.format("%.2f€", uroky/100.0);
        this.vypis.append(String.format("Uroky %-20s zostatok %.2f€%n", cisloSEurom, this.stavUctuVCentoch/100.0));
    }
    
    public void prevedPeniaze(String cielovyIban, int pocetCentov) {
        if (pocetCentov <= this.stavUctuVCentoch && pocetCentov > 0) {
            this.stavUctuVCentoch -= pocetCentov;
            String cisloSEurom = String.format("%.2f€", pocetCentov/100.0);
            this.vypis.append(String.format("Prevod %-19s zostatok %.2f€ (Cielovy ucet: %s)%n",
                cisloSEurom, this.stavUctuVCentoch/100.0, cielovyIban));
            
            Ucet cielovyUcet = banka.getUcet(cielovyIban);
            cielovyUcet.prijmiPeniaze(this.cisloUctu, pocetCentov);
        } else {
            System.out.println("Telo penazi nemas!");
        }
    }
    
    public void prijmiPeniaze(String zdrojovyIban, int pocetCentov) {
        this.stavUctuVCentoch += pocetCentov;
        
        String cisloSEurom = String.format("%.2f€", pocetCentov/100.0);
        this.vypis.append(String.format("Prijem %-19s zostatok %.2f€ (Zdrojovy ucet: %s)%n",
            cisloSEurom, this.stavUctuVCentoch/100.0, zdrojovyIban));
    }
    
    public void vypisVypisZUctu() {
        System.out.format("Ucet majitela: %s%n", this.klient.getMeno());
        System.out.format("IBAN: %s%n", this.cisloUctu);
        System.out.print(this.vypis.toString());
        System.out.println("===============================================");
        System.out.format("Celkovy zozstatok: %.2f€%n", this.stavUctuVCentoch/100.0);
        // Ucet majitela: Frantisek Mrkvicka
        // Vklad 10,00€                       zostatok: 10,00€
        // Vyber 3,50€                        zostatok: 6,50€
        // Vklad 1000,00€                     zostatok: 1006,50€
        // =====================================================
        // Celkovy zostatok: 1006,50€
    }
}
