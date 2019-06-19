package main.java.com.pixolestudios.exceptions;

public class NoResourceFoundException extends Exception {
    public NoResourceFoundException(String path, String resource) {
        super("No resource \"" + resource + "\" found in resource file " + path);
    }
}