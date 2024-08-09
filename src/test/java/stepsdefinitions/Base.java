package stepsdefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class Base {

    protected static final Properties properties = new Properties();

    static {
        String propertiesEnv = System.getProperty("env");
        if (propertiesEnv == null) {
            propertiesEnv = "prod";
        }
        try {
            FileInputStream file = new FileInputStream(String.format("./src/test/resources/properties/%s.properties",
                    propertiesEnv));
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
