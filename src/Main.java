public class Main {
    public static void main(String[] args) {
        // Create Job Accessories
        JobAccessory wizardHat = new JobAccessory("Wizard Hat", "hat", 20, 2, 1.5, 50, "wizard");
        JobAccessory warriorShield = new JobAccessory("Warrior Shield", "shield", 30, 8, -0.5, 20, "warrior");

        // Create Characters
        wizard gandalf = new wizard("Gandalf");
        warrior aragorn = new warrior("Aragorn");

        // Display Initial Stats
        System.out.println("Initial Stats:");
        gandalf.displayCharacter();
        aragorn.displayCharacter();
        System.out.println(" ");

        aragorn.equipJobAccessory(warriorShield);
        gandalf.equipJobAccessory(wizardHat);

        // Wizard casts Fireball on Warrior
        System.out.println("\nWizard casts Fireball:");
        gandalf.Fireball(aragorn);
        System.out.println(" ");

        // Display Updated Stats
        System.out.println("\nUpdated Stats:");
        gandalf.displayCharacter();
        aragorn.displayCharacter();
        System.out.println(" ");

        BuffAccessory space = new BuffAccessory(
        "Space", "belt", 6, 1, 1, 50, 5, 0);
       BuffAccessory Ocean = new BuffAccessory(
                "Ocean", "necklace", 0, 10, 5, 10, 6, 0);

        aragorn.equipAccessoryBelt(space);
        aragorn.equipAccessoryNeck(Ocean);
        aragorn.Endurace();
        aragorn.displayCharacter();
        aragorn.levelup();
    }
}