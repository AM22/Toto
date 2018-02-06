
/**
 * Represents a Adagon.
 *
 * @author Joshua Wu
 * @version 1
 */
public class Adagon extends Monster
{
    private int level;
    private int att;
    private int def;
    private int satt;
    private int sdef;
    private int spd;
    private int health;

    /**
     * Constructor for objects of class Adagon
     */
    public Adagon(int averageLevel)
    {
        super("Adagon");
        level = averageLevel;
        att = 135;
        def = 80;
        satt = 110;
        sdef = 80;
        spd = 100;
        health = 95;
    }
    
    public void stats()
    {
        setStats((int) ((att + 20) / 50.0 * level), (int) ((def + 20) / 50.0 * level), (int) ((satt + 20) / 50.0 * level), (int) ((sdef + 20) / 50.0 * level), (int) ((spd + 20) / 50.0 * level), (int) ((health + 20) / 25.0 * level), level);
    }
    
    public void display()
    {
        setPicture("adagon.png");
    }
    
    public void moves()
    {
        setMoves("Outrage", "Fly", "Ice Beam", "Dragonslayer", 120, 95, 90, 140);
    }
    
    public void transform(Monster[] monsters)
    {
        
    }
}
