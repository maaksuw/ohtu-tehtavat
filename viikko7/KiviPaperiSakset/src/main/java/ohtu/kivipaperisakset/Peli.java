
package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class Peli {
    
    protected Scanner scanner;
    
    public Peli(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public static Peli pelaaPelaajaaVastaan(Scanner scanner) {
       return KPSPelaajaVsPelaaja.pelaaPelaajaaVastaan(scanner);
    }
    
    public static Peli pelaaTekoalyaVastaan(Scanner scanner) {
        return KPSTekoaly.pelaaTekoalyaVastaan(scanner);
    }
    
    public static Peli pelaaParempaaTekoalyaVastaan(Scanner scanner) {
        return KPSParempiTekoaly.pelaaParempaaTekoalyaVastaan(scanner);
    }
    
    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        String ekanSiirto = ekanSiirto();
        
        String tokanSiirto = siirto(ekanSiirto);
        
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            ekanSiirto = ekanSiirto();
            
            tokanSiirto = siirto(ekanSiirto);
        }
        
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
    private String ekanSiirto() {
        System.out.println("Ensimmäisen pelaajan siirto: ");
        return scanner.nextLine();
    }
    
    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    
    protected abstract String siirto(String ekanSiirto);
    
}
