package pl.jwojciechowski.dbutils;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.io.IOException;

public class DBUtils {
    private static MongoClient client;
    private static Datastore ds;

    public static MongoClient getMongoClient() {
        try {
            String server = Settings.getProperty("server");
            String port = Settings.getProperty("port");
            client = new MongoClient(server, Integer.parseInt(port));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return client;
    }

    public static Datastore getDatastore(Class<?> className, String tableName) {
        Morphia morphia = new Morphia();
        morphia.map(className);
        ds = morphia.createDatastore(getMongoClient(), tableName);
        return ds;
    }

    public static void closeConnection() {
        client.close();
    }
}
