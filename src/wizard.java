public class wizard extends Character{
    protected JobAccessory jobAccessory;

    public wizard(String name) {
        super(name);
        this.jobAccessory = null;

        this.Job = "wizard"; // Set the Job type to wizard
    }

    //ability
    public void Fireball(Character target) {
        if(this.mana >= 40) {
            this.mana = this.mana - 40;

            // Calculate effective damage after considering target's defense
            double effectiveDamage = this.damage - target.defense;
            if (effectiveDamage < 0) {
                effectiveDamage = 0; // Ensure no healing or negative damage
            }
            target.HP -= effectiveDamage;
            System.out.println(this.name + " casts Fireball on " + target.name + " dealing " + this.damage + " damage!");
        } else {
            System.out.println(this.name + "Can't use ablity. only " + this.mana + "mana left");
        }
    }

    public void equipJobAccessory(JobAccessory Accessory) {
        if(jobAccessory != null) {
            unequipJobAccessory();
        }

        jobAccessory = Accessory;
        speed += jobAccessory.getAffectspeed();
        damage += jobAccessory.getDamage();
        defense += jobAccessory.getDefense();
        mana += jobAccessory.getMana();
        jobAccessory.EnchanceMage(this);
        System.out.println("Equipped " + jobAccessory.getAccessoryName() + "in the jobAccessory");
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
    @Override
    public void recalculateStats() {
        super.recalculateStats();

        // Add effects of the neck accessory (if equipped)
        if (jobAccessory != null) {
            speed += jobAccessory.getAffectspeed();
            damage += jobAccessory.getDamage();
            defense += jobAccessory.getDefense();
            mana += jobAccessory.getMana();
        }

    }
}
