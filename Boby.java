
/**
 * Represents a Boby.
 *
 * @author Joshua Wu
 * @version 1
 */
public class Boby extends Monster
{
    private int level;
    private int att;
    private int def;
    private int satt;
    private int sdef;
    private int spd;
    private int health;

    /**
     * Constructor for objects of class Boby
     */
    public Boby(int averageLevel)
    {
        super("Boby");
        level = averageLevel;
        att = 75;
        def = 60;
        satt = 50;
        sdef = 25;
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
        setPicture("boby.png");
    }
    
    public void transform(Monster[] myMonsters)
    {
        myMonsters[0] = new Bogon(level);
    }
    
    public void moves()
    {
        setMoves("Bone Club", "Tackle", "Powder Snow", "Fake Tears", 65, 50, 40, 0);
    }
}
