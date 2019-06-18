package main.java.com.pixolestudios.lang4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileUtils {
    private FileUtils() {
    }

    protected static String loadResFromPropsFile(String fileLoc, String res){
        try (InputStream stream = new FileInputStream(fileLoc)) {
            Properties props = new Properties();
            props.load(stream);
            return props.getProperty(res);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
