
/**
 * Represents a Sfere.
 *
 * @author Joshua Wu
 * @version 1
 */
public class Tsunamo extends Monster
{
    private int level;
    private int att;
    private int def;
    private int satt;
    private int sdef;
    private int spd;
    private int health;

    /**
     * Constructor for objects of class Tsunamo
     */
    public Tsunamo(int averageLevel)
    {
        super("Tsunamo");
        level = averageLevel;
        att = 105;
        def = 70;
        satt = 115;
        sdef = 70;
        spd = 120;
        health = 55;
    }
    
    public void stats()
    {
        setStats((int) ((att + 20) / 50.0 * level), (int) ((def + 20) / 50.0 * level), (int) ((satt + 20) / 50.0 * level), (int) ((sdef + 20) / 50.0 * level), (int) ((spd + 20) / 50.0 * level), (int) ((health + 20) / 25.0 * level), level);
    }
    
    public void display()
    {
        setPicture("tsunamo.png");
    }
    
    public void moves()
    {
        setMoves("Toxic Star", "Aquatana", "Hydro Pump", "Phantom Force", 100, 120, 110, 90);
    }
    
    public void transform(Monster[] monsters)
    {
        
    }
}
