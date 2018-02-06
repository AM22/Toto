
/**
 * Represents a Epiman.
 *
 * @author Joshua Wu
 * @version 1
 */
public class Epiman extends Monster
{
    private int level;
    private int att;
    private int def;
    private int satt;
    private int sdef;
    private int spd;
    private int health;

    /**
     * Constructor for objects of class Epiman
     */
    public Epiman(int averageLevel)
    {
        super("Epiman");
        level = averageLevel;
        att = 70;
        def = 45;
        satt = 45;
        sdef = 60;
        spd = 50;
        health = 40;
    }
    
    public void stats()
    {
        setStats((int) ((att + 20) / 50.0 * level), (int) ((def + 20) / 50.0 * level), (int) ((satt + 20) / 50.0 * level), (int) ((sdef + 20) / 50.0 * level), (int) ((spd + 20) / 50.0 * level), (int) ((health + 20) / 25.0 * level), level);
        setThreshold(18);
    }
    
    public void display()
    {
        setPicture("epiman.png");
    }
    
    public void transform(Monster[] myMonsters)
    {
        myMonsters[0] = new Epidude(level);
    }
    
    public void moves()
    {
        setMoves("Tackle", "Lick", "Epicness", "Leer", 50, 20, 50, 0);
    }
}
