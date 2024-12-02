public class warrior extends Character {
    protected JobAccessory jobAccessory;

    public warrior(String name) {
        super(name);
        this.jobAccessory = null;
        this.Job = "Warrior"; // Set the Job type to Warrior
    }

    //ability
    public void Endurace() {
        if(this.mana >= 30) {
            this.mana = this.mana - 30;
            this.defense = this.defense * (1.5 * level);
            this.HP = this.HP + (5 * level);
            System.out.println(this.name + " casts Endurace defence:" + this.defense + " HP: " + this.HP + "!");
        } else {
            System.out.println(this.name + "Can't use ablity. only " + this.mana + "mana left");
        }
    }

    public void equipJobAccessory(JobAccessory Accessory) {

            if (jobAccessory != null) {
                unequipJobAccessory();
            }

            jobAccessory = Accessory;
            speed += jobAccessory.getAffectspeed();
            damage += jobAccessory.getDamage();
            defense += jobAccessory.getDefense();
            mana += jobAccessory.getMana();

            jobAccessory.EnchanceWarrior(this);
            System.out.println("Equipped " + jobAccessory.getAccessoryName() + " in the jobAccessory");

    }
    public void unequipJobAccessory() {
        if(jobAccessory != null) {
            speed -= jobAccessory.getAffectspeed();
            damage -= jobAccessory.getDamage();
            defense -= jobAccessory.getDefense();
            mana -= jobAccessory.getMana();

            System.out.println("Unequipped " + jobAccessory.getAccessoryName());
            jobAccessory = null;
        }
    }

    @Override
    public void displayCharacter() {
        super.displayCharacter(); // Call the parent method to display base stats
        System.out.println("Job Accessory: " +
                (jobAccessory == null ? "None" : jobAccessory.getAccessoryName()));
    }
}
