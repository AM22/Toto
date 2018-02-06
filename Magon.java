
/**
 * Represents a Sfere.
 *
 * @author Joshua Wu
 * @version 1
 */
public class Magon extends Monster
{
    private int level;
    private int att;
    private int def;
    private int satt;
    private int sdef;
    private int spd;
    private int health;

    /**
     * Constructor for objects of class Magon
     */
    public Magon(int averageLevel)
    {
        super("Magon");
        level = averageLevel;
        att = 70;
        def = 35;
        satt = 60;
        sdef = 45;
        spd = 55;
        health = 45;
    }
    
    public void stats()
    {
        setStats((int) ((att + 20) / 50.0 * level), (int) ((def + 20) / 50.0 * level), (int) ((satt + 20) / 50.0 * level), (int) ((sdef + 20) / 50.0 * level), (int) ((spd + 20) / 50.0 * level), (int) ((health + 20) / 25.0 * level), level);
        setThreshold(30);
    }
    
    public void display()
    {
        setPicture("magon.png");
    }
    
    public void transform(Monster[] myMonsters, boolean death)
    {
        if(death)
        {
            myMonsters[0] = new Boby(level);
        }
        else
        {
            myMonsters[0] = new Icagon(level);
        }
    }
    
    public void transform(Monster[] monsters)
    {
        
    }
    
    public void moves()
    {
        setMoves("Tackle", "Wing Attack", "Gust", "Charm", 50, 60, 40, 0);
    }
}
