package helpers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class SaveFile {

    Object object;
    String path;

    public SaveFile(final Object object, final String path) {
        this.object = object;
        this.path = path;
    }

    public void saveFile() {
        try {
            new ObjectMapper().writeValue(new File(path), object);
            System.out.println("File saved");
        } catch (Exception e) {
            System.out.println("Exception while saving file " + e.getMessage());
        }
    }
}
