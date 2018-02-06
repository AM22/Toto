
/**
 * Represents a Sfere.
 *
 * @author Joshua Wu
 * @version 1
 */
public class Sfere extends Monster
{
    private int level;
    private int att;
    private int def;
    private int satt;
    private int sdef;
    private int spd;
    private int health;

    /**
     * Constructor for objects of class Sfere
     */
    public Sfere(int averageLevel)
    {
        super("Sfere");
        level = averageLevel;
        att = 50;
        def = 40;
        satt = 60;
        sdef = 55;
        spd = 90;
        health = 40;
    }
    
    public void stats()
    {
        setStats((int) ((att + 20) / 50.0 * level), (int) ((def + 20) / 50.0 * level), (int) ((satt + 20) / 50.0 * level), (int) ((sdef + 20) / 50.0 * level), (int) ((spd + 20) / 50.0 * level), (int) ((health + 20) / 25.0 * level), level);
        setThreshold(30);
    }
    
    public void display()
    {
        setPicture("sfere.png");
    }
    
    public void transform(Monster[] myMonsters, boolean monocle)
    {
        if(monocle)
        {
            myMonsters[0] = new Intersfere(level);
        }
        else
        {
            myMonsters[0] = new Sircumference(level);
        }
    }
    
    public void transform(Monster[] monsters)
    {
        
    }
    
    public void moves()
    {
        setMoves("Self Destruct", "Rollout", "Charge Beam", "Block", 200, 50, 50, 0);
    }
}
