
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5,
                            OLETUSKASVATUS = 5;
    private int kasvatuskoko;
    private int[] joukko; 
    private int alkioita; 

    public IntJoukko() {
        joukko = new int[KAPASITEETTI];
        alkioita = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) return;
        joukko = new int[kapasiteetti];
        alkioita = 0;
        this.kasvatuskoko = OLETUSKASVATUS;

    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0)  return;
        if (kasvatuskoko < 0) return;
        joukko = new int[kapasiteetti];
        alkioita = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            joukko[alkioita] = luku;
            alkioita++;
            if (alkioita == joukko.length) kasvataJoukkoa();
            return true;
        }
        return false;
    }
    
    public boolean poista(int luku) {
        int indeksi = -1;
        for (int i = 0; i < alkioita; i++) {
            if (joukko[i] == luku) {
                indeksi = i;
                break;
            }
        }
        if (indeksi == -1) return false;
        for (int j = indeksi; j < alkioita - 1; j++) {
            joukko[j] = joukko[j + 1];
        }
        alkioita--;
        joukko[alkioita] = 0;
        return true;
    }
    
    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioita; i++) {
            if (luku == joukko[i]) return true;
        }
        return false;
    }
    
    public static IntJoukko yhdiste(IntJoukko ensimmainen, IntJoukko toinen) {
        IntJoukko yhdiste = new IntJoukko();
        int[] ensimmaisenAlkiot = ensimmainen.toIntArray();
        int[] toisenAlkiot = toinen.toIntArray();
        for (int alkio : ensimmaisenAlkiot) {
            yhdiste.lisaa(alkio);
        }
        for (int alkio : toisenAlkiot) {
            yhdiste.lisaa(alkio);
        }
        return yhdiste;
    }
    
    public static IntJoukko erotus (IntJoukko ensimmainen, IntJoukko toinen) {
        IntJoukko erotus = new IntJoukko();
        int[] ensimmaisenAlkiot = ensimmainen.toIntArray();
        for (int alkio : ensimmaisenAlkiot) {
            if(!toinen.kuuluu(alkio))erotus.lisaa(alkio);
        }
        return erotus;
    }
    
    public static IntJoukko leikkaus(IntJoukko ensimmainen, IntJoukko toinen) {
        IntJoukko leikkaus = new IntJoukko();
        int[] ensimmaisenAlkiot = ensimmainen.toIntArray();
        for (int alkio : ensimmaisenAlkiot) {
            if(toinen.kuuluu(alkio)) leikkaus.lisaa(alkio);
        }
        return leikkaus;
    }
    
    private void kasvataJoukkoa() {
        int uusiKoko = joukko.length + kasvatuskoko;
        int[] uusiJoukko = new int[uusiKoko];
        kopioiTaulukko(joukko, uusiJoukko);
        joukko = uusiJoukko;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    public int mahtavuus() {
        return alkioita;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioita];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = joukko[i];
        }
        return taulu;
    }
    
    @Override
    public String toString() {
        String merkkijono = "{";
        for (int i = 0; i < alkioita; i++) {
            merkkijono += joukko[i];
            if(i != alkioita - 1) merkkijono += ", ";
        }
        merkkijono += "}";
        return merkkijono;
    }
        
}
