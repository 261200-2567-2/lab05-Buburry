public class JobAccessory extends Accessory {
    public String accessJob; // Allowed job for the accessory

    public JobAccessory(String name, String type,double damage,double defense,double affectspeed,int mana,String accessJob) {
        super(name,type,damage,defense,affectspeed,mana);
        setAccessJob(accessJob); // Set allowed job
        this.accessJob = accessJob;
    }

    public void setAccessJob(String accessJob) {
        if (accessJob.equals("warrior") || accessJob.equals("wizard")) {
            this.accessJob = accessJob;
        } else {
            throw new IllegalArgumentException("You can't use this Accessory unless you're a warrior or a wizard.");
        }


    }

    public void EnchanceMage(Character character) {
        if(accessJob.equals("wizard")) {
            character.damage += (this.damage * 3);
            character.defense -= this.defense; // Decrease defense for mage
            character.mana += this.mana;
            character.speed += this.affectspeed;
        }
    }

    public void EnchanceWarrior(Character character) {
        if(accessJob.equals("warrior")) {
            character.damage += 0;  // No damage boost for warrior
            character.defense += (this.defense * 2);
            character.mana += this.mana;
            character.speed -= this.affectspeed;
        }
    }

    @Override
    public void display() {
        super.display(); // Call parent class display method
        System.out.println("Allowed Job: " + accessJob);
    }
    @Override
    public void setAccessoryType(String type) {

            this.type = type;

    }
}
