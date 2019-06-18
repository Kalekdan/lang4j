package main.java.com.pixolestudios.lang4j;

public class DemoL4J {
    private DemoL4J() {
    }

    public static void main(String[] args) {
        System.out.println(L4j.getResource("characterNames", "mc.name"));
        System.out.println(L4j.getResource("characterNames", "mc.name", "fr"));
        System.out.println(L4j.getResource("characterNames", "mc.name", "eng"));
    }
}
