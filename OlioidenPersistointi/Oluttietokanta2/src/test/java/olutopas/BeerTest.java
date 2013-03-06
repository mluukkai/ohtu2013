package olutopas;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import olutopas.model.Beer;
import olutopas.model.Brewery;

public class BeerTest {

    EbeanServer ebean;

    @Before
    public void setUp() {
        ServerConfig config = new ServerConfig();
        config.setName("beerDb");
        DataSourceConfig hdDB = new DataSourceConfig();
        hdDB.setDriver("org.h2.Driver");
        hdDB.setUsername("test");
        hdDB.setPassword("test");
        hdDB.setUrl("jdbc:h2:mem:tests;DB_CLOSE_DELAY=-1");
        hdDB.setHeartbeatSql("select 1 ");
        config.setDataSourceConfig(hdDB);

        config.setDdlGenerate(true);
        config.setDdlRun(true);

        config.setDefaultServer(false);
        config.setRegister(false);

        config.addClass(Beer.class);
        config.addClass(Brewery.class);

        ebean = EbeanServerFactory.create(config);
    }

    @Test
    public void brewerySavedCorrectly() {
        Brewery brewery = new Brewery("Schlenkerla");

        brewery.addBeer(new Beer("Urbock"));
        brewery.addBeer(new Beer("Lager"));

        ebean.save(brewery);

        Brewery fromBase = ebean.find(Brewery.class, brewery.getId());

        assertTrue(fromBase != null);
        assertEquals("Schlenkerla", fromBase.getName());
        assertEquals(2, fromBase.getBeers().size());
    }
}
