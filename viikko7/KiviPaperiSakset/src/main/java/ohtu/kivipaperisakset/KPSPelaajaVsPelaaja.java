package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends Peli {
    
    private KPSPelaajaVsPelaaja(Scanner scanner) {
        super(scanner);
    }
    
    public static KPSPelaajaVsPelaaja pelaaPelaajaaVastaan(Scanner scanner) {
        return new KPSPelaajaVsPelaaja(scanner);
    }

    @Override
    protected String siirto(String ekanSiirto) {
        System.out.println("Toisen pelaajan siirto: ");
        return scanner.nextLine();
    }
    
}