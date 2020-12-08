package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSParempiTekoaly extends Peli {
    
    private TekoalyParannettu tekoaly;
    
    private KPSParempiTekoaly(Scanner scanner) {
        super(scanner);
        tekoaly = new TekoalyParannettu(20);
    }
    
    public static KPSParempiTekoaly pelaaParempaaTekoalyaVastaan(Scanner scanner) {
        return new KPSParempiTekoaly(scanner);
    }

    @Override
    protected String siirto(String ekanSiirto) {
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        tekoaly.asetaSiirto(ekanSiirto);
        return tokanSiirto;
    }

}
