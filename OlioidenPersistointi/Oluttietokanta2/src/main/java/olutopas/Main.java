package olutopas;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.dbplatform.SQLitePlatform;
import olutopas.model.Beer;
import olutopas.model.Brewery;

import com.avaje.ebean.Transaction;
import olutopas.model.Pub;
import olutopas.model.User;

public class Main {

    enum Database {

        H2, SQLite
    }

    public static void main(String[] args) {
        boolean dropAndCreateTables = true;
        EbeanServer server = initializeDatabase(dropAndCreateTables, Database.SQLite);
        new Application(server).run(dropAndCreateTables);
    }

    private static EbeanServer initializeDatabase(boolean dropAndCreateDatabase, Database db) {
        ServerConfig config = new ServerConfig();
        config.setName("beerDb");

        if (db == Database.H2) {
            DataSourceConfig hdDB = new DataSourceConfig();
            hdDB.setDriver("org.h2.Driver");
            hdDB.setUsername("test");
            hdDB.setPassword("test");
            hdDB.setUrl("jdbc:h2:mem:tests;DB_CLOSE_DELAY=-1");
            hdDB.setHeartbeatSql("select 1 ");
            config.setDataSourceConfig(hdDB);
        }

        if (db == Database.SQLite) {
            DataSourceConfig sqLite = new DataSourceConfig();
            sqLite.setDriver("org.sqlite.JDBC");
            sqLite.setUsername("mluukkai");
            sqLite.setPassword("mluukkai");
            sqLite.setUrl("jdbc:sqlite:beer.db");
            config.setDataSourceConfig(sqLite);
            config.setDatabasePlatform(new SQLitePlatform());
            config.getDataSourceConfig().setIsolationLevel(Transaction.READ_UNCOMMITTED);
        }

        config.setDefaultServer(false);
        config.setRegister(false);

        config.addClass(Beer.class);
        config.addClass(Brewery.class);
        config.addClass(Pub.class);
        config.addClass(User.class);

        if (dropAndCreateDatabase) {
            config.setDdlGenerate(true);
            config.setDdlRun(true);
            //config.setDebugSql(true);
        }

        return EbeanServerFactory.create(config);
    }
}
