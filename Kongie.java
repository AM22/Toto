
/**
 * Represents a Sfere.
 *
 * @author Joshua Wu
 * @version 1
 */
public class Kongie extends Monster
{
    private int level;
    private int att;
    private int def;
    private int satt;
    private int sdef;
    private int spd;
    private int health;

    /**
     * Constructor for objects of class Kongie
     */
    public Kongie(int averageLevel)
    {
        super("Kongie");
        level = averageLevel;
        att = 70;
        def = 50;
        satt = 50;
        sdef = 35;
        spd = 50;
        health = 55;
    }
    
    public void stats()
    {
        setStats((int) ((att + 20) / 50.0 * level), (int) ((def + 20) / 50.0 * level), (int) ((satt + 20) / 50.0 * level), (int) ((sdef + 20) / 50.0 * level), (int) ((spd + 20) / 50.0 * level), (int) ((health + 20) / 25.0 * level), level);
        setThreshold(18);
    }
    
    public void display()
    {
        setPicture("kongie.png");
    }
    
    public void transform(Monster[] myMonsters)
    {
        myMonsters[0] = new Flamate(level);
    }
    
    public void moves()
    {
        setMoves("Scratch", "Karate Chop", "Growl", "Ember", 40, 50, 0, 40);
    }
}
