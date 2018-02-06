
/**
 * Represents a Sfere.
 *
 * @author Joshua Wu
 * @version 1
 */
public class Epidude extends Monster
{
    private int level;
    private int att;
    private int def;
    private int satt;
    private int sdef;
    private int spd;
    private int health;

    /**
     * Constructor for objects of class Epidude
     */
    public Epidude(int averageLevel)
    {
        super("Epidude");
        level = averageLevel;
        att = 90;
        def = 60;
        satt = 45;
        sdef = 80;
        spd = 70;
        health = 60;
    }
    
    public void stats()
    {
        setStats((int) ((att + 20) / 50.0 * level), (int) ((def + 20) / 50.0 * level), (int) ((satt + 20) / 50.0 * level), (int) ((sdef + 20) / 50.0 * level), (int) ((spd + 20) / 50.0 * level), (int) ((health + 20) / 25.0 * level), level);
        setThreshold(36);
    }
    
    public void display()
    {
        setPicture("epidude.png");
    }
    
    public void transform(Monster[] myMonsters)
    {
        myMonsters[0] = new Epiguy(level);
    }
    
    public void moves()
    {
        setMoves("Epic Face", "Bite", "Hyper Voice", "Round", 85, 60, 90, 60);
    }
}
