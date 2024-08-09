package data;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

public class Token {

    private final String tokenFile = System.getProperty("token_file");

    public String getBearerToken() {
        final String token;
        try {
            FileInputStream fis = new FileInputStream(tokenFile);
            token = IOUtils.toString(fis, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return String.format("Bearer %s", token);
    }
}