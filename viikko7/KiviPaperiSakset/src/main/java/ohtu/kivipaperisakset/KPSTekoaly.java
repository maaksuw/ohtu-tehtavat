package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends Peli {

    private Tekoaly tekoaly;
    
    private KPSTekoaly(Scanner scanner) {
        super(scanner);
        tekoaly = new Tekoaly();
    }
    
    public static KPSTekoaly pelaaTekoalyaVastaan(Scanner scanner) {
        return new KPSTekoaly(scanner);
    }

    @Override
    protected String siirto(String ekanSiirto) {
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        tekoaly.asetaSiirto(ekanSiirto);
        return tokanSiirto;
    }
    
}