
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
    
    Statistics stats;

    @Before
    public void setUp(){
        stats = new Statistics(readerStub);
    }
    
    //search()-metodin testit
    
    @Test
    public void searchPalauttaaOikeanNimisenPelaajanJosListalla() {
        assertEquals("Kurri" ,stats.search("Kurri").getName());
    }
    
    @Test
    public void searchPalauttaaNullJosPelaajaEiListalla() {
        assertNull(stats.search("Pinja"));
    }
    
    //team()-metodin testit
    
    @Test
    public void teamPalauttaaOikeanKokoisenJoukkueen() {
        List<Player> joukkue = stats.team("EDM");
        assertEquals(3, joukkue.size());
    }
    
    @Test
    public void teamPalauttaaOikeanJoukkueenPelaajat() {
        List<Player> joukkue = stats.team("EDM");
        
        Player p1 = joukkue.get(0);
        Player p2 = joukkue.get(1);
        Player p3 = joukkue.get(2);
        
        assertEquals("Semenko", p1.getName());
        assertEquals("Kurri", p2.getName());
        assertEquals("Gretzky", p3.getName());
    }
    
    //topScorers()-metodin testit
    
    @Test
    public void topScorersPalauttaaHalutunMaaranPelaajia() {
        List<Player> parhaat = stats.topScorers(4);
        assertEquals(5, parhaat.size());
    }
    
    @Test
    public void topScorersPalauttaaPelaajatParemmuusJarjestyksessa() {
        List<Player> parhaat = stats.topScorers(2);
        
        int edellinen = 100000;
        boolean jarjestyksessa = true;
        
        for(Player p : parhaat){
            if(p.getPoints() > edellinen) jarjestyksessa = false;
            edellinen = p.getPoints();
        }
        
        assertTrue(jarjestyksessa);
    }
    
}