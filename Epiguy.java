
/**
 * Represents a Sfere.
 *
 * @author Joshua Wu
 * @version 1
 */
public class Epiguy extends Monster
{
    private int level;
    private int att;
    private int def;
    private int satt;
    private int sdef;
    private int spd;
    private int health;

    /**
     * Constructor for objects of class Epiguy
     */
    public Epiguy(int averageLevel)
    {
        super("Epiguy");
        level = averageLevel;
        att = 120;
        def = 80;
        satt = 90;
        sdef = 80;
        spd = 70;
        health = 95;
    }
    
    public void stats()
    {
        setStats((int) ((att + 20) / 50.0 * level), (int) ((def + 20) / 50.0 * level), (int) ((satt + 20) / 50.0 * level), (int) ((sdef + 20) / 50.0 * level), (int) ((spd + 20) / 50.0 * level), (int) ((health + 20) / 25.0 * level), level);
    }
    
    public void display()
    {
        setPicture("epiguy.png");
    }
    
    public void moves()
    {
        setMoves("Epic Smash", "Earthquake", "Bazooka", "Lazer Shot", 120, 100, 110, 90);
    }
    
    public void transform(Monster[] monsters)
    {
        
    }
}
