package stepsdefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {

    protected static final Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream(String.format("./src/test/resources/properties/%s.properties",
                    System.getProperty("env")));
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
