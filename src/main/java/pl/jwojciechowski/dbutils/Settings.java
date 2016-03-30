package pl.jwojciechowski.dbutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings {

    private static final Properties props = new Properties();
    private static final String fileName = "mongo.properties";

    public static String getProperty(String key) throws IOException {
        props.load(new FileInputStream(fileName));
        return props.getProperty(key);
    }
}
