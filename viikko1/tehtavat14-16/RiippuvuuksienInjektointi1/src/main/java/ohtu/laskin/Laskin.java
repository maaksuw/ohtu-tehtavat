package ohtu.laskin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laskin {
    
    @Autowired
    private IO io;
    
    public void suorita(){
        while( true ) {
            io.print("luku 1: ");
            int luku1 = io.nextInt();
            if ( luku1==-9999  ) return;
            
            io.print("luku 2: ");
            int luku2 = io.nextInt();           
            if ( luku2==-9999 ) return;
            
            int vastaus = laskeSumma(luku1, luku2);
            io.print("summa: "+vastaus+"\n");
        }
    }

    private int laskeSumma(int luku1, int luku2) {
        return luku1+luku2;
    }      
   
}
