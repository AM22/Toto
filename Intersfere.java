
/**
 * Represents a Intersfere.
 *
 * @author Joshua Wu
 * @version 1
 */
public class Intersfere extends Monster
{
    private int level;
    private int att;
    private int def;
    private int satt;
    private int sdef;
    private int spd;
    private int health;

    /**
     * Constructor for objects of class Intersfere
     */
    public Intersfere(int averageLevel)
    {
        super("Intersfere");
        level = averageLevel;
        att = 75;
        def = 70;
        satt = 95;
        sdef = 90;
        spd = 110;
        health = 60;
    }
    
    public void stats()
    {
        setStats((int) ((att + 20) / 50.0 * level), (int) ((def + 20) / 50.0 * level), (int) ((satt + 20) / 50.0 * level), (int) ((sdef + 20) / 50.0 * level), (int) ((spd + 20) / 50.0 * level), (int) ((health + 20) / 25.0 * level), level);
    }
    
    public void display()
    {
        setPicture("intersfere.png");
    }
    
    public void moves()
    {
        setMoves("Explosion", "Thunder", "Wild Charge", "Roadblock", 250, 110, 90, 60);
    }
    
    public void transform(Monster[] monsters)
    {
        
    }
}
