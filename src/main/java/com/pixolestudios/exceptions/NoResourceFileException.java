package main.java.com.pixolestudios.exceptions;

public class NoResourceFileException extends Exception {
    public NoResourceFileException(String fileLoc) {
        super("No resource file found at " + fileLoc);
    }
}
