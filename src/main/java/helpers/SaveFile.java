package helpers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class SaveFile {
    public static void saveFile(final Object object, final String path) {
        try {
            new ObjectMapper().writeValue(new File(path), object);
            System.out.println("File saved to " + path);
        } catch (Exception e) {
            System.out.println("Exception while saving file " + e.getMessage());
        }
    }
}
