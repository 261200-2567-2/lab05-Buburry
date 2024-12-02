public class Accessory {
    private String name;
    protected double damage;
    protected double defense;
    protected String type;
    protected double affectspeed;
    protected int mana;

    public Accessory(String name,String type,double damage,double defense,double affectspeed,int mana) {
        this.name = name;
        this.damage = damage;
        this.defense = defense;
        setAccessoryType(type);
        this.affectspeed = affectspeed;

        this.mana = mana;


    }

    public String getAccessoryName() {
        return name;
    }

    public void setAccessoryType(String type) {
        if(type.equals("necklace") || type.equals("belt")) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Invalid Accessory type! Allowed types: necklace, belt.");
        }
    }

    public double getDamage() {
        return damage;
    }

    public double getDefense() {
        return defense;
    }

    public double getAffectspeed() {
        return affectspeed;
    }

    public int getMana() {
        return mana;
    }

    public void display() {
        System.out.println("Equipment Name: " + name);
        System.out.println("Equipment Type: " + type);
        System.out.println("Damage: " + damage);
        System.out.println("Defense: " + defense);
        System.out.println("Speed Effect: " + affectspeed);
    }

}
