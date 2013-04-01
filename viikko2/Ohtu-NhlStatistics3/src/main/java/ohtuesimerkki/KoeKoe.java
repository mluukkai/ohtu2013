package ohtuesimerkki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KoeKoe {
    @Autowired
    private Koe koe;
    
//    @Autowired
//    public KoeKoe(Koe koe) {
//        this.koe = koe;
//    }
    
    public void foo(){
        koe.f();
    }
}
