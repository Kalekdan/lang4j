package main.java.com.pixolestudios.lang4j;

import main.java.com.pixolestudios.exceptions.NoResourceFileException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileUtils {
    private FileUtils() {
    }

    protected static String loadResFromPropsFile(String fileLoc, String res) throws NoResourceFileException {
        try (InputStream stream = new FileInputStream(fileLoc)) {
            Properties props = new Properties();
            props.load(stream);
            return props.getProperty(res);
        } catch (FileNotFoundException e) {
            throw new NoResourceFileException(fileLoc);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
