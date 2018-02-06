
/**
 * Represents a Sfere.
 *
 * @author Joshua Wu
 * @version 1
 */
public class Flamate extends Monster
{
    private int level;
    private int att;
    private int def;
    private int satt;
    private int sdef;
    private int spd;
    private int health;

    /**
     * Constructor for objects of class Flamate
     */
    public Flamate(int averageLevel)
    {
        super("Flamate");
        level = averageLevel;
        att = 85;
        def = 60;
        satt = 80;
        sdef = 60;
        spd = 65;
        health = 65;
    }
    
    public void stats()
    {
        setStats((int) ((att + 20) / 50.0 * level), (int) ((def + 20) / 50.0 * level), (int) ((satt + 20) / 50.0 * level), (int) ((sdef + 20) / 50.0 * level), (int) ((spd + 20) / 50.0 * level), (int) ((health + 20) / 25.0 * level), level);
        setThreshold(36);
    }
    
    public void display()
    {
        setPicture("flamate.png");
    }
    
    public void transform(Monster[] myMonsters)
    {
        myMonsters[0] = new Comblaze(level);
    }
    
    public void moves()
    {
        setMoves("Flame Charge", "Brick Break", "Stored Power", "Flame Burst", 50, 70, 40, 70);
    }
}
