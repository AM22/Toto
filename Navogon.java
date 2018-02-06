
/**
 * Represents a Navogon.
 *
 * @author Joshua Wu
 * @version 1
 */
public class Navogon extends Monster
{
    private int level;
    private int att;
    private int def;
    private int satt;
    private int sdef;
    private int spd;
    private int health;

    /**
     * Constructor for objects of class Navogon
     */
    public Navogon(int averageLevel)
    {
        super("Navogon");
        level = averageLevel;
        att = 135;
        def = 95;
        satt = 120;
        sdef = 65;
        spd = 100;
        health = 85;
    }
    
    public void stats()
    {
        setStats((int) ((att + 20) / 50.0 * level), (int) ((def + 20) / 50.0 * level), (int) ((satt + 20) / 50.0 * level), (int) ((sdef + 20) / 50.0 * level), (int) ((spd + 20) / 50.0 * level), (int) ((health + 20) / 25.0 * level), level);
    }
    
    public void display()
    {
        setPicture("navogon.png");
    }
    
    public void moves()
    {
        setMoves("Bone Rush", "Icicle Crash", "Absolute Zero", "Draco Meteor", 125, 85, 200, 130);
    }
    
    public void transform(Monster[] monsters)
    {
        
    }
}
