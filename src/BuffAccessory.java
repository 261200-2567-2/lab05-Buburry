public class BuffAccessory extends Accessory{
    protected double statsBoost;
    protected double statsCurse;

    public BuffAccessory(String name, String type,double damage,double defense,double affectspeed,int mana, double statsBoost, double statsCurse) {
        super(name, type, damage, defense, affectspeed, mana); // Call Accessory constructor
        setStatsBoost(statsBoost);
        setStatsCurse(statsCurse);
    }

    //apply statsBoost
    public void setStatsBoost(double statsBoost) {
        if (statsBoost < 0) {
            throw new IllegalArgumentException("statsBoost must be Positive!");
        }
        this.statsBoost = statsBoost;

        // Apply the boost to inherited stats
        this.damage += statsBoost;
        this.defense += statsBoost;
        this.affectspeed += statsBoost;
        this.mana += statsBoost;
    }

    //apply statsCurse
    public void setStatsCurse(double statsCurse) {
        if (statsCurse > 0) {
            throw new IllegalArgumentException("statsBoost must be Negative!");
        }
        this.statsCurse = statsCurse;

        if(statsCurse > 0) statsCurse = -statsCurse;
        // Apply the Curse to inherited stats
        this.damage += statsCurse;
        this.defense += statsCurse;
        this.affectspeed += statsCurse;
        this.mana += statsCurse;
    }

    // Display Buff Accessory details
    @Override
    public void display() {
        super.display(); // Call parent class display method
        System.out.println("Stats Boost: " + (statsBoost > 0 ? statsBoost : "None"));
        System.out.println("Stats Curse: " + (statsCurse < 0 ? statsCurse : "None"));
    }
    @Override
    public int getMana() {
        return mana;
    }
}
