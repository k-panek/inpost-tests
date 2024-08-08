package data;

public class Token {

    private final String token = System.getProperty("token");

    public String getBearerToken() {
        return String.format("Bearer %s", token);
    }
}