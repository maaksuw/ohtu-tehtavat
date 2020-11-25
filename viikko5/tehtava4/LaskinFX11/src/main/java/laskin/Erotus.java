
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Komento {
    
    private int edellinenVahennys;

    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        edellinenVahennys = arvo;
        sovellus.miinus(arvo);
        paivitaKentat();
        tarkistaNollaus();
        undo.disableProperty().set(false);
    }

    @Override
    public void peru() {
        sovellus.plus(edellinenVahennys);
        paivitaKentat();
        tarkistaNollaus();
        undo.disableProperty().set(true);
    }
    
    private void tarkistaNollaus() {
        if (sovellus.tulos() == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
    }
    
    private void paivitaKentat() {
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }
    
}
