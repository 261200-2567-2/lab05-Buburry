public class Character {
    protected String name;
    protected double HP;
    protected int mana;
    protected double speed;
    protected int level;
    protected double damage;
    protected double defense;
    protected String Job;
    protected Accessory neck;
    protected Accessory belt;

    public Character(String name) {
        this.name = name;
        this.HP = 100;
        this.mana = 100;
        this.speed = 10.00;
        this.level = 1;
        this.damage = 1.00;
        this.defense = 1.00;
        this.neck = null;
        this.belt = null;


    }


    public void equipAccessoryNeck(Accessory accessory) {
        if(neck != null) {
            unequipAccessoryNeck();
        }
        neck = accessory;
        speed += neck.getAffectspeed();
        damage += neck.getDamage();
        defense += neck.getDefense();
        mana += neck.getMana();
        System.out.println("Equipped " + neck.getAccessoryName() + "in the Neck");
    }
    public void unequipAccessoryNeck() {
        if(neck != null) {
            speed -= neck.getAffectspeed();
            damage -= neck.getDamage();
            defense -= neck.getDefense();
            mana -= neck.mana;

            System.out.println("Unequipped " + neck.getAccessoryName());
            neck = null;
        }
    }

    public void equipAccessoryBelt(Accessory Belt) {
        if(belt != null) {
            unequipAccessoryBelt();
        }
        belt = Belt;
        speed += belt.getAffectspeed();
        damage += belt.getDamage();
        defense += belt.getDefense();
        mana += belt.getMana();
        System.out.println("Equipped " + belt.getAccessoryName() + "in the belt");
    }
    public void unequipAccessoryBelt() {
        if(belt != null) {
            speed -= belt.getAffectspeed();
            damage -= belt.getDamage();
            defense -= belt.getDefense();
            mana -= belt.getMana();

            System.out.println("Unequipped " + belt.getAccessoryName());
            belt = null;
        }
    }

    public void levelup() {
        //when levelup +max HP +maxmana +speed
        this.level++;
        this.HP += 10;
        this.mana += 2;
        this.speed += 0.1 + (0.03*level);
        System.out.println(name + " leveled up to level " + level + "!");
        System.out.println("Status update: HP = " + HP
                + ", Mana = " + mana + ", Speed = " + speed);
    }

    public void recalculateStats() {
        // Reset stat
        damage = 1.0;
        defense = 1.0;
        speed = 10.0;
        mana = 100;

        // Add effects of items
        if (neck != null) {
            speed += neck.getAffectspeed();
            damage += neck.getDamage();
            defense += neck.getDefense();
            mana += neck.getMana();
        }
        if (belt != null) {
            speed -= belt.getAffectspeed();
            damage -= belt.getDamage();
            defense -= belt.getDefense();
            mana -= belt.mana;
        }
    }

    // display character
    public void displayCharacter() {
        recalculateStats();
        System.out.println("Name: " + name );
        System.out.println("Level: " + level);
        System.out.println("HP: " + HP);
        System.out.println("Mana: " + mana);
        System.out.println("Damage: " + damage);
        System.out.println("Defense: " + defense);
        System.out.println("Speed: " + speed);
        System.out.println("Job: " + Job);


        System.out.println("Neck Equipment: " +
                (neck == null ?  "None" : neck.getAccessoryName())
        );
        System.out.println("Belt Equipment: " +
                (belt == null ?  "None"  : belt.getAccessoryName() )
        );
    }

}
