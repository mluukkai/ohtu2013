package ohtuesimerkki;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

    static ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/spring-context.xml");    
    
    public static void main(String[] args) {
//        Koe k = (Koe)ctx.getBean("koe");
//        k.f();
//              
//        KoeKoe kk = ctx.getBean(KoeKoe.class);
//        kk.foo();
        
        Statistics stats = ctx.getBean(Statistics.class);
        
        System.out.println("Philadelphia Flyers");
        for (Player player : stats.team("PHI") ) {
            System.out.println( player );
        }
        
        System.out.println("");
        
        System.out.println("Top scorers");
        for (Player player : stats.topScorers(10) ) {
            System.out.println( player );
        }        
    }
}
