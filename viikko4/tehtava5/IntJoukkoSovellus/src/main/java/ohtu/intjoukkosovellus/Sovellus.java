package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {

    private static IntJoukko A, B, C;
    private static Scanner lukija;

    public static void main(String[] args) {
        
        lukija = new Scanner(System.in);
        
        A = new IntJoukko();
        B = new IntJoukko();
        C = new IntJoukko();

        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");
        
        while (true) {
            
            String kasky = lukija.nextLine();
            
            if (kasky.equals("li")) {
                lisaa();
            } else if (kasky.equals("p")) {
                poista();
            } else if (kasky.equals("k")) {
                kuuluu();
            } else if (kasky.equals("y")) {
                kahdenJoukonOperaatio("yhdiste");
            } else if (kasky.equals("e")) {
                kahdenJoukonOperaatio("erotus");
            } else if (kasky.equals("le")) {
                kahdenJoukonOperaatio("leikkaus");
            } else if (kasky.equals("A")) {
                System.out.println(A);
            } else if (kasky.equals("B")) {
                System.out.println(B);
            } else if (kasky.equals("C")) {
                System.out.println(C);
            } else if (kasky.equals("quit") || kasky.equals("q")) {
                System.out.println("Lopetetaan, moikka!");
                break;
            } else {
                System.out.println("Virheellinen komento! " + kasky);
                System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
            }
            System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
        }
    }
    
    private static void lisaa() {
        System.out.print("Mihin joukkoon? ");
        IntJoukko joukko = lueJoukko();
        System.out.print("Mikä luku lisätään? ");
        int luku = lukija.nextInt();
        joukko.lisaa(luku);
    }
    
    private static void poista() {
        System.out.print("Mistä joukosta? ");
        IntJoukko joukko = lueJoukko();
        System.out.print("Mikä luku poistetaan? ");
        int luku = lukija.nextInt();
        joukko.poista(luku);
    }
    
    private static void kuuluu() {
        System.out.print("Mihin joukkoon? ");
        IntJoukko joukko = lueJoukko();
        System.out.print("Mikä luku? ");
        int luku = lukija.nextInt();
        boolean kuuluuko = joukko.kuuluu(luku);
        if (kuuluuko) {
            System.out.println(luku + " kuuluu joukkoon ");
        } else {
            System.out.println(luku + " ei kuulu joukkoon ");
        }
    }
    
    private static void kahdenJoukonOperaatio(String operaatio) {
        System.out.print("1. joukko? ");
        IntJoukko ensimmainen = lueJoukko();
        System.out.print("2. joukko? ");
        IntJoukko toinen = lueJoukko();
        
        IntJoukko tulos;
        if (operaatio.equals("yhdiste")) {
            tulos = IntJoukko.yhdiste(ensimmainen, toinen);
        } else if (operaatio.equals("erotus")) {
            tulos = IntJoukko.erotus(ensimmainen, toinen);
        } else {
            tulos = IntJoukko.leikkaus(ensimmainen, toinen);
        }
        
        System.out.println("1. joukko " + operaatio + " 2. joukko = " + tulos);
    }
    
    private static IntJoukko lueJoukko() {
        String joukko = lukija.nextLine();
        while (true) {
            if (joukko.equals("A")) {
                return A;
            } else if (joukko.equals("B")) {
                return B;
            } else if (joukko.equals("C")) {
                return C;
            } else {
                System.out.println("Virheellinen joukko! " + joukko);
                System.out.print("Yritä uudelleen!");
            }
        }
    }
    
}
