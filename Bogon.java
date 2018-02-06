
/**
 * Represents a Bogon.
 *
 * @author Joshua Wu
 * @version 1
 */
public class Bogon extends Monster
{
    private int level;
    private int att;
    private int def;
    private int satt;
    private int sdef;
    private int spd;
    private int health;

    /**
     * Constructor for objects of class Bogon
     */
    public Bogon(int averageLevel)
    {
        super("Bogon");
        level = averageLevel;
        att = 100;
        def = 85;
        satt = 60;
        sdef = 50;
        spd = 65;
        health = 65;
    }
    
    public void stats()
    {
        setStats((int) ((att + 20) / 50.0 * level), (int) ((def + 20) / 50.0 * level), (int) ((satt + 20) / 50.0 * level), (int) ((sdef + 20) / 50.0 * level), (int) ((spd + 20) / 50.0 * level), (int) ((health + 20) / 25.0 * level), level);
        setThreshold(55);
    }
    
    public void display()
    {
        setPicture("bogon.png");
    }
    
    public void transform(Monster[] myMonsters)
    {
        myMonsters[0] = new Navogon(level);
    }
    
    public void moves()
    {
        setMoves("Bonemerang", "Dragon Claw", "Frost Breath", "Ancient Power", 100, 80, 80, 60);
    }
}
