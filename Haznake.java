
/**
 * Represents a Haznake.
 *
 * @author Joshua Wu
 * @version 1
 */
public class Haznake extends Monster
{
    private int level;
    private int att;
    private int def;
    private int satt;
    private int sdef;
    private int spd;
    private int health;

    /**
     * Constructor for objects of class Haznake
     */
    public Haznake(int averageLevel)
    {
        super("Haznake");
        level = averageLevel;
        att = 117;
        def = 109;
        satt = 73;
        sdef = 89;
        spd = 109;
        health = 103;
    }
    
    public void stats()
    {
        setStats((int) ((att + 20) / 50.0 * level), (int) ((def + 20) / 50.0 * level), (int) ((satt + 20) / 50.0 * level), (int) ((sdef + 20) / 50.0 * level), (int) ((spd + 20) / 50.0 * level), (int) ((health + 20) / 25.0 * level), level);
    }
    
    public void display()
    {
        setPicture("haznake.png");
    }
    
    public void moves()
    {
        setMoves("Outrage", "Crunch", "Dragon Pulse", "Z Move", 120, 80, 90, 150);
    }
    
    public void transform(Monster[] monsters)
    {
        
    }
}
