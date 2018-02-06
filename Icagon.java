
/**
 * Represents a Icagon.
 *
 * @author Joshua Wu
 * @version 1
 */
public class Icagon extends Monster
{
    private int level;
    private int att;
    private int def;
    private int satt;
    private int sdef;
    private int spd;
    private int health;

    /**
     * Constructor for objects of class Icagon
     */
    public Icagon(int averageLevel)
    {
        super("Icagon");
        level = averageLevel;
        att = 80;
        def = 70;
        satt = 75;
        sdef = 70;
        spd = 75;
        health = 65;
    }
    
    public void stats()
    {
        setStats((int) ((att + 20) / 50.0 * level), (int) ((def + 20) / 50.0 * level), (int) ((satt + 20) / 50.0 * level), (int) ((sdef + 20) / 50.0 * level), (int) ((spd + 20) / 50.0 * level), (int) ((health + 20) / 25.0 * level), level);
        setThreshold(55);
    }
    
    public void display()
    {
        setPicture("icagon.png");
    }
    
    public void transform(Monster[] myMonster)
    {
        myMonster[0] = new Adagon(level);
    }
    
    public void moves()
    {
        setMoves("Dragon Claw", "Aerial Ace", "Frost Breath", "Air Cutter", 80, 65, 80, 55);
    }
}
