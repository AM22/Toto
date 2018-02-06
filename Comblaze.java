
/**
 * Represents a Sfere.
 *
 * @author Joshua Wu
 * @version 1
 */
public class Comblaze extends Monster
{
    private int level;
    private int att;
    private int def;
    private int satt;
    private int sdef;
    private int spd;
    private int health;

    /**
     * Constructor for objects of class Comblaze
     */
    public Comblaze(int averageLevel)
    {
        super("Comblaze");
        level = averageLevel;
        att = 120;
        def = 60;
        satt = 110;
        sdef = 60;
        spd = 115;
        health = 70;
    }
    
    public void stats()
    {
        setStats((int) ((att + 20) / 50.0 * level), (int) ((def + 20) / 50.0 * level), (int) ((satt + 20) / 50.0 * level), (int) ((sdef + 20) / 50.0 * level), (int) ((spd + 20) / 50.0 * level), (int) ((health + 20) / 25.0 * level), level);
    }
    
    public void display()
    {
        setPicture("comblaze.png");
    }
    
    public void moves()
    {
        setMoves("Close Combat", "Wombo Combo", "Flamethrower", "Hyper Beam", 120, 130, 90, 100);
    }
    
    public void transform(Monster[] monsters)
    {
        
    }
}
