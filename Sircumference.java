
/**
 * Represents a Sircumference.
 *
 * @author Joshua Wu
 * @version 1
 */
public class Sircumference extends Monster
{
    private int level;
    private int att;
    private int def;
    private int satt;
    private int sdef;
    private int spd;
    private int health;

    /**
     * Constructor for objects of class Sircumference
     */
    public Sircumference(int averageLevel)
    {
        super("Sircumference");
        level = averageLevel;
        att = 50;
        def = 90;
        satt = 105;
        sdef = 100;
        spd = 95;
        health = 60;
    }
    
    public void stats()
    {
        setStats((int) ((att + 20) / 50.0 * level), (int) ((def + 20) / 50.0 * level), (int) ((satt + 20) / 50.0 * level), (int) ((sdef + 20) / 50.0 * level), (int) ((spd + 20) / 50.0 * level), (int) ((health + 20) / 25.0 * level), level);
    }
    
    public void display()
    {
        setPicture("sircumference.png");
    }
    
    public void moves()
    {
        setMoves("Explosion", "Gyro Ball", "Thunderbolt", "Mustache Attack", 250, 250 - getSpd(), 90, 100);
    }
    
    public void transform(Monster[] monsters)
    {
        
    }
}
