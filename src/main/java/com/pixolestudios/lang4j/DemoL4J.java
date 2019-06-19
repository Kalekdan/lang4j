package main.java.com.pixolestudios.lang4j;

public class DemoL4J {
    private DemoL4J() {
    }

    public static void main(String[] args) {
        System.out.println(L4j.getResource("characterNames", "mc.name"));
        System.out.println(L4j.getResource("characterNames", "mc.name", "fr"));
        System.out.println(L4j.getResource("characterNames", "mc.name", "enfg"));

        System.out.println(L4j.getResourceInDir("dialog", "npc", "al3ert.hurt"));
        System.out.println(L4j.getResourceInDir("dialog", "npc", "alert.hurt", "fr"));
        System.out.println(L4j.getResourceInDir("dialog", "npc", "alert.question"));
        System.out.println(L4j.getResourceInDir("dialog", "npc", "alert.question", "fr"));
        System.out.println(L4j.getResourceInDir("dialog", "npc", "compliment"));
        System.out.println(L4j.getResourceInDir("dialog", "npc", "compliment", "fr"));

        System.out.println(L4j.getResourceInDir("dialog", "player", "self.lost"));
        System.out.println(L4j.getResourceInDir("dialog", "player", "self.lost", "fr"));
        System.out.println(L4j.getResourceInDir("dialog", "player", "shout.help"));
        System.out.println(L4j.getResourceInDir("dialog", "player", "shout.help", "fr"));
        System.out.println(L4j.getResourceInDir("dialog", "player", "shopping"));
        System.out.println(L4j.getResourceInDir("dialog", "player", "shopping", "fr"));
    }
}
