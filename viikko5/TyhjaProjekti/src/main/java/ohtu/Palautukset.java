
package ohtu;

import java.util.ArrayList;
import java.util.List;

public class Palautukset {
    List<Palautus> palautukset = new ArrayList<Palautus>();

    public void setPalautukset(List<Palautus> palautukset) {
        this.palautukset = palautukset;
    }

    public List<Palautus> getPalautukset() {
        return palautukset;
    }
    
    
}
